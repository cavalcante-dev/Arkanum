package io.github.cavalcante_dev.Arkanum.repository;

import io.github.cavalcante_dev.Arkanum.entitys.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterSheetRepository extends JpaRepository<CharacterSheet, Long> {
    List<CharacterSheet> findAllByUserUserID(UUID userID);
}
