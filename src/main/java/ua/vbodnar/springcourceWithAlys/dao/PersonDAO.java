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
        people.add(new Person(++PEOPLE_COUNT, "Ihor", 10, "ihor10@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Roman", 15, "roman15@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Oleh", 20, "oleh20@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Illya", 26, "illya26@gmail.com"));
    }

    public List<Person> allPeople () {
        return people;
    }

    public Person show (int id) {
// стрімом віфільтрувати ліст people по вхідному id, якщо такий присутній, якщо ні - повернути null
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
// метод який додасть нову людину в ліст і перед додаванням встановить їй наступну ID
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete (int id) {
        people.removeIf(person -> person.getId()==id);
    }
}
