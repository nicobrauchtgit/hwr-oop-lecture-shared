package hwr.oop.exercises.flashcards;

public interface Solution extends Option {
    static Solution create(String solutionText) {
        return new StringBasedSolution(solutionText);
    }
}
