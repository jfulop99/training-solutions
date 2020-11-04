package math.game;

import java.util.Random;

public class Warrior {

    private String name;
    private int stamina;
    private double skill;
    private Point position;
    private final Random random = new Random();

    public Warrior(String name, Point position){
        this.position = position;
        this.name = name;
        skill = random.nextDouble();
        stamina = random.nextInt(81) + 20;
    }

    public Point getPosition() {
        return position;
    }

    public void move (Warrior warrior){
        int posX = position.getX();
        int posY = position.getY();
        if (warrior.getPosition().getX() != posX){
            if (warrior.getPosition().getX() > posX){
                posX++;
            }
            else {
                posX--;
            }
        }
        if (warrior.getPosition().getY() != posY){
            if (warrior.getPosition().getY() > posY){
                posY++;
            }
            else {
                posY--;
            }
        }
        this.position = new Point(posX, posY);
    }

    public double distance(Warrior warrior){
        return position.distance(warrior.getPosition());
    }

    public String toString(){
        return name + ": \t(" + position.getX() + ", " + position.getY() + ") " + stamina;
    }

    public boolean isAlive(){
        return (stamina > 0);
    }

    public void attack(Warrior warrior){
        if (skill > random.nextDouble()){
            warrior.stamina = warrior.stamina - (random.nextInt(3) + 1);
        }
    }
}
