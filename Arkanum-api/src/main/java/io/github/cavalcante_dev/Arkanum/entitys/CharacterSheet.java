package io.github.cavalcante_dev.Arkanum.entitys;

import com.nimbusds.jose.shaded.gson.JsonArray;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

// Entidade de ficha de personagem é criada e associada ao usuário

@Entity
@Table(name = "tb_chatacterSheet")
public class CharacterSheet {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_generator"
    )
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "tb_chatacter_sheet_sequence",
            allocationSize = 1
    )
    @Column(name = "character_id")
    private Long characterId;

    // Determina o ID do usuário que a criou.

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "character_name")
    private String name;

    @JoinColumn(name = "character_class")
    private Integer characterClass;

    @JoinColumn(name = "character_level")
    private Integer characterLevel;

    // private String characterImg; - Adicionar posteriormente

    @JoinColumn(name = "jsonSpellSlots")
    private String jsonSpellSlots;

    @JoinColumn(name = "character_description")
    private String characterDescription;

    @CreationTimestamp
    private Instant createdTimeStamp;

    public CharacterSheet() {
    }

    // Getters and Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(Integer characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Integer characterLevel) {
        this.characterLevel = characterLevel;
    }

    public String getJsonSpellSlots() {
        return jsonSpellSlots;
    }

    public void setJsonSpellSlots(String jsonSpellSlots) {
        this.jsonSpellSlots = jsonSpellSlots;
    }

    /*
    public String getCharacterImg() {
        return characterImg;
    }

    public void setCharacterImg(String characterImg) {
        this.characterImg = characterImg;
    }
    */

    public Instant getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Instant createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

}
