package imperative;

import model.Person;

import java.util.ArrayList;
import java.util.List;

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

        // Imperative approach
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
}
