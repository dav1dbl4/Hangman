public class Game {
    private static int errorCount;
    private static final int errorCountMax = 9;
    private static String answerWord;


    public static void gameStart() {
        answerWord = WordInitialization.wordInit();
    }
}
