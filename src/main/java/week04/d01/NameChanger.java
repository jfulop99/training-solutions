package week04.d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid Name: " + fullName);
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void changeFirstName(String firstName) {
        fullName = firstName + fullName.substring(fullName.indexOf(" "));
    }

    public boolean isTheSame(String otherfullname){
        return fullName.equals(otherfullname);
    }
}
/*
Készítsd el a week04d01.NameChanger osztályt, melynek privát attribútuma legyen a fullName:String,
mely egy ember teljes nevét reprezentálja.
A fullName attributum <vezetéknév><szóköz><keresztnév> formátumban épül fel (Mással most nem foglalkozunk).
A Konstruktor állítsa be a paraméterül kapott értékre az adattagot,
de ha az érték null, vagy üres String akkor dobjon IllegalArgumentExceptiont, a következő üzenettel: "Invalid Name:<paraméter értéke>"

Legyen egy changeFirstName(String firstName) metódusa, ami megváltoztatja az objektum állapotát és kicseréli a vezetéknevet a paraméterül kapott értékre.

Készíts két teszt esetet, az egyikben ellenőrizd a konstruktor működését, míg a másikban a changeFirstName metódus működését.
 */