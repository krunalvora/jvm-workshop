package declarative;

import model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("personA", Person.Gender.MALE),
                new Person("personB", Person.Gender.FEMALE),
                new Person("personC", Person.Gender.MALE),
                new Person("personD", Person.Gender.FEMALE),
                new Person("personE", Person.Gender.MALE),
                new Person("personF", Person.Gender.MALE)
        );

        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Person.Gender.FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);
    }
}
