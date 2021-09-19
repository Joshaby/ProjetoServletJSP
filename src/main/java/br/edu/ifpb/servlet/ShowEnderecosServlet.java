package br.edu.ifpb.servlet;

import br.edu.ifpb.domain.Contato;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.repository.UsuarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = {"/enderecos", "/enderecos/new"})
public class ShowEnderecosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getRequestURI());

        String email = request.getSession().getAttribute("emailLog").toString();
        Integer cId = Integer.valueOf(request.getParameter("cId"));
        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        Usuario usuario = usuarioRepository.findByEmail(email);
        Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
        Set<Endereco> enderecos = contato.getEnderecos();
        request.setAttribute("nomeUsuario", usuario.getNome());
        request.setAttribute("nomeContato", contato.getNome());
        request.setAttribute("cId", contato.getId());
        request.setAttribute("enderecos", enderecos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/enderecos.jsp");
        requestDispatcher.forward(request, response);
    }
}
