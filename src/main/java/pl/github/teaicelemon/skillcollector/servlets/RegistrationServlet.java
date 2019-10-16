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
        User user = new User(userName, password);
        user.setFistname(firstName);
        user.setLastname(lastName);
        // Checking if User Name is already taken
        if(userDao.isUsernameAvailable(userName)){
            userDao.save(user);
            resp.sendRedirect("/login");
        }else{
//            req.getRequestDispatcher("WEB-INF/views/fragmented/errorPageUser.jsp").include(req,resp);
            resp.getWriter().println(errorPage());

            resp.sendRedirect("/register");
        }
    }
    private String errorPage(){
        StringBuilder sB = new StringBuilder();
        sB.append("<html>")
                .append("<head>")
                .append("<p> Username is taken")
                .append("</head>")
                .append("</html>");

        return sB.toString();
    }
}
