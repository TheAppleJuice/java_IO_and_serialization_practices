package se.lexicon.exercise_6;

import java.io.Serializable;
import java.util.UUID;

public class Owner implements Serializable {
    private UUID ownerId;
    private String name;
    private String birthdate;

    public Owner() {
        this.ownerId = UUID.randomUUID();
    }

    public Owner(String name, String birthdate) {
        this.ownerId = UUID.randomUUID();
        this.name = name;
        this.birthdate = birthdate;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
