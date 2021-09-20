package br.edu.ifpb.servlet;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.repository.UsuarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        HttpSession session = request.getSession();

        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        Usuario usuario = usuarioRepository.findByEmail(email);

        RequestDispatcher requestDispatcher = null;
        if (Objects.nonNull(usuario)) {
            if (usuario.getSenha().equals(senha)) {
                session.setAttribute("nome", usuario.getNome());
                session.setAttribute("contatos", usuario.getContatos());
                session.setAttribute("emailLog", email);

                response.sendRedirect("/home");
            }
            else {
                response.sendRedirect("/invalidpassword.jsp");
            }
        }
        else {
            session.setAttribute("emailLog", email);
            response.sendRedirect("/invalidemail.jsp");
        }
    }
}
