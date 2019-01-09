package greg.com.model;

import java.util.List;
import greg.com.model.Item;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table (name = "characters")
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String characterName;
	private int healthPoints;
	private int manaPoints;
	private int armorPoints;
	private int damagePoints;
	
	@OneToMany
	private List<Item> items;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getManaPoints() {
		return manaPoints;
	}
	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	public int getArmorPoints() {
		return armorPoints;
	}
	public void setArmorPoints(int armorPoints) {
		this.armorPoints = armorPoints;
	}
	public int getDamagePoints() {
		return damagePoints;
	}
	public void setDamagePoints(int damagePoints) {
		this.damagePoints = damagePoints;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
