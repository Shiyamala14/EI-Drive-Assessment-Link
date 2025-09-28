import java.util.*;

public class SimplePointsStrategy implements GradingStrategy {
    @Override
    public double grade(String submission, Assignment assignment) {
        int len = (submission == null) ? 0 : submission.length();
        return Math.min(100.0, len); // toy: length maps to points
    }
}
