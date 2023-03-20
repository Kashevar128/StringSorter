package output;

import start.UserConsole;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFile {

    public static void output(List<String> outputString) {
        //Класс для формирования выходного файла
        StringBuilder stringBuilder = new StringBuilder();
        outputString.forEach((s -> stringBuilder.append(s).append("\n")));
        String result = stringBuilder.toString();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", false))) {
            bw.write(result);
            UserConsole.setTurnOff(true);
            System.out.println("Выходной файл создан");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка записи в файл");
        }
    }

}
