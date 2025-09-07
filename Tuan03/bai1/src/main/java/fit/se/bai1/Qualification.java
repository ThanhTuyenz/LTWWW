package fit.se.bai1;

public class Qualification {
    private String examination;
    private String board;
    private double percentage;
    private int yearOfPassing;

    public Qualification(String examination, String board, double percentage, int yearOfPassing) {
        this.examination = examination;
        this.board = board;
        this.percentage = percentage;
        this.yearOfPassing = yearOfPassing;
    }

    @Override
    public String toString() {
        return "{" +
                "Exam='" + examination + '\'' +
                ", Board='" + board + '\'' +
                ", %=" + percentage +
                ", Year=" + yearOfPassing +
                '}';
    }
}

