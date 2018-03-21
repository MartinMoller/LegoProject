/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FunctionLayer.Order;

/**
 *
 * @author martin
 */
public class ViewUsersOrders extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        ArrayList<Order> orders = LogicFacade.getUsersOrders(userId);
        request.setAttribute("orders", orders);
        
        return "viewUsersOrders";
    }
    
}
