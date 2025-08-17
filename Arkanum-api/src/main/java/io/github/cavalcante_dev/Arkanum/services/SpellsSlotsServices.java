package io.github.cavalcante_dev.Arkanum.services;

import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class SpellsSlotsServices {

    public String defineSpellsByLevel (Integer characterClass, Integer characterLevel) {

        /*
            Bardo - 1
            Clérigo - 2
            Druida - 3
            Feiticeiro - 4
            Mago - 5
            Bruxo - 6
            Paladino - 7
            Guardião - 8
            Multiclass - 9
        */

        Integer[] intSpellsByLevel = new Integer[9];
        Gson gsonSpellsByLevel = new Gson();

        if (characterLevel == 1) {
            if (characterClass == 1) {
                intSpellsByLevel[0] = 1;
                intSpellsByLevel[1] = 2;
                intSpellsByLevel[2] = 3;
                intSpellsByLevel[3] = 4;
                intSpellsByLevel[4] = 5;
                intSpellsByLevel[5] = 6;
                intSpellsByLevel[6] = 7;
                intSpellsByLevel[7] = 8;
                intSpellsByLevel[8] = 9;
            }
        } else {
            intSpellsByLevel[0] = 0;
            intSpellsByLevel[1] = 0;
            intSpellsByLevel[2] = 0;
            intSpellsByLevel[3] = 0;
            intSpellsByLevel[4] = 0;
            intSpellsByLevel[5] = 0;
            intSpellsByLevel[6] = 0;
            intSpellsByLevel[7] = 0;
            intSpellsByLevel[8] = 0;
        }

        return gsonSpellsByLevel.toJson(intSpellsByLevel);

    }

}
