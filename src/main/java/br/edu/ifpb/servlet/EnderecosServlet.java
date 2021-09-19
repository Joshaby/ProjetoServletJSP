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

@WebServlet(urlPatterns = {"/enderecos", "/enderecos/new", "/enderecos/edit", "/enderecos/form", "/enderecos/del"})
public class EnderecosServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    // /enderecos e /enderecos/form
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
            request.setAttribute("nomeUsuario", usuario.getNome());
            request.setAttribute("nomeContato", contato.getNome());
            request.setAttribute("enderecos", enderecos);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/enderecos.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getRequestURI().equals("/enderecos/form")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
            Integer eId = Integer.valueOf(request.getParameter("eId"));
            Usuario usuario = usuarioRepository.findByEmail(email);
            Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
            Endereco endereco = contato.getEnderecos().stream().filter(e -> e.getId().equals(eId)).findFirst().get();
            HttpSession session = request.getSession();
            session.setAttribute("endereco", endereco);
            response.sendRedirect("/editendereco.jsp");
        }
    }

    // /enderecos/new e /enderecos/edit
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getRequestURI().equals("/enderecos/new")) {
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
            HttpSession session = request.getSession();
            if (contato.addEndereco(endereco)) {
                session.setAttribute("nomeUsuario", usuario.getNome());
                session.setAttribute("nomeContato", contato.getNome());
                session.setAttribute("enderecos", contato.getEnderecos());
                response.sendRedirect("/enderecos.jsp");
            }
            else {
                System.out.println("Endereço já existe!!");
            }
        }
        if(request.getRequestURI().equals("/enderecos/edit")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
            Integer eId = Integer.valueOf(request.getParameter("eId"));
            Usuario usuario = usuarioRepository.findByEmail(email);
            Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
            Endereco endereco = contato.getEnderecos().stream().filter(e -> e.getId().equals(eId)).findFirst().get();
            String rua = request.getParameter("rua");
            Integer numero = Integer.valueOf(request.getParameter("numero"));
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            Integer cep = Integer.valueOf(request.getParameter("cep"));
            String cidade = request.getParameter("cidade");
            String unidadeFederativa = request.getParameter("unidadeFederativa");
            endereco.setRua(rua);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setBairro(bairro);
            endereco.setCep(cep);
            endereco.setCidade(cidade);
            endereco.setUnidadeFederativa(unidadeFederativa);
            HttpSession session = request.getSession();
            session.setAttribute("nomeUsuario", usuario.getNome());
            session.setAttribute("nomeContato", contato.getNome());
            session.setAttribute("enderecos", contato.getEnderecos());
            response.sendRedirect("/enderecos.jsp");
        }
    }
}
