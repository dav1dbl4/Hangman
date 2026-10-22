import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static int errorCount;
    private static final int errorCountMax = 9;
    private static ArrayList<Character> wrongLetters;
    private static ArrayList<Character> correctLetters;
    private static String answerWord;
    private static String answerWordMask;
    private static boolean gameOn;


    public static void gameStart() {
        errorCount = 0;
        wrongLetters = new ArrayList<>();
        correctLetters = new ArrayList<>();
        answerWord = WordInitialization.wordInit().toUpperCase();
        answerWordMask = "";
        gameOn = true;

        while (gameOn) {
            printGame();

            System.out.println("Введите букву:");
            Scanner inputLetterScanner = new Scanner(System.in);
            String inputLetter = inputLetterScanner.nextLine().toUpperCase();
            char answerLetter = ' ';

            if (inputLetter.length() == 1) {
                answerLetter = inputLetter.charAt(0);
            }
            else {
                System.out.println("Ошибка ввода! Попробуйте еще раз.");
                Menu.pressToContinue();
                continue;
            }

            if (checkInputLetter(answerLetter)) {
                boolean isCorrectLetter = false;

                if (!correctLetters.contains(answerLetter)) {
                    for (int i = 0; i < answerWord.length(); i++) {
                        if (answerWord.charAt(i) == answerLetter) {
                            getAnswerWord(i);

                            if (!correctLetters.contains(answerLetter))
                                correctLetters.add(answerLetter);
                            isCorrectLetter = true;
                        }
                    }
                }
                else {
                    System.out.println("Вы уже вводили эту букву.");
                    isCorrectLetter = true;
                    Menu.pressToContinue();
                    continue;
                }

                if (!isCorrectLetter && !wrongLetters.contains(answerLetter)) {
                    wrongLetters.add(answerLetter);
                    errorCount++;
                }
                else if (wrongLetters.contains(answerLetter)) {
                    System.out.println("Вы уже вводили эту букву.");
                    Menu.pressToContinue();
                    continue;
                }

                gameResult();
            }
        }
    }

    private static void printGame() {
        HangmanDrawing.drawHangman(errorCount);

        if (answerWordMask.isEmpty()) {
            for (int i = 0; i < answerWord.length(); i++) {
                answerWordMask += "_";
            }
        }

//        System.out.println("Загаданное слово: " + answerWord);

        System.out.println("Загаданное слово: " + answerWordMask);
        System.out.println("Правильные буквы: " + correctLetters);
        System.out.println("Неправильные буквы: " + wrongLetters);
        System.out.println("Количество ошибок: " + errorCount + "/" + errorCountMax + "\n");
    }

    private static boolean checkInputLetter(char answerLetter) {
        if (Character.isDigit(answerLetter) || !Character.isLetter(answerLetter)) {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            Menu.pressToContinue();
            return false;
        }

        if (answerLetter >= 'a' && answerLetter <= 'z' || answerLetter >= 'A' && answerLetter <= 'Z') {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            Menu.pressToContinue();
            return false;
        }

        return true;
    }

    private static void getAnswerWord(int index) {
        char letter = answerWord.charAt(index);
        char[] maskArray = answerWordMask.toCharArray();
        maskArray[index] = letter;
        answerWordMask = new String(maskArray);
    }

    private static void gameResult() {
        if (errorCount == errorCountMax) {
            printGame();
            System.out.println("Вы проиграли. Загаданное слово: " + answerWord + "\n");
            gameOn = false;
            Menu.pressToContinue();
            Menu.initStartMenu();
        } else if (!answerWordMask.contains("_")) {
            printGame();
            System.out.println("Поздравляем! Вы выиграли!\n");
            gameOn = false;
            Menu.pressToContinue();
            Menu.initStartMenu();
        }
    }
}