public class Hangman {
    private int errorsMade;
    private int limbs;

    public Hangman(int errorsMade, int limbs) {
        if(errorsMade != limbs){
            setErrorsMade(Math.max(errorsMade,limbs));
            setLimbs(Math.max(errorsMade,limbs));
            return;
        }
        setErrorsMade(errorsMade);
        setLimbs(limbs);
    }

    public Hangman() {
        setErrorsMade(0);
        setLimbs(0);
    }

    public int getErrorsMade() {
        return errorsMade;
    }

    public void setErrorsMade(int errorsMade) {
        this.errorsMade = ((errorsMade >= 0) && (errorsMade < 6)) ? errorsMade : 0;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = ((limbs >= 0) && (limbs < 6)) ? limbs : 0;
    }
}
