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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/edit")
public class UserEditServlet extends HttpServlet {
    private UserService serv;

    @Override
    public void init() throws ServletException {
        serv = UserServiceImp.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        List<User> newUser = new ArrayList<>();
        newUser.add(serv.getUserById(id));
        req.setAttribute("user", newUser);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User newUser = new User();
        newUser.setId(Long.parseLong(req.getParameter("id")));
        newUser.setEmail(req.getParameter("email"));
        newUser.setName(req.getParameter("name"));
        newUser.setSurname(req.getParameter("surname"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setBirthday(req.getParameter("birthday"));
        serv.updateUser(newUser);
        res.sendRedirect("/");
    }
}

















