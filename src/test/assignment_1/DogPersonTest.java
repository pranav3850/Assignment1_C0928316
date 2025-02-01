package test.assignment_1;
import java.assignment_1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DogPersonTest {
    @Test
    void testDogConstructorAndGetters() {
        Dog dog = new Dog("Buddy", 5);
        assertEquals("Buddy", dog.getName());
        assertEquals(5, dog.getAge());
    }

    @Test
    void testDogSetters() {
        Dog dog = new Dog("Buddy", 5);
        dog.setName("Max");
        dog.setAge(7);
        assertEquals("Max", dog.getName());
        assertEquals(7, dog.getAge());
    }

    @Test
    void testPersonWithoutDog() {
        Person person = new Person("Alice", 30);
        assertFalse(person.hasOldDog());
    }

    @Test
    void testPersonWithOldDog() {
        Dog oldDog = new Dog("Buddy", 12);
        Person person = new Person("Bob", 40, oldDog);
        assertTrue(person.hasOldDog());
    }

    @Test
    void testChangeDogsNameWithDog() {
        Dog dog = new Dog("Buddy", 8);
        Person person = new Person("Charlie", 35, dog);
        person.changeDogsName("Max");
        assertEquals("Max", person.getDog().get().getName());
    }

    @Test
    void testChangeDogsNameWithoutDog() {
        Person person = new Person("Dave", 28);
        Exception exception = assertThrows(RuntimeException.class, () -> person.changeDogsName("Max"));
        assertEquals("Dave does not own a dog!", exception.getMessage());
    }
}
