package collector;

import java.util.ArrayList;
import java.util.List;

public class FactoryBanks {
    //Фабрика для создания фиксированного количества банков
    private final static int NUM_BANKS = 2;
    private int limitBanks;
    private BankOfLines currentBankOfLines = null;

    private final List<BankOfLines> bankOfLinesList = new ArrayList<>();

    public FactoryBanks(int limitBanks) {
        if (limitBanks == 0) {
            this.limitBanks = NUM_BANKS;
            return;
        }
        this.limitBanks = limitBanks;
    }

    public boolean createBank(int limitLines) {
        if (limitBanks == 0) return false;
        limitBanks--;
        currentBankOfLines = new BankOfLines(limitLines);
        bankOfLinesList.add(currentBankOfLines);
        return true;
    }

    public BankOfLines getCurrentBankOfLines() {
        return currentBankOfLines;
    }

    public List<BankOfLines> getBankOfLinesList() {
        return bankOfLinesList;
    }

    public boolean checkBanks() {
        int countTrue = 0;
        for (BankOfLines bankOfLines : bankOfLinesList) {
            if (bankOfLines.check()) countTrue++;
        }
        return countTrue == bankOfLinesList.size() && limitBanks == 0;
    }
}
