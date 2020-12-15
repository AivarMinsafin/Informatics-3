package ru.itis.aivar.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class NoEdgeUserFilter extends HttpFilter {
    final String[] edgeBrowser = {"Edg", "Edge", "IE"};

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
       String browserName = req.getHeader("User-Agent");
        for (String b: edgeBrowser) {
            if (browserName.contains(b)){
                System.out.println("Browser: error");
                getServletContext().getRequestDispatcher("/edgeError.html").forward(req, res);
            }
        }
        System.out.println("Browser: ok!");
        chain.doFilter(req, res);
    }
}
