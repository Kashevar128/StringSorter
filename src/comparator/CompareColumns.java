package comparator;

import collector.BankOfLines;
import filter.FilterBuildOptions;
import output.OutputFile;
import sort.SortStringLines;

import java.util.ArrayList;
import java.util.List;

public class CompareColumns {
    //Класс для сравнения строк из первой и второй группы
    public static void compare(List<BankOfLines> bankOfLinesList) {
        List<String> linesFirstColumn = bankOfLinesList.get(0).getLines();
        List<String> linesSecondColumn = bankOfLinesList.get(1).getLines();
        List<BuildOption> buildOptionList = new ArrayList<>();
        for (String value : linesFirstColumn) {
            String lineFirst;
            String lineSecond;
            for (String s : linesSecondColumn) {
                lineFirst = value;
                lineSecond = s;
                int estimationSimilarity = StringSimilarity.similarity(lineFirst, lineSecond);
                BuildOption buildOption = new BuildOption(lineFirst, lineSecond, estimationSimilarity);
                buildOptionList.add(buildOption);
            }
        }
        SortStringLines.sortBuildOptions(buildOptionList, linesFirstColumn.size(), linesSecondColumn.size());
        List<BuildOption> filterBuildOptions = FilterBuildOptions
                .filter(buildOptionList, linesFirstColumn.size(), linesSecondColumn.size());
        linesFirstColumn.addAll(linesSecondColumn);
        List<String> strings = SortStringLines.sortLines(filterBuildOptions, linesFirstColumn);
        System.out.println(strings);

        OutputFile.output(strings);
    }
}
