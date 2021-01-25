package week13.d01.v2;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Comparator;

public class ComparateByNameAndDistrict implements Comparator<City> {

    private final static String HUNGARIAN_COLLATOR_RULE =   "< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS \n" +
            " < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J\n" +
            " < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó \n" +
            " < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T \n" +
            " < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";


    @Override
    public int compare(City o1, City o2) {

        RuleBasedCollator hunRuleBasedCollator = hungarianRuleBasedCollator();

        int result = hunRuleBasedCollator.compare(o1.getName(), o2.getName());

        if (result == 0) {

            if (o1.getDistrictName() == null && o2.getDistrictName() == null) {
                return 0;
            }

            if (o1.getDistrictName() == null) {
                return -1;
            }

            if (o2.getDistrictName() == null) {
                return 1;
            }

            result = hunRuleBasedCollator.compare(o1.getDistrictName(), o2.getDistrictName());
        }

        return result;
    }

    private RuleBasedCollator hungarianRuleBasedCollator () {

        RuleBasedCollator ruleBasedCollator = null;

        try {
            ruleBasedCollator = new RuleBasedCollator(HUNGARIAN_COLLATOR_RULE);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong collator rule");
        }

        return ruleBasedCollator;
    }

}
