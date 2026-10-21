import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static int errorCount;
    private static final int errorCountMax = 9;
    private static String answerWord;
    private static String answerWordMask = "";


    public static void gameStart() {
        answerWord = WordInitialization.wordInit().toUpperCase();

        while (true) {
            HangmanDrawing.drawHangman(errorCount);
            System.out.println(answerWord);
            System.out.println(answerWord.length());
            System.out.println(answerWordMask);

            System.out.println("Введите букву:");
            Scanner inputLetterScanner = new Scanner(System.in);
            String inputLetter = inputLetterScanner.nextLine();

            char answerLetter;
            if (inputLetter.length() == 1) {
                answerLetter = inputLetter.charAt(0);
            }
            else {
                System.out.println("Ошибка ввода! Попробуйте еще раз.");
                continue;
            }

            if (Character.isDigit(answerLetter)) {
                System.out.println("Ошибка ввода! Попробуйте еще раз.");
                continue;
            }
            else {
                for (int i = 0; i < answerWord.length(); i++) {
                    if (answerWord.charAt(i) == answerLetter) {
                        getAnswerWord(i);
                    }
                }
            }

            HangmanDrawing.drawHangman(errorCount);
            break;
        }
    }

    public static void getAnswerWord(int index) {
        if (answerWordMask.isEmpty()) {
            for (int i = 0; i < answerWord.length(); i++) {
                answerWordMask += "_";
            }
        }
        else {

        }
    }
}