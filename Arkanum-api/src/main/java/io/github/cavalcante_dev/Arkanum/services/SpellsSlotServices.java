package io.github.cavalcante_dev.Arkanum.services;

import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class SpellsSlotServices {

    public String defineSpellsByLevel(int characterClass, int characterLevel) {

        int[] intSpellsByLevel;
        Gson gsonSpellsByLevel = new Gson();

        switch (characterClass) {

            case 1, 3, 4, 5, 6, 9 -> intSpellsByLevel = getFullCasterSlots(characterLevel);
            case 2 -> intSpellsByLevel = new int[0]; //getWarlockSlots(characterLevel);
            case 7, 8 -> intSpellsByLevel = getHalfCasterSlots(characterLevel);
            default -> intSpellsByLevel = new int[9];

        }

        return gsonSpellsByLevel.toJson(intSpellsByLevel);

    }

    private int[] getFullCasterSlots(int characterLevel) {
        int[][] tabela = {
                {2,0,0,0,0,0,0,0,0}, // level 1
                {3,0,0,0,0,0,0,0,0}, // level 2
                {4,2,0,0,0,0,0,0,0}, // level 3
                {4,3,0,0,0,0,0,0,0}, // level 4
                {4,3,2,0,0,0,0,0,0}, // level 5
                {4,3,3,0,0,0,0,0,0}, // level 6
                {4,3,3,1,0,0,0,0,0}, // level 7
                {4,3,3,2,0,0,0,0,0}, // level 8
                {4,3,3,3,1,0,0,0,0}, // level 9
                {4,3,3,3,2,0,0,0,0}, // level 10
                {4,3,3,3,2,1,0,0,0}, // level 11
                {4,3,3,3,2,1,0,0,0}, // level 12
                {4,3,3,3,2,1,1,0,0}, // level 13
                {4,3,3,3,2,1,1,0,0}, // level 14
                {4,3,3,3,2,1,1,1,0}, // level 15
                {4,3,3,3,2,1,1,1,0}, // level 16
                {4,3,3,3,2,1,1,1,1}, // level 17
                {4,3,3,3,3,1,1,1,1}, // level 18
                {4,3,3,3,3,2,1,1,1}, // level 19
                {4,3,3,3,3,2,2,1,1}  // level 20
        };
        return (characterLevel >= 1 && characterLevel <= tabela.length) ? tabela[characterLevel - 1] : new int[9];
    }

    private int[] getHalfCasterSlots(int characterLevel) {
        int[][] tabela = {
                {0,0,0,0,0,0,0,0,0}, // level 1
                {2,0,0,0,0,0,0,0,0}, // level 2
                {3,0,0,0,0,0,0,0,0}, // level 3
                {3,0,0,0,0,0,0,0,0}, // level 4
                {4,2,0,0,0,0,0,0,0}, // level 5
                {4,2,0,0,0,0,0,0,0}, // level 6
                {4,3,0,0,0,0,0,0,0}, // level 7
                {4,3,0,0,0,0,0,0,0}, // level 8
                {4,3,2,0,0,0,0,0,0}, // level 9
                {4,3,2,0,0,0,0,0,0}, // level 10
                {4,3,3,0,0,0,0,0,0}, // level 11
                {4,3,3,0,0,0,0,0,0}, // level 12
                {4,3,3,1,0,0,0,0,0}, // level 13
                {4,3,3,1,0,0,0,0,0}, // level 14
                {4,3,3,2,0,0,0,0,0}, // level 15
                {4,3,3,2,0,0,0,0,0}, // level 16
                {4,3,3,3,1,0,0,0,0}, // level 17
                {4,3,3,3,1,0,0,0,0}, // level 18
                {4,3,3,3,2,0,0,0,0}, // level 19
                {4,3,3,3,2,0,0,0,0}  // level 20
        };
        return (characterLevel >= 1 && characterLevel <= tabela.length) ? tabela[characterLevel - 1] : new int[9];
    }

}
