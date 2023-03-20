package comparator;

public class BuildOption {
    //Объект для сравнения, состоящий из строки первой и второй группы и оценки их сходства

    private String lineFirstColumn;

    private String lineSecondColumn;
    private Integer estimationSimilarity;

    public BuildOption(String lintFirstColumn, String lineSecondColumn, int estimationSimilarity) {
        this.lineFirstColumn = lintFirstColumn;
        this.lineSecondColumn = lineSecondColumn;
        this.estimationSimilarity = estimationSimilarity;
    }

    public String getLineFirstColumn() {
        return lineFirstColumn;
    }

    public String getLineSecondColumn() {
        return lineSecondColumn;
    }

    public Integer getEstimationSimilarity() {
        return estimationSimilarity;
    }

    @Override
    public String toString() {
        return "comparator.BuildOption{" +
                "lineFirstColumn='" + lineFirstColumn + '\'' +
                ", lineSecondColumn='" + lineSecondColumn + '\'' +
                ", estimationSimilarity=" + estimationSimilarity +
                '}';
    }
}
