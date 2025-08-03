package io.github.cavalcante_dev.Arcanum.repository;

import io.github.cavalcante_dev.Arcanum.entitys.CharacterSheet;
import io.github.cavalcante_dev.Arcanum.entitys.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {
}
