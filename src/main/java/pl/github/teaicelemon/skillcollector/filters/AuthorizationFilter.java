package pl.github.teaicelemon.skillcollector.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {
    private Set<String> unauthorizedPaths = new HashSet<>();
    private Set<String> authorizedPaths = new HashSet<>();

    @Override
    public void init() throws ServletException {
        unauthorizedPaths.add("/registr");
        unauthorizedPaths.add("/login");

        authorizedPaths.add("/user/skills");
        authorizedPaths.add("/logout");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String path = req.getServletPath();
        if(unauthorizedPaths.contains(path)){
            chain.doFilter(req,res);
        }else if(authorizedPaths.contains(path)){
            HttpSession httpSession = req.getSession();
            if(req.getAttribute("user") != null){
                chain.doFilter(req,res);
            }
            else {
                res.sendRedirect("/login");
            }
        }else{
            throw new ServletException("Not mapped path: " + path + ".  CRASH" );
        }
    }
}
