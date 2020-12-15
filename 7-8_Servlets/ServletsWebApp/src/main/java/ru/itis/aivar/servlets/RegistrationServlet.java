package ru.itis.aivar.servlets;

import ru.itis.aivar.models.User;
import ru.itis.aivar.repository.UserRepository;
import ru.itis.aivar.repository.UserRepositoryCsv;
import ru.itis.aivar.utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {
    UserRepository userRepository = new UserRepositoryCsv();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("status") != null){
            if (req.getParameter("status").equals("1")){
                req.setAttribute("message", "User has been created.");
            }
        }
        getServletContext().getRequestDispatcher("/jsp/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        Validator validator = new Validator();
        if (
                req.getParameter("login") != null &&
                req.getParameter("password") != null &&
                req.getParameter("email") != null &&
                req.getParameter("agreement") != null
        ) {
            String email = req.getParameter("email");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String passConfirm = req.getParameter("conf_password");
            if (password.equals(passConfirm) && validator.validatePassword(password) && validator.validateEmail(email)){
                User user = new User(login, email, password);
                userRepository.add(user);
                resp.sendRedirect(req.getRequestURI()+"?status=1");
                return;
            } else {
                System.out.println(validator.validatePassword(password));
                System.out.println(validator.validateEmail(email));
                errors.add("");
            }
        } else {
            errors.add("");
        }
        getServletContext().getRequestDispatcher("/jsp/signup.jsp").forward(req, resp);
    }
}
