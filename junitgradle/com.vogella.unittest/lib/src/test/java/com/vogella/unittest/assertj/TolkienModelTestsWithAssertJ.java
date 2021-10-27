package com.vogella.unittest.assertj;



import static com.vogella.unittest.model.Race.HOBBIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.vogella.unittest.model.Race;
import com.vogella.unittest.model.TolkienCharacter;
import com.vogella.unittest.services.DataService;


public class TolkienModelTestsWithAssertJ {

    @Test
    public void generalMatchersForLists( ) {
        List<Integer> list = Arrays.asList(5, 2, 4);
        // test has list has size of 3
        // contains the elements 2, 4, 5 in any order
        // That every item is greater than 1
        assertThat(list).hasSize(3);
        assertThat(list).containsExactlyInAnyOrder(2, 4,5);
        assertThat(list).allMatch(number -> number > 1);
    }

    @Test
    public void tolkienCharacterShouldHaveProperties() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
        // ensure that TolkienCharacter has the bean property "name"
        // ensure that TolkienCharacter has the bean property "age" with is greater than 0
        assertThat(frodo).hasFieldOrProperty("name");
        assertThat(frodo).hasFieldOrProperty("age");
        assertThat(frodo.getAge()).isGreaterThan(0);
    }

    @Test
    public void validateTolkeinCharactorsInitializationWorks() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
        //age is 33
        //name is "Frodo"
        //name is not "Frodon"
        assertThat(frodo.getAge()).isEqualTo(33);
        assertThat(frodo.getName()).isEqualTo("Frodo");
        assertThat(frodo.getName()).isNotEqualTo("Frodon");
    }

    @Test
    public void ensureThatFellowsAreNotOrcs() {
        List<TolkienCharacter> fellowship = new DataService().getFellowship();
        // ensure that no fellows is a orc
        assertThat(fellowship).extracting("race").doesNotContain(Race.ORC);
    }
}
