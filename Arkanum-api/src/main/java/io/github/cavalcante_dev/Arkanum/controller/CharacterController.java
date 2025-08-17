package io.github.cavalcante_dev.Arkanum.controller;

import io.github.cavalcante_dev.Arkanum.controller.dto.CreatCharacterDTO;
import io.github.cavalcante_dev.Arkanum.entitys.CharacterSheet;
import io.github.cavalcante_dev.Arkanum.repository.CharacterSheetRepository;
import io.github.cavalcante_dev.Arkanum.repository.UserRepository;
import io.github.cavalcante_dev.Arkanum.services.SpellsSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

// Controladores de personagem - mds isso vai dar uma trabalheira.

@RestController
public class CharacterController {

    private final CharacterSheetRepository characterSheetRepository;
    private final UserRepository userRepository;
    @Autowired
    private SpellsSlots spellsSlots;

    public CharacterController(CharacterSheetRepository characterSheetRepository,
                               UserRepository userRepository) {
        this.characterSheetRepository = characterSheetRepository;
        this.userRepository = userRepository;
    }

    //Cria o personagem e o associa a um usuário.

    @PostMapping("/criarpersonagem")
    public ResponseEntity<Void> creatCharacter(@RequestBody CreatCharacterDTO dto,
                                               JwtAuthenticationToken token) {

        var user = userRepository.findById(UUID.fromString(token.getName()));

        var characterSheet = new CharacterSheet();

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        characterSheet.setUser(user.get());
        characterSheet.setName(dto.name());
        characterSheet.setCharacterLevel(dto.characterLevel());
        characterSheet.setCharacterClass(dto.characterClass());

        String spellsSlotsTotal = spellsSlots.defineSpellsByLevel(dto.characterClass(), dto.characterLevel());

        characterSheet.setJsonSpellSlots(spellsSlotsTotal);

        characterSheetRepository.save(characterSheet);

        return ResponseEntity.ok().build();

    }

}
