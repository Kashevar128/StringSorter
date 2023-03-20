package collector;

import comparator.CompareColumns;

import java.util.ArrayList;
import java.util.List;

public class CollectorStringLine {
    //Класс для сбора строк из входного файла и сортировки по банкам

    private static List<String> listLines = new ArrayList<>();

    public static void collect(String line) {
        String editLine = line.trim();
        listLines.add(editLine);
    }

    public static List<String> getListLines() {
        return listLines;
    }

    public static void sortByBanks() {
        FactoryBanks factoryBanks = new FactoryBanks(0);
        int numStringLine;
        boolean bank = false;
        for (String line : listLines) {
            try {
                if (line.isEmpty()) System.out.println("Пустая строка");
                numStringLine = Integer.parseInt(line);
                bank = factoryBanks.createBank(numStringLine);
                System.out.println(numStringLine);
            } catch (NumberFormatException e) {
                if (!line.isEmpty()) {
                    System.out.println("String line...");
                    if (bank) {
                        factoryBanks.getCurrentBankOfLines().addLine(line);
                    }
                }
            }
        }
        List<BankOfLines> bankOfLinesList = factoryBanks.getBankOfLinesList();
        for(BankOfLines bankOfLines : bankOfLinesList) {
            String report = String.format("%d %s %b", bankOfLines.getCountLines(),
                    bankOfLines.getLines(), bankOfLines.check());
            System.out.println(report);
        }
        boolean check = factoryBanks.checkBanks();
        String conclusionData = String.format("Целостность данных: %b", check);
        System.out.println(conclusionData);
        if (!check) {
            throw new RuntimeException("В файле не хватает данных " +
                    "для корректной работы программы");
        }
        System.out.println("OK!!");
        CompareColumns.compare(factoryBanks.getBankOfLinesList());
    }
}
