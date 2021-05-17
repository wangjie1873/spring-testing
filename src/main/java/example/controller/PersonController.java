package example.controller;

import example.person.Person;
import example.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addPerson(@RequestBody Person person){
        System.out.println(person);
        Person result = personRepository.save(person);
        return ResponseEntity.ok().body(result.getId());
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ResponseEntity deletePersonById(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getPersonById(@PathVariable("id") String id){
        Optional<Person> result = personRepository.findById(Integer.valueOf(id));
        return ResponseEntity.ok().body(result.isPresent()?result.get():"id = '"+id+"' has no data");
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity getPersonsAll(){
        Iterable<Person> all = personRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

}
