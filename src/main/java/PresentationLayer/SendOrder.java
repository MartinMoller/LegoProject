/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author martin
 */
public class SendOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        LogicFacade.sendOrder(Integer.parseInt(request.getParameter("id")));
        HttpSession session = request.getSession();
        ArrayList<Order> orders = LogicFacade.getAllOrders();
        request.setAttribute("orders", orders);

        return "viewAllOrders";
    }

}
