package org.kiwi.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Functions.forMap;
import static com.google.common.collect.ImmutableList.of;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionalTest {

    private static final int YOUNG_AGE = 18;
    private final List<Person> persons = of(new Person("jack", 21), new Person("lucy", 22), new Person("young", 4));

    @Test
    public void test_filter() {
        List<Person> expected = of(new Person("jack", 21), new Person("lucy", 22));
        List<Person> adults = Lists.newArrayList(filter(persons, isAdult()));
        assertThat(adults, is(expected));
    }

    private Predicate<Person> isAdult() {
        return new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getAge() > YOUNG_AGE;
            }
        };
    }

    @Test
    public void test_transform() {
        List<String> expected = of("jack", "lucy", "young");
        List<String> names = Lists.newArrayList(transform(persons, getPersonName()));
        assertThat(names, is(expected));
    }

    private Function<Person, String> getPersonName() {
        return new Function<Person, String>() {
            @Override
            public String apply(Person foo) {
                return foo.getName();
            }
        };
    }

    @Test
    public void test_fluentIterable() {
        List<String> expected = of("jack", "lucy");
        List<String> adultNames = Lists.newArrayList(FluentIterable.from(persons).filter(isAdult()).transform(getPersonName()));
        assertThat(adultNames, is(expected));
    }

    @Test
    public void test_forMap() {
        Map<Person, String> personCountryMap = ImmutableMap.of(new Person("A"), "USA", new Person("B"), "CHN");
        Function<Person, String> mapFunction = forMap(personCountryMap, "JPN");
        assertThat(mapFunction.apply(new Person("C")), is("JPN"));
        assertThat(mapFunction.apply(new Person("A")), is("USA"));
    }
}