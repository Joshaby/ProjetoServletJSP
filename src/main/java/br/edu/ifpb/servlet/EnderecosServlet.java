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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = {"/enderecos", "/enderecos/new", "/enderecos/edit", "/enderecos/del"})
public class EnderecosServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    // /enderecos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getRequestURI());

        if (request.getRequestURI().equals("/enderecos")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getParameter("cId"));
            Usuario usuario = usuarioRepository.findByEmail(email);
            Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
            Set<Endereco> enderecos = contato.getEnderecos();
            HttpSession session = request.getSession();
            session.setAttribute("cId", contato.getId());
            session.setAttribute("nomeUsuario", usuario.getNome());
            session.setAttribute("nomeContato", contato.getNome());
            session.setAttribute("enderecos", enderecos);
            response.sendRedirect("/enderecos.jsp");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/enderecos.jsp");
//            requestDispatcher.forward(request, response);
        }
    }

    // /enderecos/new
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rua = request.getParameter("rua");
        Integer numero = Integer.valueOf(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        Integer cep = Integer.valueOf(request.getParameter("cep"));
        String cidade = request.getParameter("cidade");
        String unidadeFederativa = request.getParameter("unidadeFederativa");
        Endereco endereco = new Endereco(UsuarioRepository.getEnderecoId(), rua, numero, complemento, bairro, cep
                , cidade, unidadeFederativa);
        String email = request.getSession().getAttribute("emailLog").toString();
        Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
        Usuario usuario = usuarioRepository.findByEmail(email);
        Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
        RequestDispatcher requestDispatcher = null;
        if (contato.addEndereco(endereco)) {
            response.sendRedirect("/enderecos.jsp");
        }
        else {
            System.out.println("Endereço já existe!!");
        }
    }
}
