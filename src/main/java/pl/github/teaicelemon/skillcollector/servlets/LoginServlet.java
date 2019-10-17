package pl.github.teaicelemon.skillcollector.servlets;

import org.hibernate.SessionFactory;
import pl.github.teaicelemon.skillcollector.listeners.HibernateInitializer;
import pl.github.teaicelemon.skillcollector.model.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;
    @Override
    public void init() throws ServletException {
        UserDao userDao = new UserDao((SessionFactory) getServletContext().getAttribute(HibernateInitializer.SESSION_FACTORY));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

       ;
       Boolean logPassConfirm = new Boolean(null);
        userDao.getAllByUsernameAndPassword(userName, password).forEach(user -> {
            if(user.getUsername().equals(userName) && user.getPassword().equals(password)){
                logPassConf.
            }else logPassConf.set(false);
        } );

    }
}
