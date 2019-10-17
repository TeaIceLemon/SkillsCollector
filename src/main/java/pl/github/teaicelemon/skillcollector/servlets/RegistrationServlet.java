package pl.github.teaicelemon.skillcollector.servlets;

import org.hibernate.SessionFactory;
import pl.github.teaicelemon.skillcollector.listeners.HibernateInitializer;
import pl.github.teaicelemon.skillcollector.model.dao.UserDao;
import pl.github.teaicelemon.skillcollector.model.entity.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = (SessionFactory) getServletContext().getAttribute(HibernateInitializer.SESSION_FACTORY);
        userDao = new UserDao(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        // Checking if User Name is already taken
        if(userDao.isUsernameAvailable(userName)){
            User user = new User();
            user.setUsername(userName);
            user.setPassword(password);
            user.setFistname(firstName);
            user.setLastname(lastName);
            userDao.save(user);
            resp.sendRedirect("/login");
        }else{
            req.setAttribute("error" , "Username is already taken");
            System.out.println("setting error attribute : true");
            req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
            return;
        }
    }
}
