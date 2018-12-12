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


import greg.com.model.Item;
import greg.com.repository.ItemRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ItemController {
	@Autowired
	private ItemRepository repository;
	
	
	@GetMapping("/item")
	List<Item> getAllItems(){
		return repository.findAll();
	}
	
	@GetMapping("/item/{id}")
	ResponseEntity<Item> getItemById(@PathVariable(value="id") long id) {
	    Item item = repository.findOne(id);
	    if(item == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(item);
	}
	
	@PostMapping("/item")
	Item addItem(@Valid @RequestBody Item item){
		return repository.save(item);
	}
	
	@PutMapping("/item/{id}")
	ResponseEntity<Item> updateItem(@PathVariable(value="id") long id, @Valid @RequestBody Item item){
		Item itemToUpdate = repository.findOne(id);
		if(itemToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		itemToUpdate.setItemName(item.getItemName());
		itemToUpdate.setBonusHealth(item.getBonusHealth());
		itemToUpdate.setBonusMana(item.getBonusMana());
		itemToUpdate.setBonusArmor(item.getBonusArmor());
		itemToUpdate.setBonusDamage(item.getBonusDamage());
			
		Item updatedItem = repository.save(itemToUpdate);
		return ResponseEntity.ok(updatedItem);
	}
		

	@DeleteMapping("/item/{id}")
	ResponseEntity<Item> deleteItem(@PathVariable(value="id") long id){
		Item item = repository.findOne(id);
		if(item == null)
			return ResponseEntity.notFound().build();
		
		repository.delete(item);
		return ResponseEntity.ok().build();
	}

}
