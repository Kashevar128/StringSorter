package comparator;

public class StringSimilarity {
    //Класс для посимвольного сравнения строк и отдельных слов из строк
    public static int similarity(String s1, String s2) {
        int sumEstimationsSimilarity = 0;
        int MIN = 1;
        String [] stringsS1 = s1.split(" ");
        String [] stringsS2 = s2.split(" ");
        String longer, shorter;
        for (int i = 0; i < stringsS1.length; i++) {
            int maxEstimationSimilarity = 0;
            for (int j = 0; j < stringsS2.length; j++) {
                longer = stringsS1[i];
                shorter = stringsS2[j];
                if (stringsS1[i].length() < stringsS2[j].length()) {
                    longer = stringsS2[j];
                    shorter = stringsS1[i];
                }
                int estimationSimilarity = compareLines(longer, shorter);
                if (estimationSimilarity > maxEstimationSimilarity) maxEstimationSimilarity = estimationSimilarity;
            }
            if (maxEstimationSimilarity > MIN) sumEstimationsSimilarity += maxEstimationSimilarity;
        }
        return sumEstimationsSimilarity;
    }
    private static int compareLines(String longer, String shorter) {
        int count = 0;
        int resultCount = 0;

        for (int i = 0; i < longer.length(); i++) {
            for (int j = 0; j < shorter.length(); j++) {
                if (longer.charAt(i) == shorter.charAt(j)) {
                    int i1 = i;
                    int j2 = j;
                    while (longer.charAt(i1) == shorter.charAt(j2)) {
                        if (i1 == longer.length() -1 || j2 == shorter.length() - 1) {
                            count++;
                            break;
                        }
                        i1++;
                        j2++;
                        count++;
                    }
                    if (count > resultCount) {
                        resultCount = count;
                    }
                    count = 0;
                }
            }
        }
        return resultCount;

    }
}
