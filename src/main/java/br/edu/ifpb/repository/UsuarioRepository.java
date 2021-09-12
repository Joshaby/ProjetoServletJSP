package br.edu.ifpb.repository;

import br.edu.ifpb.domain.Usuario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UsuarioRepository {

    private static UsuarioRepository instance;
    private static Integer idGenerator = 0;

    private Set<Usuario> usuarios;

    private UsuarioRepository() {
        this.usuarios = new HashSet<>();
        Usuario usuario = new Usuario(1, "José Henrique", "josehenriquebrito55@gmail.com", "123456");
        Usuario usuario1 = new Usuario(2, "Henrique Brito", "henriquebrito@gmail.com", "123456");
        Usuario usuario2 = new Usuario(3, "Érica Clementino", "ericaclementino@gmail.com", "123456");
        Usuario usuario3 = new Usuario(4, "Ítalo Nevez", "italogostosinhopegador2010@live.com.br", "123456");
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
        Usuario usuario = new Usuario(idGenerator ++, nome, email, senha);
        return usuarios.add(usuario);
    }

    public Usuario find(Integer id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public Usuario findByEmail(String email) {
        return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    public boolean delete(Integer id) {
        Usuario usuario = find(id);
        if (Objects.nonNull(usuario)) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
}
