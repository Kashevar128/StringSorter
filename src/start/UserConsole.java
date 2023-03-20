package start;

import input.InputFile;

import java.util.Scanner;

public class UserConsole {
    //Класс для ввода пути входного файла через консоль
    private static final Scanner scanner = new Scanner(System.in);

    private static boolean turnOff = false;

    public static void writeCommand() {
        System.out.println("Введите полный путь файла:");
        while (scanner.hasNext()) {
            String path = scanner.nextLine();
            System.out.println(path + "&");
            if (path.equals("exit")) {
                break;
            }
            InputFile.input(path);
            if (turnOff) break;
        }
    }

    public static void setTurnOff(boolean turnOff) {
        UserConsole.turnOff = turnOff;
    }
}

