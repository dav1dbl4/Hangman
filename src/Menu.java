import java.util.Scanner;

public class Menu {
    public static void initStartMenu() {
        System.out.println("[1] Начать новую игру");
        System.out.println("[2] Выйти из приложения\n");

        System.out.println("Введите номер команды:");
        Scanner inputScanner = new Scanner(System.in);
        int input = inputScanner.nextInt();

        switch (input){
            case 1:
                System.out.println("Игра начата. Удачи!");
                Game.gameStart();
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Введено неверное значение! \nПопробуйте еще раз.\n");
                initStartMenu();
        }
    }

    public static void pressToContinue() {
        System.out.println("Нажмите Enter для продолжения...");
        Scanner pressToContinue = new Scanner(System.in);
        pressToContinue.nextLine();
    }
}
