
import java.util.*;

public class RubricBasedStrategy implements GradingStrategy {
    @Override
    public double grade(String submission, Assignment assignment) {
        if (submission == null) return 0.0;
        if (submission.toLowerCase().contains("complete")) return 100.0;
        return 60.0;
    }
}
