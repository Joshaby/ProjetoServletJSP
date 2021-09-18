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

@WebServlet("/cadastrarContato")
public class CadastroContatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");

        //System.out.println(" rg" + rg + " cpf" + cpf + " nome" +  nome);

        if(cep.isBlank()|| rua.isBlank() || numero.isBlank()
                || bairro.isBlank() || cidade.isBlank() || uf.isBlank()) {
            System.out.println("teste" );
            RequestDispatcher rd = request.getRequestDispatcher("/invalidAdress.jsp");

        }
        else {
            Integer rgInteger = Integer.valueOf(rg);
            Integer cpfInteger = Integer.valueOf(cpf);
            Integer cepInteger = Integer.valueOf(cep);
            Integer numeroInteger = Integer.valueOf(numero);

            String emailLog = (String) request.getSession().getAttribute("emailLog");
            UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
            Endereco endereco = new Endereco(UsuarioRepository.getUsuarioId(), rua,numeroInteger,complemento,bairro,cepInteger,cidade,uf);
            Contato contato = new Contato(UsuarioRepository.getContatoId(), nome,rgInteger,cpfInteger,endereco);
            Usuario u = usuarioRepository.findByEmail(emailLog);
            u.addContato(contato);
            u.getContatos().stream().forEach(System.out::println);
            response.sendRedirect("/listarContatos");

        }








    }

}
