package com.fiap.eventSpot.services;

import com.fiap.eventSpot.model.User;
import com.fiap.eventSpot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;


    public List<User> listarUsuarios() {
        return usuarioRepository.findAll();
    }


    public Optional<User> obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }


    public User criarUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }


    public Optional<User> atualizarUsuario(Long id, User novoUsuario) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setName(novoUsuario.getName());
                    usuarioExistente.setEmail(novoUsuario.getEmail());
                    return usuarioRepository.save(usuarioExistente);
                });
    }


    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }



}
