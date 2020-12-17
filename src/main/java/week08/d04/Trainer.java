package week08.d04;

public class Trainer implements CanMark{

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        if (canMark == null) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        this.canMark = canMark;
    }

    @Override
    public int giveMark() {
        return canMark.giveMark();
    }
}
