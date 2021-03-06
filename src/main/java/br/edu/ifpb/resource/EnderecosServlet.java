package br.edu.ifpb.resource;

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
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@WebServlet(urlPatterns = {"/enderecos", "/enderecos/new", "/enderecos/edit", "/enderecos/form", "/enderecos/del"})
public class EnderecosServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().equals("/enderecos")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = 0;

            if (request.getParameter("cId") == null) {
                cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
            }
            else {
                cId = Integer.valueOf(request.getParameter("cId"));
            }

            Usuario usuario = usuarioRepository.findByEmail(email);

            if (Objects.nonNull(usuario)) {
                Integer finalCId = cId;
                Optional<Contato> contato = usuario.getContatos().stream().filter(c -> c.getId().equals(finalCId)).findFirst();

                if (contato.isPresent()) {
                    Set<Endereco> enderecos = contato.get().getEnderecos();

                    HttpSession session = request.getSession();
                    session.setAttribute("cId", contato.get().getId());

                    request.setAttribute("nomeUsuario", usuario.getNome());
                    request.setAttribute("nomeContato", contato.get().getNome());
                    request.setAttribute("enderecos", enderecos);

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/enderecos/page.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        }
        else if (request.getRequestURI().equals("/enderecos/form")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
            Integer eId = Integer.valueOf(request.getParameter("eId"));

            Usuario usuario = usuarioRepository.findByEmail(email);

            if (Objects.nonNull(usuario)) {
                Optional<Contato> contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst();

                if (contato.isPresent()) {
                    Optional<Endereco> endereco = contato.get().getEnderecos().stream().filter(e -> e.getId().equals(eId)).findFirst();

                    if (endereco.isPresent()) {
                        HttpSession session = request.getSession();
                        session.setAttribute("endereco", endereco.get());

                        response.sendRedirect("/enderecos/edit.jsp");
                    }
                }
            }
        }
        else if (request.getRequestURI().equals("/enderecos/del")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
            Integer eId = Integer.valueOf(request.getParameter("eId"));

            Usuario usuario = usuarioRepository.findByEmail(email);

            if (Objects.nonNull(usuario)) {
                Optional<Contato> contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst();

                if (contato.isPresent()) {
                    Optional<Endereco> endereco = contato.get().getEnderecos().stream().filter(e -> e.getId().equals(eId)).findFirst();

                    if (endereco.isPresent()) {
                        if (contato.get().removeEndereco(endereco.get())) {
                            HttpSession session = request.getSession();
                            session.setAttribute("cId", cId);
                            response.sendRedirect("/enderecos");
                        }
                    }
                }
            }
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

            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());

            Endereco endereco = new Endereco(
                    UsuarioRepository.getEnderecoId(), rua, numero, complemento, bairro, cep, cidade, unidadeFederativa);
            Usuario usuario = usuarioRepository.findByEmail(email);

            if (Objects.nonNull(usuario)) {
                Optional<Contato> contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst();

                if (contato.isPresent()) {
                    HttpSession session = request.getSession();

                    if (contato.get().addEndereco(endereco)) {
                        session.setAttribute("cId", contato.get().getId());
                        response.sendRedirect("/enderecos");
                    }
                    else {
                        request.setAttribute("rua", endereco.getRua());
                        request.setAttribute("numero", endereco.getNumero());
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errors/enderecoalreadyexists.jsp");
                        requestDispatcher.forward(request, response);
                    }
                }
            }
        }
        else if (request.getRequestURI().equals("/enderecos/edit")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getSession().getAttribute("cId").toString());
            Integer eId = Integer.valueOf(request.getParameter("eId"));

            Usuario usuario = usuarioRepository.findByEmail(email);

            if (Objects.nonNull(usuario)) {
                Optional<Contato> contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst();

                if (contato.isPresent()) {
                    Optional<Endereco> endereco = contato.get().getEnderecos().stream().filter(e -> e.getId().equals(eId)).findFirst();

                    if (endereco.isPresent()) {
                        String rua = request.getParameter("rua");
                        Integer numero = Integer.valueOf(request.getParameter("numero"));
                        String complemento = request.getParameter("complemento");
                        String bairro = request.getParameter("bairro");
                        Integer cep = Integer.valueOf(request.getParameter("cep"));
                        String cidade = request.getParameter("cidade");
                        String unidadeFederativa = request.getParameter("unidadeFederativa");

                        endereco.get().setRua(rua);
                        endereco.get().setNumero(numero);
                        endereco.get().setComplemento(complemento);
                        endereco.get().setBairro(bairro);
                        endereco.get().setCep(cep);
                        endereco.get().setCidade(cidade);
                        endereco.get().setUnidadeFederativa(unidadeFederativa);

                        HttpSession session = request.getSession();
                        session.setAttribute("cId", cId);
                        response.sendRedirect("/enderecos");
                    }
                }
            }
        }
    }
}
