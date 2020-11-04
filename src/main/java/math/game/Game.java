package math.game;

public class Game {
    public static void main(String[] args) {

        Warrior warrior1 = new Warrior("John Doe", new Point(9, 9));
        Warrior warrior2 = new Warrior("Jack Daniels", new Point(1, 4));

        System.out.println("Start: (menetelés)");
        System.out.println(warrior1.toString());
        System.out.println(warrior2.toString());

        int i = 0;
        while (warrior1.distance(warrior2) > 0) {
            i++;
            if (i % 2 == 0) {
                warrior2.move(warrior1);
            } else {
                warrior1.move(warrior2);
            }
            System.out.println(i + ". menet:");
            System.out.println(warrior1.toString());
            System.out.println(warrior2.toString());

        }

        System.out.println("Start harc:");
        while (warrior1.isAlive() && warrior2.isAlive()){
            i++;
            if (i % 2 == 0){
                warrior2.attack(warrior1);
            }
            else {
                warrior1.attack(warrior2);
            }
            System.out.println(i + ". menet:");
            System.out.println(warrior1.toString());
            System.out.println(warrior2.toString());
            i++;
        }

        System.out.println("A győztes: " + (warrior1.isAlive() ? warrior1.toString() : warrior2.toString()));
    }
}
