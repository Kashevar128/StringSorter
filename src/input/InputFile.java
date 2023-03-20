package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import collector.CollectorStringLine;

public class InputFile {
    //Класс для обработки входного файла
    public static void input(String path) {
        String pathEdit = path.trim();
        File file = new File(pathEdit);
        if (!pathEdit.endsWith(".txt")) {
            System.out.println("Файл должен быть .txt! Повторите ввод:");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ( (line = br.readLine()) != null) {
                CollectorStringLine.collect(line);
            }
            System.out.println(CollectorStringLine.getListLines());
            CollectorStringLine.sortByBanks();
        } catch (IOException e) {
            System.out.println("Неверный путь! Повторите ввод:");
        }
    }

}
