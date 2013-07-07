package org.kiwi.guava;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ObjectCommonMethodsTest {
    @Test
    public void test_equal() {
        assertThat(new Foo("kiwi"), equalTo(new Foo("kiwi")));
        assertThat(new Foo("kiwi"), not(equalTo(new Foo("dummy"))));
    }

    @Test
    public void test_hashCode() {
        System.out.println(new Foo("kiwi").hashCode());//how to test
    }

    @Test
    public void test_to_string() {
        assertThat(new Foo("kiwi").toString(), is("FooClass{name=kiwi}"));
    }

    @Test
    public void test_compare_to() {
        Foo foo1 = new Foo("kiwi");
        Foo foo2 = new Foo("jack", 10);
        assertThat(foo1.compareTo(foo2), lessThan(0));
    }
}
