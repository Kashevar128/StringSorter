package sort;

import comparator.BuildOption;
import comparator.ComparatorBuildOptionsByEstimationSimilarity;
import comparator.ComparatorBuildOptionsByFirstColumn;
import comparator.ComparatorBuildOptionsBySecondColumn;

import java.util.ArrayList;
import java.util.List;

public class SortStringLines {

    public static void sortBuildOptions(List<BuildOption> buildOptionList, int sizeFirst, int sizeSecond) {
        //Класс для сортировки итоговых строк

        ComparatorBuildOptionsBySecondColumn comparatorBuildOptionsBySecondColumn =
                new ComparatorBuildOptionsBySecondColumn();
        ComparatorBuildOptionsByEstimationSimilarity comparatorBuildOptionsByEstimationSimilarity =
                new ComparatorBuildOptionsByEstimationSimilarity();
        ComparatorBuildOptionsByFirstColumn comparatorBuildOptionsByFirstColumn =
                new ComparatorBuildOptionsByFirstColumn();

        if (sizeFirst > sizeSecond) {
            buildOptionList.sort(comparatorBuildOptionsBySecondColumn);
        } else {
            buildOptionList.sort(comparatorBuildOptionsByFirstColumn);
        }
        buildOptionList.sort(comparatorBuildOptionsByEstimationSimilarity);
    }

    public static List<String> sortLines(List<BuildOption> buildOptionList, List<String> fullArray) {
        List<String> resultArray = new ArrayList<>();
        boolean flag = false;
        for (String line : fullArray) {
            for (BuildOption buildOption : buildOptionList) {
                if (line.equals(buildOption.getLineFirstColumn()) ||
                        line.equals(buildOption.getLineSecondColumn())) {
                    flag = true;
                    String str = String.format("%s:%s", buildOption.getLineFirstColumn(),
                            buildOption.getLineSecondColumn());
                    if (!resultArray.contains(str)) resultArray.add(str);
                    break;
                } else flag = false;
            }
            if (!flag) {
                String str = String.format("%s:?", line);
                resultArray.add(str);
            }
        }
        return resultArray;
    }
}
