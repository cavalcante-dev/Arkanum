package io.github.cavalcante_dev.Arkanum.repository;

import io.github.cavalcante_dev.Arkanum.entitys.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {
}
