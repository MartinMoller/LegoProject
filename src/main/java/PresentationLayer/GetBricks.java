/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Brick;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martin
 */
public class GetBricks extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int id = Integer.parseInt(request.getParameter("id"));
        HashMap<String, ArrayList<Brick>> bricks = LogicFacade.getBricks(id);
        int height = LogicFacade.getOrder(id).getHeight();
        
        request.getSession().setAttribute("height", height);
        request.getSession().setAttribute("bricks", bricks);
        
        return "bricks";
    }
    
}
