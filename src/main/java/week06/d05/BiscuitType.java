package week06.d05;

public enum BiscuitType {
    GYORI("Győri"), PILOTA("Pilóta"), OREO("Oreo"),
    ;

    private String name;

    BiscuitType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
