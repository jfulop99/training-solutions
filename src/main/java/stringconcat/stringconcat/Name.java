package stringconcat.stringconcat;

public class Name {

    private String lastName;
    private String middleName;
    private String firstName;
    private String title;

    public Name(String lastName, String middleName, String firstName) {
        if (isEmpty(lastName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        else {
            this.lastName = lastName;
        }
        this.middleName = middleName;
        if (isEmpty(firstName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        else {
            this.firstName = firstName;
        }
    }

    public Name(String lastName, String middleName, String firstName, Title title) {
        this(lastName, middleName, firstName);
        this.title = title.getTitle();
    }


    public String concatNameWesternStyle(){
        if (isEmpty(title)){
            if (isEmpty(middleName)){
                return firstName.concat(" " + lastName);
            }
            else {
                return firstName.concat(" " + middleName.concat(" " + lastName));
            }
        }
        else {
            if (isEmpty(middleName)){
                return title.concat(" " + firstName.concat(" " + lastName));
            }
            else {
                return title.concat(" " + firstName.concat(" " + middleName.concat(" " + lastName)));
            }
        }


    }
    public String concatNameHungarianStyle(){
        String concatString = "";
        if (!isEmpty(title)) {
            concatString += title;
            concatString += " ";

        }
        concatString += lastName;
        if (!isEmpty(middleName)) {
            concatString += " ";
            concatString += middleName;
        }
        concatString += " ";
        concatString += firstName;
        return concatString;
    }

    private boolean isEmpty(String name){
        if (name == null || name.length() == 0){
            return true;
        }
        return false;
    }
}
