package hwr.oop.examples.classes.comparability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class ComparabilityTest {

    private Train first;
    private Train second;

    private Train third;

    @BeforeEach
    void setUp() {
        first = new Train(12);
        second = new Train(13);
        third = new Train(14);
    }

    @Test
    void compareTo_FirstDrivesFasterThanSecond_FirstIsGreaterThanSecond() {
        first.accelerateTo(100);
        second.accelerateTo(90);
        int compareToResult = first.compareTo(second);
        assertThat(compareToResult).isPositive().isNotZero();
    }

    @Test
    void compareTo_FirstDrivesFasterThanSecond_SecondIsLessThanFirst() {
        first.accelerateTo(100);
        second.accelerateTo(90);
        int compareToResult = second.compareTo(first);
        assertThat(compareToResult).isNegative().isNotZero();
    }

    @Test
    void compareTo_Transitivity_firstIsEqualToSecond_secondIsEqualToThird_firstIsEqualToThird() {
        first.accelerateTo(100);
        second.accelerateTo(100);
        third.accelerateTo(100);
        int compareToResultFirst = second.compareTo(first);
        int compareToResultSecond = third.compareTo(second);
        int compareToResultThird = third.compareTo(first);
        if (compareToResultFirst == 0 && compareToResultSecond == 0) {
            assertThat(compareToResultThird).isZero();
        } else {
            throw (new RuntimeException("x = y or y = z not given"));
        }
    }

    @Test
    void railCarComparator_compare_FirstTrainShorter_FirstLessThanSecond() {
        Comparator<Train> comparator = new RailCarComparator();
        int result = comparator.compare(first, second);
        assertThat(result).isNegative().isNotZero();
    }

    @Test
    void railCarComparator_compare_FirstTrainShorter_SecondTrainGreaterThanFirst() {
        Comparator<Train> comparator = new RailCarComparator();
        int result = comparator.compare(second, first);
        assertThat(result).isPositive().isNotZero();
    }

    @Test
    void railCarComparator_compare_FirstTrainEquals_SecondTrainEquals_ThirdTrain() {
        Comparator<Train> comparator = new RailCarComparator();
        int resultOne = comparator.compare(second, first);
        int resultTwo = comparator.compare(third, second);
        int resultThree = comparator.compare(third, first);
        if (resultOne == resultTwo) {
            assertThat(resultThree).isPositive().isNotZero();
        } else {
            throw (new RuntimeException("result One does not Equal result Two"));
        }
    }
}
