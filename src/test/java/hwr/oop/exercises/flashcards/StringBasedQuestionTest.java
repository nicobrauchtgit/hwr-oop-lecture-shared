package hwr.oop.exercises.flashcards;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringBasedQuestionTest {

    @Test
    void testToString() {
        StringBasedQuestion question = new StringBasedQuestion("Wann landete der erste Mensch auf dem Mond?");
        assertThat(question.toString()).isEqualTo("Wann landete der erste Mensch auf dem Mond?");
    }
}