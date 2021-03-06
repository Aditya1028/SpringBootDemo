package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void  addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
	/*
	 * @GetMapping public List<Person> getAllPeople(){ return
	 * personService.getAllAPeople(); }
	 */
    
    @GetMapping
	 public List<String> getAllPeople(){ 
    	
    	List<String> a= new ArrayList<>();
    	a.add("John");
    	a.add("Mary");    	
    	return a;
   }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return  personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")

    public void updatePerson(@PathVariable("id") UUID id, @NonNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
