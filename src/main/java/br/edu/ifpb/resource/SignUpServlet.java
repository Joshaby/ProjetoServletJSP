package br.edu.ifpb.resource;

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
import java.util.HashSet;
import java.util.Objects;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (!Objects.nonNull(usuario)) {
            usuarioRepository.add(nome, email, senha);

            HttpSession session = request.getSession();
            session.setAttribute("nome", nome);
            session.setAttribute("contatos", new HashSet<>());
            session.setAttribute("emailLog", email);

            response.sendRedirect("/contatos");
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errors/emailalreadyexists.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
