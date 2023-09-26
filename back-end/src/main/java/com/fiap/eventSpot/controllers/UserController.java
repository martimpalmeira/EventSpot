package com.fiap.eventSpot.controllers;

import com.fiap.eventSpot.model.Event;
import com.fiap.eventSpot.model.User;
import com.fiap.eventSpot.repositories.UserRepository;
import com.fiap.eventSpot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obterUsuarioPorId(@PathVariable Long id) {
        Optional<User> usuario = userService.obterUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> criarUsuario(@RequestBody User usuario) {
        User novoUsuario = userService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable Long id, @RequestBody User novoUsuario) {
        Optional<User> usuarioAtualizado = userService.atualizarUsuario(id, novoUsuario);
        return usuarioAtualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        userService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/events")
    public Set<Event> getUserEvents(@PathVariable Long userId) {
        User user = userService.obterUsuarioPorId(userId).orElse(null);

        if (user != null) {
            return user.getAttendedEvents();
        }

        return null; // Ou lançar uma exceção, dependendo do seu cenário
    }
}
