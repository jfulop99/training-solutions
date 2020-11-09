package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();
        System.out.println(unitConverter.convert(BigDecimal.valueOf(1000.0), LengthUnit.M, LengthUnit.YARD));
        System.out.println(unitConverter.siUnits());

    }
}
