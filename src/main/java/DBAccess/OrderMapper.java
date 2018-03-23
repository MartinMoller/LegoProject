/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class OrderMapper {

    public static void createOrder(Order order) throws LoginSampleException {
        try {

            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders (length, width, height, fk_userId, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getHeight());
            ps.setInt(4, order.getUserId());
            ps.setInt(5, order.getStatus());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getUsersOrders(int userId) throws LoginSampleException {
        try {
            ArrayList<Order> orders = new ArrayList<>();
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE fk_userId = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int status = rs.getInt("status");
                orders.add(new Order(id, length, width, height, userId, status));

            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static void sendOrder(int id) throws LoginSampleException {
        try {
            Connection conn = Connector.connection();
            String SQL = "UPDATE Orders SET status = 1 WHERE id =?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
        try {
            ArrayList<Order> orders = new ArrayList<>();
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM Orders";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int status = rs.getInt("status");
                int userId = rs.getInt("fk_userId");
                orders.add(new Order(id, length, width, height, userId, status));

            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static Order getOrder(int id) throws LoginSampleException {
        try {
            Order order = null;
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int status = rs.getInt("status");
                int userId = rs.getInt("fk_userId");
                order = new Order(id, length, width, height, userId, status);
            }
            return order;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }
}
