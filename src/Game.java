import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static int errorCount;
    private static final int errorCountMax = 9;
    private static ArrayList<Character> wrongLetters;
    private static ArrayList<Character> correctLetters;
    private static String word;
    private static String mask;
    private static boolean gameOn;


    public static void start() {
        errorCount = 0;
        wrongLetters = new ArrayList<>();
        correctLetters = new ArrayList<>();
        word = WordInitialization.getRandomWord().toUpperCase();
        mask = "";
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
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == answerLetter) {
                            revealLetter(i);

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

                finishGame();
            }
        }
    }

    private static void printGame() {
        HangmanDrawing.drawHangman(errorCount);

        if (mask.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                mask += "_";
            }
        }

//        System.out.println("Загаданное слово: " + answerWord);

        System.out.println("Загаданное слово: " + mask);
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

    private static void revealLetter(int index) {
        char letter = word.charAt(index);
        char[] maskArray = mask.toCharArray();
        maskArray[index] = letter;
        mask = new String(maskArray);
    }

    private static void finishGame() {
        if (errorCount == errorCountMax) {
            printGame();
            System.out.println("Вы проиграли. Загаданное слово: " + word + "\n");
            gameOn = false;
            Menu.pressToContinue();
            Menu.startMenu();
        } else if (!mask.contains("_")) {
            printGame();
            System.out.println("Поздравляем! Вы выиграли!\n");
            gameOn = false;
            Menu.pressToContinue();
            Menu.startMenu();
        }
    }
}