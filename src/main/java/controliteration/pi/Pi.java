package controliteration.pi;

public class Pi {
    private final static String piVers ="Nem a régi s durva közelítés, " +
                                        "Mi szótól szóig így kijön " +
                                        "Betűiket számlálva. " +
                                        "Ludolph eredménye már, " +
                                        "Ha itt végezzük húsz jegyen. " +
                                        "De rendre kijő még tíz pontosan, " +
                                        "Azt is bízvást ígérhetem.";

    public String piGenerator (){
        String pi = "";
        int i = 0;
        int letterCounter = 0;
        while (i < piVers.length()){
            if ( Character.isLetter(piVers.charAt(i)) ){
                letterCounter++;
            }
            else {
                if (pi.length() == 1){
                    pi = pi + ".";
                }
                if (letterCounter > 0 ){
                    pi = pi + letterCounter;
                    letterCounter = 0;
                }
            }
            i++;
        }
        return pi;
    }
}
