package br.edu.ifpb.servlet;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.repository.UsuarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        RequestDispatcher requestDispatcher = null;
        request.setAttribute("email", email);
        if (!Objects.nonNull(usuario)) {
            usuarioRepository.add(nome, email, senha);
            request.setAttribute("email", email);
            request.setAttribute("nome", nome);
            request.setAttribute("contatos", new HashSet<>());
            requestDispatcher = request.getRequestDispatcher("/home.jsp");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("/emailalreadyexists.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}
