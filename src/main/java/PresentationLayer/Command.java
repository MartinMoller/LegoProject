package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("help", new Help());
        commands.put("home", new Home());
        commands.put("logout", new LogOut());
        commands.put("order", new CreateOrder());
        commands.put("orderpage", new OrderPage());
        commands.put("vieworders", new ViewUsersOrders());
        commands.put("sendorder", new SendOrder());
        commands.put("viewallorders", new ViewAllOrders());
        commands.put("getbricks", new GetBricks());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;

}
