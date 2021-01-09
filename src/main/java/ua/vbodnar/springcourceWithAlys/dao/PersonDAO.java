package ua.vbodnar.springcourceWithAlys.dao;

import org.springframework.stereotype.Component;
import ua.vbodnar.springcourceWithAlys.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ihor"));
        people.add(new Person(++PEOPLE_COUNT, "Roman"));
        people.add(new Person(++PEOPLE_COUNT, "Oleh"));
        people.add(new Person(++PEOPLE_COUNT, "Illya"));
    }

    public List<Person> allPeople () {
        return people;
    }

    public Person show (int id) {
// стрімом віфільтрувати ліст people по вхідному id, якщо такий присутній, якщо ні - повернути null
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
//        for (Person person : people) {
//            if (person.getId()==id) {
//                return person;
//            } else return null;
//        }
//        return people;
    }
// метод який додасть нову людину в ліст і перед додаванням встановить їй наступну ID
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

}
