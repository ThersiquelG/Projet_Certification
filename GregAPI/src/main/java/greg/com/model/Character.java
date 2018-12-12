package greg.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	
	

}
