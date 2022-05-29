package hwr.oop.exercises.flashcards;

public interface Question {
    static Question create(String questionString) {
        return new StringBasedQuestion(questionString);
    }
    String toString();
}
