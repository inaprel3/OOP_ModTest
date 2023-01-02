package com.company;
import com.beust.jcommander.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class MainTest {
    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll init() method called");
    }

    @org.junit.jupiter.api.BeforeEach
    @Timeout(15)
    void setUp() {
        System.out.println("________________________________________\n");
        System.out.println("setUp() method runs before each testcase");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("tearDown() method runs after each testcase");
        System.out.println("________________________________________\n");
    }

    @Test
    void main() {
        System.out.println("This is the testcase in this class");
        String someString = "Number of dishes: ";
        assumingThat(
                someString.equals("Number of dishes"),
                () -> assertEquals(2 + 3, 5)
        );
        int actual = 5;
        System.out.println(someString + actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Cakes,        20",
            "Hot Dog,      54",
            "Tacos,        66",
            "Rolls,        102",
            "Dumplings,    72"
    })
    void merge(String dishes_in_menu, int prices_of_dishes) {
        assertNotNull(dishes_in_menu);
        assertNotEquals(0, prices_of_dishes);
        System.out.println("dishes_in_menu: " + dishes_in_menu + ", prices_of_dishes: " + prices_of_dishes);
    }

    @Test
    @EnabledIf("customCondition")
    void getMostFrequentNumbers() {
        assumeTrue(true);
        assertEquals(1 + 1, 2);
        System.out.println("getMostFrequentNumbers method runs");
    }
    boolean customCondition() {
        return true;
    }

    @Test
    void indexOf() {
        Main main1 = new Main();
        main1.indexOf(new int[]{1,2,3},2);
        System.out.println("indexOf method runs");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(String input) {
        assertTrue(Strings.isStringEmpty(input));
        System.out.println("input in isEmpty method: " + input);
    }

    @Test
    void asList() {
        System.out.println("asList method");
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("After All cleanUp() method called");
    }
}
