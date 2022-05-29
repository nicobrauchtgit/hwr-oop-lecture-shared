package hwr.oop.exercises.flashcards;

public interface Answer extends Option {
    static Answer create(String optionText) {
        return new StringBasedAnswer(optionText);
    }
}
