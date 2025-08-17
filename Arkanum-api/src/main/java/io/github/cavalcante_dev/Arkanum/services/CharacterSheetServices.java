package io.github.cavalcante_dev.Arkanum.services;

import io.github.cavalcante_dev.Arkanum.entitys.CharacterSheet;
import io.github.cavalcante_dev.Arkanum.repository.CharacterSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterSheetServices {

    @Autowired
    private CharacterSheetRepository characterSheetRepository;

    public List<CharacterSheet> findByUserID(String userID) {
        String formattedId = userID
                .replaceFirst(
                        "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                        "$1-$2-$3-$4-$5"
                );
        UUID userIDUUID = UUID.fromString(formattedId);
        var characters = characterSheetRepository.findAllByUserUserID(userIDUUID);
        return characterSheetRepository.findAllByUserUserID(userIDUUID);
    }

}
