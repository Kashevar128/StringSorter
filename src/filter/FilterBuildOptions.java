package filter;

import comparator.BuildOption;

import java.util.ArrayList;
import java.util.List;

public class FilterBuildOptions {
    //Класс для фильтрации отсортированных листов со строками

    private static String line = null;
    private static final List<BuildOption> sortArray = new ArrayList<>();

    public static List<BuildOption> filter(List<BuildOption> buildOptionList, int sizeFirst, int sizeSecond) {

        for (BuildOption buildOption : buildOptionList) {
            if (sizeFirst > sizeSecond) filterBySecondColumn(buildOption);
            else filterByFirstColumn(buildOption);
        }
        return sortArray;
    }

    private static void filterByFirstColumn(BuildOption buildOption) {
        if (!buildOption.getLineFirstColumn().equals(line)) {
            line = buildOption.getLineFirstColumn();
            sortArray.add(buildOption);
        }
    }

    private static void filterBySecondColumn(BuildOption buildOption) {
        if (!buildOption.getLineSecondColumn().equals(line)) {
            line = buildOption.getLineSecondColumn();
            sortArray.add(buildOption);
        }
    }
}
