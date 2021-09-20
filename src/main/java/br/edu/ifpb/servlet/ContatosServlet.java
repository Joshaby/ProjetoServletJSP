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
import java.util.Optional;

@WebServlet(urlPatterns = {"/home", "/contatos/new", "/contatos/edit", "/contatos/form","/contatos/del"})
public class ContatosServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().equals("/home")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (request.getRequestURI().equals("/contatos/form")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getParameter("cId"));

            Usuario usuario = usuarioRepository.findByEmail(email);
            Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();

            HttpSession session = request.getSession();
            session.setAttribute("contato", contato);

            response.sendRedirect("/editcontato.jsp");
        }
        else if(request.getRequestURI().equals("/contatos/del")){
            String emailLogado = (String) request.getSession().getAttribute("emailLog");
            Integer idContato = Integer.valueOf(request.getParameter("cId"));

            UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
            Usuario usuario = usuarioRepository.findByEmail(emailLogado);
            Optional<Contato> contato = usuario.getContatos().stream().filter(c -> c.getId().equals(idContato)).findFirst();

            if (contato.isPresent()) {
                usuario.removerContato(contato.get());
                response.sendRedirect("/home");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().equals("/contatos/edit")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getParameter("cId"));
            Usuario usuario = usuarioRepository.findByEmail(email);
            Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
            String nome = request.getParameter("nome");
            Integer rg = Integer.valueOf(request.getParameter("rg"));
            Integer cpf = Integer.valueOf(request.getParameter("cpf"));

            contato.setNome(nome);
            contato.setRg(rg);
            contato.setCpf(cpf);

            HttpSession session = request.getSession();
            session.setAttribute("nome", usuario.getNome());
            session.setAttribute("contatos", usuario.getContatos());
            session.setAttribute("emailLog", email);

            response.sendRedirect("/home");
        }
        else if (request.getRequestURI().equals("/contatos/new")) {
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String cep = request.getParameter("cep");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("unidadeFederativa");

            if (cep.isBlank()|| rua.isBlank() || numero.isBlank() || bairro.isBlank() || cidade.isBlank() || uf.isBlank()) {
                System.out.println("teste" );
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/invalidaddress.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                Integer rgInteger = Integer.valueOf(rg);
                Integer cpfInteger = Integer.valueOf(cpf);
                Integer cepInteger = Integer.valueOf(cep);
                Integer numeroInteger = Integer.valueOf(numero);
                String emailLog = (String) request.getSession().getAttribute("emailLog");

                UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
                Endereco endereco = new Endereco(
                        UsuarioRepository.getEnderecoId(), rua, numeroInteger, complemento, bairro, cepInteger, cidade, uf);
                Contato contato = new Contato(
                        UsuarioRepository.getContatoId(), nome, rgInteger, cpfInteger, endereco);
                Usuario u = usuarioRepository.findByEmail(emailLog);
                u.addContato(contato);

                response.sendRedirect("/home");
            }
        }
    }
}
