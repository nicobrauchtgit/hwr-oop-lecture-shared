package hwr.oop.exercises.flashcards;

import hwr.oop.exercises.flashcards.Answer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class StringBasedAnswerTest {

    @Test
    void isSolutionTo() {
        Collection<Answer> answers = new ArrayList<>();
        StringBasedAnswer answer1 = new StringBasedAnswer("1967");
        StringBasedAnswer answer2 = new StringBasedAnswer("1969");
        StringBasedAnswer answer3 = new StringBasedAnswer("1971");
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        FancyFlashCard flashCard = new FancyFlashCard(new StringBasedQuestion("Wann landete der erste Mensch auf dem Mond?"), answers, new StringBasedSolution("1969"));
        assertThat(answer2.isSolutionTo(flashCard)).isTrue();
    }

    @Test
    void testToString() {
        StringBasedAnswer answer = new StringBasedAnswer("1969");
        assertThat(answer.toString()).isEqualTo("1969");
    }
}