import java.util.Scanner;

public class StartMenu {
    public static void initStartMenu() {
        System.out.println("[1] Начать новую игру");
        System.out.println("[2] Выйти из приложения\n");

        System.out.println("Введите номер необходимой команды:");
        Scanner inputScanner = new Scanner(System.in);
        int input = inputScanner.nextInt();

        switch (input){
            case 1:
                System.out.println("Игра начата");
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Введено неверное значение! \nПопробуйте еще раз.\n");
                initStartMenu();
        }
    }
}
