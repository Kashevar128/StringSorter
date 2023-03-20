package comparator;

import java.util.Comparator;

public class ComparatorBuildOptionsByEstimationSimilarity implements Comparator<BuildOption> {
    //Сортировщик по уменьшению оценки сходства строк
    @Override
    public int compare(BuildOption o1, BuildOption o2) {
        if(o1.getLineSecondColumn().equals(o2.getLineSecondColumn())) {
            return o2.getEstimationSimilarity().compareTo(o1.getEstimationSimilarity());
        }
        return 0;
    }
}
