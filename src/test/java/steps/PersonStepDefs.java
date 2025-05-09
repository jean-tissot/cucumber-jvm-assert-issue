package steps;

import io.cucumber.java.en.When;
import type.NumberedObject;
import type.Person;

public class PersonStepDefs {

    @When("I list the persons:")
    public void callMyService(final NumberedObject<Person> numberedPerson) {
        System.out.printf("Person %s is named %s%n", numberedPerson.number(), numberedPerson.value().name());
    }
}
