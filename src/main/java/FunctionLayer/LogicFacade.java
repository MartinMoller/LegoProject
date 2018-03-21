package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public static void sendOrder(int id) throws LoginSampleException{
        OrderMapper.sendOrder(id);
    }
    
    public static ArrayList<Order> getAllOrders() throws  LoginSampleException{
        return OrderMapper.getAllOrders();
    }

}
