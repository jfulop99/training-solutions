package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {
        attacker.primaryAttack(defender);
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.secondaryAttack(defender);
        }
        return attacker.isAlive() && defender.isAlive();
    }

    public Character fight(Character one, Character other) {
        Character attacker = one;
        Character defender = other;
        while (oneHit(attacker,defender)) {
            round++;
            Character temp = attacker;
            attacker = defender;
            defender = temp;
        }
        if (one.isAlive()) {
            return one;
        }
        return other;
    }

}
