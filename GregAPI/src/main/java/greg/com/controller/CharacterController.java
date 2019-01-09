package greg.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greg.com.model.Character;
import greg.com.repository.CharacterRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CharacterController {
	@Autowired
	private CharacterRepository repository;


	@GetMapping("/characters")
	List<Character> getAllCharacters(){
		return repository.findAll();
	}


	@GetMapping("/characters/{id}")
	ResponseEntity<Character> getCharacterById(@PathVariable(value="id") long id) {
		Character character = repository.findOne(id);
		if(character == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(character);
	}


	@PostMapping("/formCharacters")
	Character addCharacter(@Valid @RequestBody Character character){
		return repository.save(character);
	}


	@PutMapping("/characters/{id}")
	ResponseEntity<Character> updateCharacter(@PathVariable(value="id") long id, @Valid @RequestBody Character character){
		Character characterToUpdate = repository.findOne(id);
		if(characterToUpdate == null)
			return ResponseEntity.notFound().build();




		characterToUpdate = character;

		Character updatedCharacter = repository.save(characterToUpdate);
		return ResponseEntity.ok(updatedCharacter);
	}


	@DeleteMapping("/characters/{id}")
	ResponseEntity<Character> deleteCharacter(@PathVariable(value="id") long id){
		Character character = repository.findOne(id);
		if(character == null)
			return ResponseEntity.notFound().build();

		repository.delete(character);
		return ResponseEntity.ok().build();
	}
}
