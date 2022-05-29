package hwr.oop.exercises.flashcards;

import hwr.oop.exercises.flashcards.Answer;
import hwr.oop.exercises.flashcards.Question;
import hwr.oop.exercises.flashcards.Solution;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class FlashCardTest {

    Question question = Question.create("Wann erschien Minecraft?");
    Solution solution = Solution.create("18. November 2011");
    Collection<Answer> answers = new ArrayList<>();
    FancyFlashCard flashCard = new FancyFlashCard(question, answers, solution);


    void setUp() {
        Collections.addAll(answers, new StringBasedAnswer("18. November 2011"), new StringBasedAnswer("23. November 2010"), new StringBasedAnswer("11. November 2013"));
    }

    @Nested
    class IsInstanceOfTest {
        @Test
        void testInstances() {
            assertThat(flashCard.getSolution())
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Solution.class)
                    .isInstanceOf(StringBasedSolution.class);
        }

        @Test
        void getSolution() {
            assertThat(flashCard.getSolution()).isEqualTo(solution);
            assertThat(flashCard.getSolution().hashCode()).hasSameHashCodeAs(solution.hashCode());
        }

        @Test
        void getQuestion() {
            assertThat(flashCard.getQuestion()).isEqualTo(question);
            assertThat(flashCard.getQuestion().hashCode()).hasSameHashCodeAs(question.hashCode());
        }

        //Needs to be finished
        @Test
        void getOptions() {
            //ToDo
            //Assertions.assertIterableEquals(Collections.singleton(flashCard.getOptions()), answers);
            //assertThat(flashCard.getOptions()).isEqualTo(answers); //Maybe different Equals - Both Collections
            assertThat(flashCard.getOptions().hashCode()).hasSameHashCodeAs(answers.hashCode());
        }

        @Test
        void isCorrectAnswer() {
            //ToDo
        }

        @Test
        void solution_IsClassAndSolution(){
            assertThat(solution)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Solution.class);
        }

    }
}
