package io.github.cavalcante_dev.Arcanum.controller;

import io.github.cavalcante_dev.Arcanum.controller.dto.CreatCharacterDTO;
import io.github.cavalcante_dev.Arcanum.entitys.CharacterSheet;
import io.github.cavalcante_dev.Arcanum.repository.CharacterSheetRepository;
import io.github.cavalcante_dev.Arcanum.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CharacterController {

    private final CharacterSheetRepository characterSheetRepository;
    private final UserRepository userRepository;

    public CharacterController(CharacterSheetRepository characterSheetRepository,
                               UserRepository userRepository) {
        this.characterSheetRepository = characterSheetRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/criarpersonagem")
    public ResponseEntity<Void> creatCharacter(@RequestBody CreatCharacterDTO dto,
                                               JwtAuthenticationToken token) {
        var user = userRepository.findById(UUID.fromString(token.getName()));

        var characterSheet = new CharacterSheet();

        characterSheet.setUser(user.get());
        characterSheet.setName(dto.name());
        characterSheet.setCharacterLevel(dto.characterLevel());
        characterSheet.setCharacterClass(dto.characterClass());

        characterSheetRepository.save(characterSheet);

        return ResponseEntity.ok().build();

    }

}
