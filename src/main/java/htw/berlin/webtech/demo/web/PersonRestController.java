package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.service.PersonService;
import htw.berlin.webtech.demo.web.api.Person;
import htw.berlin.webtech.demo.web.api.PersonCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/api/v1/person")
    public ResponseEntity<List<Person>> fetchPerson() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(path = "/api/v1/person")
    public ResponseEntity<Void> createPerson(@RequestBody PersonCreateRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/v1/person/" + person.getId());
        return ResponseEntity.created(uri).build();
    }
}
