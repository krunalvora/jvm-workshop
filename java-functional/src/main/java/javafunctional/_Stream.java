package javafunctional;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("personA", Person.Gender.MALE),
                new Person("personB", Person.Gender.FEMALE),
                new Person("personC", Person.Gender.MALE),
                new Person("personD", Person.Gender.FEMALE),
                new Person("personE", Person.Gender.MALE),
                new Person("personF", Person.Gender.MALE)
        );

        imperative(people);
        declarative(people);
    }

    static void imperative(List<Person> people) {
        List<Person> females = new ArrayList<>();
        for (Person person: people) {
            if (person.getGender().equals(Person.Gender.FEMALE)) {
                females.add(person);
            }
        }
        for (Person female: females) {
            System.out.println(female);
        }
    }

    static void declarative(List<Person> people) {
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Person.Gender.FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);
    }
}
