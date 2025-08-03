package io.github.cavalcante_dev.Arkanum.config;

import io.github.cavalcante_dev.Arkanum.entitys.Role;
import io.github.cavalcante_dev.Arkanum.entitys.User;
import io.github.cavalcante_dev.Arkanum.repository.RoleRepository;
import io.github.cavalcante_dev.Arkanum.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    public RoleRepository roleRepository;
    public UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());

        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setName(Role.Values.ADMIN.name());
            roleRepository.save(roleAdmin);
        }

        var userAdmin = userRepository.findByUsername("admin");

        Role finalRoleAdmin = roleAdmin;

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("Admin já existe");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("2569"));
                    user.setRole(Set.of(finalRoleAdmin));
                    userRepository.save(user);
                }
        );

    }
}
