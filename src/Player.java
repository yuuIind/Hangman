public class Player {
    String name;
    String time;
    String date;
    String hangmanString;
    int stringlen;
    int timeElapsed;

    public Player(String name, String time, String date, String hangmanString, int stringlen, int timeElapsed) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.hangmanString = hangmanString;
        this.stringlen = stringlen;
        this.timeElapsed = timeElapsed;
    }
}
