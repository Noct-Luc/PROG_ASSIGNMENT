
public abstract class Dreamer implements iDream {
    public int dreamNum;
    public String dreamScape;


    public Dreamer(int dreamNum, String dreamScape) {
        this.dreamNum = dreamNum;
        this.dreamScape = dreamScape;
    }

    public void setDreamScape(String dreamScape, int dreamNum) {
        this.dreamScape = dreamScape;
        this.dreamNum = dreamNum;
    }

    public int getDreamNum() {
        return dreamNum;
    }

    public String getDreamScape() {
        return dreamScape;
    }
}
