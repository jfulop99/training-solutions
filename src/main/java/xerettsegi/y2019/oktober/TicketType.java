package xerettsegi.y2019.oktober;

public enum TicketType {

    FEB("Felnőtt bérlet", ReduceRate.FULL), TAB("Tanulóbérlet (kedvezményes)", ReduceRate.HALF),
    NYB("Nyugdíjas bérlet (kedvezményes)", ReduceRate.HALF), NYP("65 év feletti bérlet (ingyenes)", ReduceRate.FREE),
    RVS("Rokkant, vak, siket vagy kísérő bérlet (ingyenes)", ReduceRate.FREE), GYK("Iskolakezdés előtti gyerekbérlet (ingyenes)", ReduceRate.FREE), JGY("Jegy", ReduceRate.FULL);

    private String description;
    private ReduceRate reduceRate;

    TicketType(String description, ReduceRate reduceRate) {
        this.description = description;
        this.reduceRate = reduceRate;
    }

    public String getDescription() {
        return description;
    }

    public ReduceRate getReduceRate() {
        return reduceRate;
    }
}
