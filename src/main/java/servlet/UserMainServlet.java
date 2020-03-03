package servlet;

import model.User;
import service.UserService;
import service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class UserMainServlet extends HttpServlet {
    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImp.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws ServletException, IOException {
        List<User> user = serv.getAllUser();
        req.setAttribute("users", user);
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, res);
    }
}
















