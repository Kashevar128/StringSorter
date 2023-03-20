package comparator;

import comparator.BuildOption;

import java.util.Comparator;

public class ComparatorBuildOptionsByFirstColumn implements Comparator<BuildOption> {
    //Сортировщик по первой группе строк
    @Override
    public int compare(BuildOption o1, BuildOption o2) {
        return o1.getLineFirstColumn().compareTo(o2.getLineFirstColumn());
    }
}
