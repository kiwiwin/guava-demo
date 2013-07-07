package org.kiwi.guava;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ObjectCommonMethodsTest {
    @Test
    public void test_equal() {
        assertThat(new Person("kiwi"), equalTo(new Person("kiwi")));
        assertThat(new Person("kiwi"), not(equalTo(new Person("dummy"))));
    }

    @Test
    public void test_hashCode() {
        System.out.println(new Person("kiwi").hashCode());//how to test
    }

    @Test
    public void test_to_string() {
        assertThat(new Person("kiwi").toString(), is("FooClass{name=kiwi}"));
    }

    @Test
    public void test_compare_to() {
        Person person1 = new Person("kiwi");
        Person person2 = new Person("jack", 10);
        assertThat(person1.compareTo(person2), lessThan(0));
    }
}
