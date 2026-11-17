import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static int errorCount;
    private static final int errorCountMax = 9;
    private static List<Character> wrongLetters;
    private static List<Character> correctLetters;
    private static final List<Character> RUSSIAN_LETTERS = List.of(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф',
            'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
    );
    private static String word;
    private static String mask;
    private static boolean gameOn;


    public static void start() {
        initVariables();

        while (gameOn) {
            printGame();

            char answerLetter = readLetter();

            if (checkInputLetter(answerLetter)) {

                handleLetter(answerLetter);

                checkEndGame();
            }
        }
    }

    private static void initVariables() {
        errorCount = 0;
        wrongLetters = new ArrayList<>();
        correctLetters = new ArrayList<>();
        word = WordInitialization.getRandomWord().toUpperCase();
        mask = "";
        gameOn = true;
    }

    private static void printGame() {
        HangmanDrawing.drawHangman(errorCount);

        if (mask.isEmpty()) {
            makeMask();
        }

//        System.out.println("Загаданное слово: " + answerWord);

        System.out.println("Загаданное слово: " + mask);
        System.out.println("Правильные буквы: " + correctLetters);
        System.out.println("Неправильные буквы: " + wrongLetters);
        System.out.printf("Количество ошибок: %d/%d \n", errorCount, errorCountMax);
        System.out.println();
    }

    private static void makeMask() {
        for (int i = 0; i < word.length(); i++) {
            mask += "_";
        }
    }

    private static char readLetter() {
        System.out.println("Введите букву:");
        Scanner inputLetterScanner = new Scanner(System.in);
        String inputLetter = inputLetterScanner.nextLine().toUpperCase();

        if (inputLetter.length() == 1) {
            return inputLetter.charAt(0);
        }
        else {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            return ' ';
        }
    }

    private static boolean checkInputLetter(char answerLetter) {
        if (!RUSSIAN_LETTERS.contains(answerLetter)) {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            return false;
        }

        return true;
    }

    private static void handleLetter(char letter) {
        if (correctLetters.contains(letter) || wrongLetters.contains(letter)) {
            System.out.println("Вы уже вводили эту букву.");
            return;
        }

        if (word.indexOf(letter) >= 0) {
            revealLetter(letter);
            correctLetters.add(letter);
        } else {
            wrongLetters.add(letter);
            errorCount++;
        }
    }

    private static void revealLetter(char letter) {
        char[] maskArray = mask.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                maskArray[i] = letter;
            }
        }

        mask = new String(maskArray);
    }

    private static void checkEndGame() {
        if (errorCount == errorCountMax) {
            endGame("Вы проиграли. Загаданное слово: " + word);
        } else if (!mask.contains("_")) {
            endGame("Поздравляем! Вы выиграли!");
        }
    }

    private static void endGame(String message) {
        printGame();
        System.out.println(message);
        System.out.println();
        gameOn = false;
    }
}