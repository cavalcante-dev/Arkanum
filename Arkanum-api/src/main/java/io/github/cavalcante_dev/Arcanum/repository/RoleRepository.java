package io.github.cavalcante_dev.Arcanum.repository;

import io.github.cavalcante_dev.Arcanum.entitys.Role;
import io.github.cavalcante_dev.Arcanum.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
