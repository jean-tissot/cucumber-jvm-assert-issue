package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import type.NumberedObject;
import type.Person;

import java.util.List;
import java.util.Map;

public class PersonStepDefs {

    @DataTableType
    @SuppressWarnings("unused")
    public NumberedObject<Person> numberedPerson(Map<String, String> datatable) {
        return new NumberedObject<>(Integer.parseInt(datatable.get("#")), new Person(datatable.get("name")));
    }

    @When("I list the persons:")
    public void callMyService(final List<NumberedObject<Person>> numberedPersons) {
        numberedPersons.forEach(numberedPerson -> {
            System.out.printf("Person %s is named %s%n", numberedPerson.number(), numberedPerson.value().name());
        });
    }
}
