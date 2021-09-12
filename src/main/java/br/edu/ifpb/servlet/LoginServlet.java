package br.edu.ifpb.servlet;

import br.edu.ifpb.repository.UsuarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        System.out.println(email + ' ' + senha);
        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        if (Objects.nonNull(usuarioRepository.findByEmail(email))) {

        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/invalidemail.jsp");
            request.setAttribute("email", email);
            requestDispatcher.forward(request, response);
        }
    }
}
