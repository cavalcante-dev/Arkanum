package io.github.cavalcante_dev.Arkanum.controller;

import java.util.List;
import java.util.Set;

import io.github.cavalcante_dev.Arkanum.controller.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import io.github.cavalcante_dev.Arkanum.controller.dto.CreateUserDTO;
import io.github.cavalcante_dev.Arkanum.entitys.Role;
import io.github.cavalcante_dev.Arkanum.entitys.User;
import io.github.cavalcante_dev.Arkanum.repository.RoleRepository;
import io.github.cavalcante_dev.Arkanum.repository.UserRepository;
import jakarta.transaction.Transactional;

// Controlador de funções do usuário, tudo relacionado a edição e cadastro estará aqui.

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    
    // Construtor de Classe

    public UserController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Função de cadastro de usuário no sistema.

    @Transactional
    @PostMapping("/cadastro/newuser")
    public ResponseEntity<LoginResponse> newUser(@RequestBody CreateUserDTO dto) {

        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());

        if (basicRole == null) {
            basicRole = new Role();
            basicRole.setName(Role.Values.BASIC.name());
            roleRepository.save(basicRole);
        }

        var userFromDb = userRepository.findByUsername(dto.username());

        if (userFromDb.isPresent()){
            System.out.println("Usuário já cadastrado");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = new User();
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setName(dto.name());
        user.setRole(Set.of(basicRole));

        userRepository.save(user);

        return ResponseEntity.ok().build();

    }

    // Função de listar todos os usuários cadastrados, usados apenas por admins.

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public ResponseEntity<List<User>> listUsers() {
        var users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
