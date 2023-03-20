package comparator;

import comparator.BuildOption;

import java.util.Comparator;

public class ComparatorBuildOptionsBySecondColumn implements Comparator<BuildOption> {
    //Сортировщик по второй группе строк
    @Override
    public int compare(BuildOption o1, BuildOption o2) {
        return o1.getLineSecondColumn().compareTo(o2.getLineSecondColumn());
    }
}
