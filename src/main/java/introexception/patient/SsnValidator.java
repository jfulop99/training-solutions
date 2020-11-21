package introexception.patient;

public class SsnValidator {
    public boolean isValidSsn(String ssn){
        boolean valid = true;
        try {
            Integer.parseInt(ssn);
        } catch (IllegalArgumentException e) {
            //valid = false;
            throw new IllegalArgumentException();
        }
        if (valid){
            valid = (ssn.length() != 9) ? false : true;
        }
        if (valid) {
            int checkSum = 0;
            for (int i = 0; i < ssn.length()-1; i++){
                if(i % 2 == 0) {
                    checkSum += (Integer.parseInt(ssn.substring(i, i+1)) * 3);
                }
                else {
                    checkSum += (Integer.parseInt(ssn.substring(i, i+1)) * 10);
                }
            }
            if ( checkSum % 10 != (Integer.parseInt(ssn.substring(8)))) {
                valid = false;
            }
        }
        return valid;
    }
}
