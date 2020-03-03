package servlet;

import service.UserService;
import service.UserServiceImp;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class UserAddServlet extends HttpServlet {
    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImp.getInstance();
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");
        User newUser = new User(email,name, surname, password, birthday);
        serv.addUser(newUser);
        res.sendRedirect("/");
    }
}

















