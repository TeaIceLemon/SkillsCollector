package pl.github.teaicelemon.skillcollector.servlets;

import org.hibernate.SessionFactory;
import pl.github.teaicelemon.skillcollector.listeners.HibernateInitializer;
import pl.github.teaicelemon.skillcollector.model.dao.UserDao;
import pl.github.teaicelemon.skillcollector.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;
    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = (SessionFactory) getServletContext().getAttribute(HibernateInitializer.SESSION_FACTORY);
        userDao = new UserDao(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("getting users from DB");
        List<User> userList = userDao.getAllByUsernameAndPassword(username, password);
        if(userList.isEmpty()){
            System.out.println("wrong username used or wrong password");
            req.setAttribute("error", "Wrong username OR password");
            req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            return;
        }
        System.out.println("destroying session");
        req.getSession().invalidate();
        System.out.println("Creating new session");
        HttpSession session = req.getSession(true);
        User user = userList.iterator().next();
        req.setAttribute("User" , user);
        System.out.println("Sending redirect");
        resp.sendRedirect("/user/skills");

    }
}
