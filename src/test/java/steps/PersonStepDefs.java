package steps;

import io.cucumber.java.en.When;
import type.NumberedObject;
import type.Person;

import java.util.List;

public class PersonStepDefs {

    @When("I list the persons:")
    public void callMyService(final List<NumberedObject<Person>> numberedPersons) {
        numberedPersons.forEach(numberedPerson -> {
            System.out.printf("Person %s is named %s%n", numberedPerson.number(), numberedPerson.value().name());
        });
    }
}
