import java.util.*;


public class SubmissionEvaluator {
    private GradingStrategy strategy;

    public SubmissionEvaluator(GradingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(GradingStrategy strategy) { this.strategy = strategy; }

    public double evaluate(String submission, Assignment assignment) {
        return strategy.grade(submission, assignment);
    }
}
