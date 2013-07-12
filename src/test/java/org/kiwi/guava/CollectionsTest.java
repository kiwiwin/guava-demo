package org.kiwi.guava;

import com.google.common.collect.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Iterables.concat;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class CollectionsTest {

    private BiMap<String,Integer> userMap;

    @Before
    public void setUp() throws Exception {
        userMap = HashBiMap.create();
        userMap.put("A", 1);
        userMap.put("B", 2);
    }

    @Test
    public void test_get_value_by_key() {
        assertThat(userMap.get("A"), is(1));
    }

    @Test
    public void test_get_key_by_value() {
        assertThat(userMap.inverse().get(1), is("A"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_cannot_have_duplicate_value() {
        userMap.put("C", 1);
    }

    @Test
    public void test_concat_lists() {
        List<String> list1 = asList("A", "B", "C");
        List<String> list2 = asList("D");
        List<String> result = Lists.newArrayList(concat(list1, list2));
        assertThat(result, hasItems("A", "D"));
    }
}
