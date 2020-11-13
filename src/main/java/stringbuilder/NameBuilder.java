package stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title){
        if (isEmpty(familyName) || isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder concatName = new StringBuilder();
        if (title != null) {
            concatName.append(title.getTitle());
            concatName.append(" ");
        }
        concatName.append(givenName);
        concatName.append(" ");
        if (!isEmpty(middleName)){
            concatName.append(middleName);
            concatName.append(" ");
        }
        concatName.append(familyName);
        return concatName.toString();
    }
    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title){
        if (isEmpty(familyName) || isEmpty(givenName)){
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder concatName = new StringBuilder();
        if (title != null) {
            concatName.append(title.getTitle());
            concatName.append(" ");
        }
        concatName.append(familyName);
        concatName.append(" ");
        if (!isEmpty(middleName)){
            concatName.append(middleName);
            concatName.append(" ");
        }
        concatName.append(givenName);
        return concatName.toString();
    }
    public String insertTitle(String name, Title title, String where){
        StringBuilder concatName = new StringBuilder();
        concatName.append(name);
        concatName.insert(concatName.indexOf(where), where + title.getTitle());
        return concatName.toString();
    }
    public String deleteNamePart(String name, String delete){
        StringBuilder concatName = new StringBuilder();
        concatName.append(name);
        concatName.delete(concatName.indexOf(delete), concatName.indexOf(delete) + delete.length());
        return concatName.toString();
    }

    private boolean isEmpty(String string){
        if (string == null || string.length() == 0) {
            return true;
        }
        return false;
    }

}
