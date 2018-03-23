package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static void createOrder(int length, int width, int height, int userId, int status) throws LoginSampleException {
        Order order = new Order(length, width, height, userId, status);
        OrderMapper.createOrder(order);
    }

    public static ArrayList<Order> getUsersOrders(int userId) throws LoginSampleException {
        return OrderMapper.getUsersOrders(userId);
    }

    public static void sendOrder(int id) throws LoginSampleException {
        OrderMapper.sendOrder(id);
    }

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
        return OrderMapper.getAllOrders();
    }

    public static Order getOrder(int id) throws LoginSampleException {
        return OrderMapper.getOrder(id);
    }

    public static HashMap<String, ArrayList<Brick>> getBricks(int id) throws LoginSampleException {
        Order order = getOrder(id);
        HashMap<String, ArrayList<Brick>> bricks = new HashMap<>();
        bricks.put("2x1length", new ArrayList<Brick>());
        bricks.put("2x2length", new ArrayList<Brick>());
        bricks.put("2x4length", new ArrayList<Brick>());
        bricks.put("2x1width", new ArrayList<Brick>());
        bricks.put("2x2width", new ArrayList<Brick>());
        bricks.put("2x4width", new ArrayList<Brick>());

        Brick small = new Brick(2, 1);
        Brick medium = new Brick(2, 2);
        Brick large = new Brick(2, 4);

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        //Length wall
        //First line
        while (length != 0) {
            for (int i = 0; i < (length / large.getLength()); i++) {
                bricks.get("2x4length").add(large);
            }
            length = length % large.getLength();
            if (length != 0) {
                for (int i = 0; i < (length / medium.getLength()); i++) {
                    bricks.get("2x2length").add(medium);
                }
            }
            length = length % medium.getLength();
            if (length != 0) {
                for (int i = 0; i < (length / small.getLength()); i++) {
                    bricks.get("2x1length").add(small);
                }
            }
            length = length % small.getLength();
        }

        //Second line
        if (height > 1) {
            length = order.getLength();
            while (length != 0) {
                if (length != 0) {
                    for (int i = 0; i < (length / medium.getLength()); i++) {
                        bricks.get("2x2length").add(medium);
                    }
                }
                length = length % medium.getLength();
                if (length != 0) {
                    for (int i = 0; i < (length / small.getLength()); i++) {
                        bricks.get("2x1length").add(small);
                    }
                }
                length = length % small.getLength();
            }
        }

        //Width wall
        //first line
        width = width-4;
        while (width != 0) {
            for (int i = 0; i < (width / large.getLength()); i++) {
                bricks.get("2x4width").add(large);
            }
            width = width % large.getLength();
            if (width != 0) {
                for (int i = 0; i < (width / medium.getLength()); i++) {
                    bricks.get("2x2width").add(medium);
                }
            }
            width = width % medium.getLength();
            if (width != 0) {
                for (int i = 0; i < (width / small.getLength()); i++) {
                    bricks.get("2x1width").add(small);
                }
            }
            width = width % small.getLength();
        }

        //Second line
        if (height > 1) {
            width = order.getWidth() -4;
            while (width != 0) {
                if (width != 0) {
                    for (int i = 0; i < (width / medium.getLength()); i++) {
                        bricks.get("2x2width").add(medium);
                    }
                }
                width = width % medium.getLength();
                if (width != 0) {
                    for (int i = 0; i < (width / small.getLength()); i++) {
                        bricks.get("2x1width").add(small);
                    }
                }
                width = width % small.getLength();
            }
        }

        return bricks;

    }

}
