package week06.d05;

public enum BottleType {

    GLASS_BOTTLE(1000), PET_BOTTLE(2000);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
