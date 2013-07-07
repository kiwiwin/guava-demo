package org.kiwi.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import static com.google.common.collect.ImmutableList.of;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StringsTest {
    @Test
    public void test_joiner() {
        Joiner joiner = Joiner.on(", ").useForNull("NULL");
        String result = joiner.join("A", "B", null, "C");
        assertThat(result, is("A, B, NULL, C"));
    }

    @Test
    public void test_splitter() {
        Iterable<String> result = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("A, B, , C");
        assertThat(result, hasItems("A", "B", "C"));
    }
}
