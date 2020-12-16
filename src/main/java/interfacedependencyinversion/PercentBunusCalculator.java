package interfacedependencyinversion;

public class PercentBunusCalculator implements BonusCalculator{

    @Override
    public int calculateBonus(int salary) {
        return (int)(salary * 1.25);
    }
}
