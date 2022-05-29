package hwr.oop.exercises.flashcards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class StringBasedSolutionTest {

    @Test
    void isSolutionTo() {
        Collection<Answer> answers = new ArrayList<>();
        answers.add(new StringBasedAnswer("1967"));
        answers.add(new StringBasedAnswer("1969"));
        answers.add(new StringBasedAnswer("1971"));
        StringBasedSolution solution = new StringBasedSolution("1969");
        FancyFlashCard flashCard = new FancyFlashCard(new StringBasedQuestion("Wann landete der erste Mensch auf dem Mond?"), answers, solution);
        assertThat(solution.isSolutionTo(flashCard)).isTrue();
    }

    @Test
    void testToString() {
        StringBasedQuestion question = new StringBasedQuestion("Wann landete der erste Mensch auf dem Mond?");
        assertThat(question.toString()).isEqualTo("Wann landete der erste Mensch auf dem Mond?");
    }
}