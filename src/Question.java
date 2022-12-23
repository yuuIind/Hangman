public class Question {
    private String key; // The word that will be guessed
    private String tip; // The hint that will be given
    private String notInLetters; //letters that are not in the given key
    private int cdTime; // Countdown timeout value

    Question(String tip, String notInLetters, String key, int cdTime){
        setKey(key);
        setTip(tip);
        setNotInLetters(notInLetters);
        setCdTime(cdTime);
    }

    Question(){
        setKey(null);
        setTip(null);
        setNotInLetters(null);
        setCdTime(0);
    }

    public int FrequencyOf(String s){
        if(getKey().toLowerCase().contains(s.toLowerCase())){
            int freq = 0;
            String ans = getKey().toLowerCase();
            for (int i = 0; i < getKey().length(); i++){
                if(String.valueOf(ans.charAt(i)).equals(s.toLowerCase())){
                    freq++;
                }
            }
            return freq;
        }else {
            return 0;
        }
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setTip(String tip) {
        this.tip= tip;
    }

    public String getTip() {
        return tip;
    }

    public void setNotInLetters(String notInLetters) {
        this.notInLetters = notInLetters;
    }

    public String getNotInLetters() {
        return notInLetters;
    }

    public void setCdTime(int cdTime) { // default value is 90s
        this.cdTime = (cdTime > 0) ? cdTime : 90; // countdown timer may not be less than or equal to 0
    }

    public int getCdTime() {
        return cdTime;
    }
}
