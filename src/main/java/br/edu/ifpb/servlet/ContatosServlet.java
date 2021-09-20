package br.edu.ifpb.servlet;

import br.edu.ifpb.domain.Contato;
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

@WebServlet(urlPatterns = {"/home", "/contatos/edit", "/contatos/form","/contatos/delete"})
public class ContatosServlet extends HttpServlet {

    private final UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    // /home e /contatos/edit
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().equals("/home")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getRequestURI().equals("/contatos/form")) {
            String email = request.getSession().getAttribute("emailLog").toString();
            Integer cId = Integer.valueOf(request.getParameter("cId"));
            Usuario usuario = usuarioRepository.findByEmail(email);
            Contato contato = usuario.getContatos().stream().filter(c -> c.getId().equals(cId)).findFirst().get();
            HttpSession session = request.getSession();
            session.setAttribute("contato", contato);
            response.sendRedirect("/editcontato.jsp");
        }
        if(request.getRequestURI().equals("/contatos/delete")){
            System.out.println("entrou aqui");
            String emailLogado = (String) request.getSession().getAttribute("emailLog");
            UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
            Usuario usuario = usuarioRepository.findByEmail(emailLogado);

            Integer idContato = Integer.valueOf(request.getParameter("cId"));
            Optional<Contato> c = usuario.getContatos().stream().filter(contato -> contato.getId().equals(idContato)).findFirst();

            if(c.isPresent()){
                System.out.println("entrou aqui2");
                usuario.removerContato(c.get());
                response.sendRedirect("/home");
            }


        }
    }

    // /contatos/form
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
    }

//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        if(request.getRequestURI().equals("/contatos/delete")){
//            System.out.println("entrou aqui");
//            String emailLogado = (String) request.getSession().getAttribute("emailLog");
//            UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
//            Usuario usuario = usuarioRepository.findByEmail(emailLogado);
//
//            Integer idContato = Integer.valueOf(request.getParameter("cId"));
//            Optional<Contato> c = usuario.getContatos().stream().filter(contato -> contato.getId().equals(idContato)).findFirst();
//
//            if(c.isPresent()){
//                System.out.println("entrou aqui");
//                usuario.removerContato(c.get());
//                response.sendRedirect("/home");
//            }
//
//
//        }
//    }
}
