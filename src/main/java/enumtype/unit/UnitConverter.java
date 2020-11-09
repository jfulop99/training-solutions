package enumtype.unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target){
        return BigDecimal.valueOf(Math.round(length.doubleValue() * source.getFactor() / target.getFactor() * 1e4) / 1e4); 
    }
    
    public List<LengthUnit> siUnits(){
        List<LengthUnit> siUnits = new ArrayList<>();
        for (LengthUnit siUnit:LengthUnit.values()) {
            if (siUnit.isSi()){
                siUnits.add(siUnit);
            }
        }
        return siUnits;
    }
}
