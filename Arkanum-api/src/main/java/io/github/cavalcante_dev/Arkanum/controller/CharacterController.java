package io.github.cavalcante_dev.Arkanum.controller;

import io.github.cavalcante_dev.Arkanum.controller.dto.CreatCharacterDTO;
import io.github.cavalcante_dev.Arkanum.entitys.CharacterSheet;
import io.github.cavalcante_dev.Arkanum.repository.CharacterSheetRepository;
import io.github.cavalcante_dev.Arkanum.repository.UserRepository;
import io.github.cavalcante_dev.Arkanum.services.CharacterSheetServices;
import io.github.cavalcante_dev.Arkanum.services.SpellsSlotServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// Controladores de personagem - mds isso vai dar uma trabalheira.

@RestController
public class CharacterController {

    private final CharacterSheetRepository characterSheetRepository;
    private final UserRepository userRepository;
    private SpellsSlotServices spellsSlotServices;
    private CharacterSheetServices characterSheetServices;

    public CharacterController(CharacterSheetRepository characterSheetRepository,
                               UserRepository userRepository, SpellsSlotServices spellsSlotServices, CharacterSheetServices characterSheetServices) {
        this.characterSheetRepository = characterSheetRepository;
        this.userRepository = userRepository;
        this.spellsSlotServices = spellsSlotServices;
        this.characterSheetServices = characterSheetServices;
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

        String spellsSlotsTotal = spellsSlotServices.defineSpellsByLevel(dto.characterClass(), dto.characterLevel());

        characterSheet.setJsonSpellSlots(spellsSlotsTotal);

        characterSheetRepository.save(characterSheet);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/personagens/{userID}")
    public ResponseEntity<List<CharacterSheet>> listCharacters(@PathVariable("userID") String userID) {
         var characters = characterSheetServices.findByUserID(userID);
         return ResponseEntity.ok(characters);
    }

}
