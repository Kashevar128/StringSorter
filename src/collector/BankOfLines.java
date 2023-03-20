package collector;

import java.util.ArrayList;
import java.util.List;

public class BankOfLines {
    //Класс - банк для сбора строк из коллектора

    private List<String> lines = new ArrayList<>();
    private int countLines;

    public BankOfLines(int countLines) {
        this.countLines = countLines;
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public boolean check() {
        if (countLines == lines.size()) return true;
        return false;
    }

    public List<String> getLines() {
        return lines;
    }

    public int getCountLines() {
        return countLines;
    }
}
