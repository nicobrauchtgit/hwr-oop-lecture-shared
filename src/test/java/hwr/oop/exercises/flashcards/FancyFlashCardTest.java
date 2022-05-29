package hwr.oop.exercises.flashcards;

import hwr.oop.exercises.flashcards.Answer;
import hwr.oop.exercises.flashcards.Solution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class FancyFlashCardTest {

    @Test
    void testInstances() {
        Collection<Answer> answers = new ArrayList<>();
        Collections.addAll(answers, new StringBasedAnswer("1967"), new StringBasedAnswer("1969"), new StringBasedAnswer("1971"));
        FancyFlashCard flashCard = new FancyFlashCard(new StringBasedQuestion("Wann landete der erste Mensch auf dem Mond?"), answers, new StringBasedSolution("1969"));
        assertThat(flashCard.getSolution())
                .isInstanceOf(Solution.class)
                .isInstanceOf(StringBasedSolution.class);
    }

    @Test
    void getSolution() {
        Collection<Answer> answers = new ArrayList<>();
        Collections.addAll(answers, new StringBasedAnswer("1967"), new StringBasedAnswer("1969"), new StringBasedAnswer("1971"));
        StringBasedSolution solution = new StringBasedSolution("1969");
        FancyFlashCard flashCard = new FancyFlashCard(new StringBasedQuestion("Wann landete der erste Mensch auf dem Mond?"), answers, solution);
        assertThat(flashCard.getSolution()).isEqualTo(solution);
        assertThat(flashCard.getSolution().hashCode()).isEqualTo(solution.hashCode());
    }

    @Test
    void getQuestion() {
    }

    @Test
    void getOptions() {
    }

    @Test
    void isCorrectAnswer() {
    }
}