package br.edu.ifpb.repository;

import br.edu.ifpb.domain.Usuario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UsuarioRepository {

    private static UsuarioRepository instance;

    private Set<Usuario> usuarios;

    private UsuarioRepository() {
        this.usuarios = new HashSet<>();
    }

    public static synchronized UsuarioRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UsuarioRepository();
        }
        return instance;
    }
}
