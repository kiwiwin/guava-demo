package org.kiwi.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Person implements Comparable {
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
        Person person = (Person)obj;
        return Objects.equal(name, person.name) &&
               Objects.equal(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return ComparisonChain.start()
                .compare(this.age, person.age)
                .compare(this.name, person.name)
                .result();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
