package org.kiwi.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Foo implements Comparable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return Objects.toStringHelper("FooClass")
                .add("name", this.name)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        Foo foo = (Foo)obj;
        return Objects.equal(name, foo.name) &&
               Objects.equal(age, foo.age);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    public Foo(String name) {
        this.name = name;
    }

    public Foo(String name, int age) {
        this(name);
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Foo foo = (Foo) o;
        return ComparisonChain.start()
                .compare(this.age, foo.age)
                .compare(this.name, foo.name)
                .result();
    }
}
