package se.lexicon.exercise_6;

import java.io.Serializable;
import java.time.LocalDate;

public class Owner implements Serializable {
    private int ownerId;
    private String name;
    private LocalDate birthdate;

    public Owner() {
    }

    public Owner(int ownerId, String name, LocalDate birthdate) {
        this.ownerId = ownerId;
        this.name = name;
        this.birthdate = birthdate;
    }


    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
