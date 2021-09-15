package br.edu.ifpb.repository;

import br.edu.ifpb.domain.Contato;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.domain.Usuario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UsuarioRepository {

    private static UsuarioRepository instance;

    private Set<Usuario> usuarios;

    private UsuarioRepository() {
        this.usuarios = new HashSet<>();
        Usuario usuario = new Usuario("José Henrique", "josehenriquebrito55@gmail.com", "123456");
        Usuario usuario1 = new Usuario("Henrique Brito", "henriquebrito@gmail.com", "123456");
        Usuario usuario2 = new Usuario("Érica Clementino", "ericaclementino@gmail.com", "123456");
        Usuario usuario3 = new Usuario("Ítalo Neves", "italo.neves@gmail.com", "123456");

        Endereco endereco = new Endereco(
                "Rua Aurealuz Maciel de Lima", 181, "Casa", "Três Irmãs",
                58423163, "Campina Grande", "PB");
        Contato contato = new Contato("Henrique Brito Henrique Brito Henrique Brito Henrique Brito", 123456, 123456, endereco);
        usuario.addContato(contato);

        Endereco endereco1 = new Endereco(
                "Rua Aurealuz Maciel de Lima", 184, "Casa", "Três Irmãs",
                58423163, "Campina Grande", "PB");
        Contato contato1 = new Contato("Henrique Brito", 123456, 123457, endereco1);
        usuario1.addContato(contato1);

        Endereco endereco2 = new Endereco(
                "Rua Aurealuz Maciel de Lima", 186, "Casa", "Três Irmãs",
                58423163, "Campina Grande", "PB");
        Contato contato2 = new Contato("Henrique Brito", 123456, 123458, endereco2);
        usuario.addContato(contato2);
        usuario1.addContato(contato1);

        Endereco endereco3 = new Endereco(
                "Rua Aurealuz Maciel de Lima", 183, "Casa", "Três Irmãs",
                58423163, "Campina Grande", "PB");
        Contato contato3 = new Contato("Henrique Brito", 123456, 123459, endereco3);
        usuario3.addContato(contato3);

        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }

    public static synchronized UsuarioRepository getInstance() {
        if (Objects.isNull(instance)) instance = new UsuarioRepository();
        return instance;
    }

    public boolean add(String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        return usuarios.add(usuario);
    }

    public boolean addContato(
            String email, String nome, Integer rg, Integer cpf, String rua, Integer numero,
            String complemento, String bairro, Integer cep, String cidade, String unidadeFederariva) {

        Usuario usuario = findByEmail(email);
        if (Objects.nonNull(usuario)) {
            Endereco endereco = new Endereco(rua, numero, complemento, bairro, cep, cidade, unidadeFederariva);
            Contato contato = new Contato(nome, rg, cpf, endereco);
            return usuario.addContato(contato);
        }
        return false;
    }

    public Usuario findByEmail(String email) {
        return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    public boolean delete(String email) {
        Usuario usuario = findByEmail(email);
        if (Objects.nonNull(usuario)) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
}
