package hwr.oop.exercises.flashcards;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FlashCardTest {

    private Question question;
    private Solution solution;
    private Answer answer;
    private Collection<Answer> answers;
    private FlashCard flashCard;

    @BeforeEach
    void setUp() {
        question = Question.create("Wann erschien Minecraft?");
        solution = Solution.create("18. November 2011");
        answer = Answer.create("24. Dezember 1111");
        answers = new ArrayList<>();
        flashCard = FlashCard.create(question, answers, solution);
        Collections.addAll(answers, new StringBasedAnswer("18. November 2011"), new StringBasedAnswer("23. November 2010"), new StringBasedAnswer("11. November 2013"), answer);
    }

    @Nested
    class IsInstanceOfTest {
        @Test
        void flashCard_Instances() {
            assertThat(flashCard)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(FancyFlashCard.class);
        }

        @Test
        void solution_IsClassAndSolution() {
            assertThat(solution)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Solution.class);
        }

        @Test
        void answer_IsClassAndAnswer() {
            assertThat(answer)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Answer.class);
        }

        @Test
        void question_IsClassAndQuestion() {
            assertThat(question)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Question.class);
        }
    }
    @Nested
    class FlashCardMethodTest {
        @Test
        void assertValidFlashCard_ProvidedNoQuestionNoAnswer_ThrowsIllegalArgumentException() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
                FancyFlashCard card = new FancyFlashCard(null, null);
            });
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
        @Test
        void isCorrectAnswer() {
            assertThat(flashCard.isCorrectAnswer(Answer.create("18. November 2011"))).isTrue();
            assertThat(flashCard.isCorrectAnswer(Answer.create("23. November 2010"))).isFalse();

        }

        @Test
        void equalFlashCardTest_sameHashCode(){
            FancyFlashCard temp = new FancyFlashCard(question, answers, solution);
            boolean sameCard = temp.equals(flashCard);
            assertThat(sameCard).isTrue();
            assertThat(flashCard.hashCode()).isEqualTo(temp.hashCode());
        }
        @Test
        void getOptions_AnswersProvided_ReturnsPresentOptional() {
            Optional<Collection<Answer>> optionalAnswers = flashCard.getOptions();
            assertThat(optionalAnswers).isPresent().isNotEmpty();
        }

        @Test
        void getOptions_NoAnswersProvided_ReturnsNoPresentOptional() {
            FancyFlashCard temp = new FancyFlashCard(question, solution);
            Optional<Collection<Answer>> optionalAnswers = temp.getOptions();
            assertThat(optionalAnswers).isNotPresent().isEmpty();
        }
    }
    @Nested
    class ToStringTest {
        @Test
        void solution_ToString_IsCorrectString() {
            assertThat(solution).hasToString("18. November 2011");
        }

        @Test
        void question_ToString_IsCorrectString() {
            assertThat(question).hasToString("Wann erschien Minecraft?");
        }

        @Test
        void answer_ToString_IsCorrectString() {
            assertThat(answer).hasToString("24. Dezember 1111");
        }
    }
    @Nested
    class AnswerMethodTest{
        @Test
        void answer_IsSolutionTo_IsCorrect(){
            assertThat(answer.isSolutionTo(flashCard)).isFalse();
        }

        @Test
        void answer_Equals_IsCorrect(){
            assertThat(answer.equals(Answer.create("24. Dezember 1111"))).isTrue();
        }
    }

    @Nested
    class StringBasedTest{
        @Test
        void AnswerHashCodeTest(){
            StringBasedAnswer stringBasedAnswer = new StringBasedAnswer("Test");
            StringBasedAnswer stringBasedAnswer1 = new StringBasedAnswer("Test");
            assertThat(stringBasedAnswer.hashCode()).isEqualTo(stringBasedAnswer1.hashCode());
        }

        @Test
        void SolutionHashCodeTest(){
            StringBasedSolution stringBasedSolution = new StringBasedSolution("Test");
            StringBasedSolution stringBasedSolution1 = new StringBasedSolution("Test");
            assertThat(stringBasedSolution.hashCode()).isEqualTo(stringBasedSolution1.hashCode());
        }

        @Test
        void SolutionToTest(){
            StringBasedSolution correct_solution = new StringBasedSolution("18. November 2011");
            assertThat(correct_solution.isSolutionTo(flashCard)).isTrue();
        }
    }
}
