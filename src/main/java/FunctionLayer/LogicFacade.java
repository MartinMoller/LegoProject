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

    public static void createOrder(int length, int width, int height, int userId, int status, boolean door, boolean window) throws OrderErrorException {
        Order order = new Order(length, width, height, userId, status, door, window);
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
        bricks.put("door", new ArrayList<Brick>());
        bricks.put("window", new ArrayList<Brick>());

        Brick small = new Brick(2, 1);
        Brick medium = new Brick(2, 2);
        Brick large = new Brick(2, 4);
        Brick door = new Brick(6, 4);
        Brick window = new Brick(4, 4);

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        boolean isDoor = order.getDoor();
        boolean isWindow = order.getWindow();
        
        if(isDoor && height >= 6){
            bricks.get("door").add(door);
        }
        if(isWindow && height >= 4){
            bricks.get("window").add(window);
        }

        //Length wall
        while (length != 0) {
            //adds small brick
            length--;
            bricks.get("2x1length").add(small);

            //builds rest of wall
            if (length != 0) {
                for (int i = 0; i < (length / large.getLength()); i++) {
                    bricks.get("2x4length").add(large);
                }
                length = length % large.getLength();
            }
            if (length != 0) {
                for (int i = 0; i < (length / medium.getLength()); i++) {
                    bricks.get("2x2length").add(medium);
                }
                length = length % medium.getLength();
            }

            if (length != 0) {
                for (int i = 0; i < (length / small.getLength()); i++) {
                    bricks.get("2x1length").add(small);
                }
                length = length % small.getLength();
            }

        }

        //Width wall
        width = width - 4;
        while (width != 0) {
            //adds small brick
            width--;
            bricks.get("2x1width").add(small);
            
            //Builds rest of wall
            if (width != 0) {
                for (int i = 0; i < (width / large.getLength()); i++) {
                    bricks.get("2x4width").add(large);
                }
                width = width % large.getLength();
            }
            if (width != 0) {
                for (int i = 0; i < (width / medium.getLength()); i++) {
                    bricks.get("2x2width").add(medium);
                }
                width = width % medium.getLength();
            }

            if (width != 0) {
                for (int i = 0; i < (width / small.getLength()); i++) {
                    bricks.get("2x1width").add(small);
                }
                width = width % small.getLength();
            }

        }

        return bricks;

    }

}
