package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    List<Pet> pets = new ArrayList<>();

    public void add(Pet pet) {
        if (areEquals(pet)) {
            pets.add(pet);
        }
    }

    private boolean areEquals(Pet newpet) {
        for (Pet pet:pets) {
            if (pet.getRegistrationNumber().equals(newpet.getRegistrationNumber())) {
                return false;
            }
        }
        return true;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
