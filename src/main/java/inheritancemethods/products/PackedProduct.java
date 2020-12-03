package inheritancemethods.products;

import java.math.BigDecimal;

public class PackedProduct extends Product{

    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int numberOfBox = pieces / packingUnit;
        if (pieces % packingUnit > 0) {
            numberOfBox++;
        }
        return super.totalWeight(pieces).add(weightOfBox.multiply(new BigDecimal(numberOfBox)));
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }
}
