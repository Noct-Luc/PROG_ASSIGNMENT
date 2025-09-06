public class DreamerSlept extends Dreamer {


    public static String rankMessage;

    public DreamerSlept(int dreamNum, String dreamScape) {
        super(dreamNum, dreamScape);
    }
    public static String dreamRank(int dreamNum, String dreamScape){
        if( dreamNum < 5){
            rankMessage = "Bronze";
        } else if (dreamNum >=6  && dreamNum <=9) {
            rankMessage = "Silver";
        } else {
            rankMessage = " Gold";
        }
        return rankMessage;
    }


    @Override
    public int getDreamNum() {
        return dreamNum;
    }

    @Override
    public String getDreamScape() {
        return dreamScape;
    }

    @Override
    public String getDreamerProcess() {
        return rankMessage;
    }
}
