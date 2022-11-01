package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.web.api.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Validated
public class PersonRestController {

    private List<Person> person;

    public PersonRestController() {
        person = new ArrayList<>();
        person.add(new Person(1, "Max", "Mustermann"));
    }

    @GetMapping(path = "/api/v1/person")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Person> fetchPerson() {
        return person;
    }
}
