public class Player implements Comparable<Player>{
    private String name;
    private String time;
    private String date;
    private String hangmanString;
    private int stringlen;
    private int timeElapsed;

    public Player(String name, String time, String date, String hangmanString, int stringlen, int timeElapsed) {
        setName(name);
        setTime(time);
        setDate(date);
        setHangmanString(hangmanString);
        setStringlen(stringlen);
        setTimeElapsed(timeElapsed);
    }

    @Override
    public int compareTo(Player o) {
        if (getTimeElapsed() == o.getTimeElapsed()){
            if (getStringlen() == o.getStringlen()){
                if (getName().equalsIgnoreCase(o.getName())){
                    if (getTime().equalsIgnoreCase(o.getTime())) {
                        return 0;
                    }
                    return getTime().compareToIgnoreCase(o.getTime());
                }
                return getName().compareToIgnoreCase(o.getName());
            }
            return getStringlen() - o.getStringlen();
        }
        return getTimeElapsed() - o.getTimeElapsed();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHangmanString() {
        return hangmanString;
    }

    public void setHangmanString(String hangmanString) {
        this.hangmanString = hangmanString;
    }

    public int getStringlen() {
        return stringlen;
    }

    public void setStringlen(int stringlen) {
        this.stringlen = stringlen;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
