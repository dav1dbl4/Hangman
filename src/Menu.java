import java.util.Scanner;

public class Menu {
    private static final int START = 1;
    private static final int QUIT = 2;

    public static void startMenu() {
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.printf("[%d] Начать новую игру \n", START);
            System.out.printf("[%d] Выйти из приложения \n", QUIT);
            System.out.println();

            System.out.println("Введите номер команды:");

            if (!inputScanner.hasNextInt()) {
                System.out.println("Введено неверное значение!");
                System.out.println("Попробуйте еще раз.");
                System.out.println();
                inputScanner.nextLine();
                continue;
            }

            int input = inputScanner.nextInt();

            if (input == START) {
                System.out.println("Игра начата. Удачи!");
                Game.start();
            } else if (input == QUIT) {
                return;
            } else {
                System.out.println("Введено неверное значение!");
                System.out.println("Попробуйте еще раз.");
                System.out.println();
            }
        }
    }
}