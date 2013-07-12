package org.kiwi.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
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
}
