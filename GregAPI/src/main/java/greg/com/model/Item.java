package greg.com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String itemName;
	private int bonusHealth;
	private int bonusMana;
	private int bonusArmor;
	private int bonusDamage;
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getBonusHealth() {
		return bonusHealth;
	}
	public void setBonusHealth(int bonusHealth) {
		this.bonusHealth = bonusHealth;
	}
	public int getBonusMana() {
		return bonusMana;
	}
	public void setBonusMana(int bonusMana) {
		this.bonusMana = bonusMana;
	}
	public int getBonusArmor() {
		return bonusArmor;
	}
	public void setBonusArmor(int bonusArmor) {
		this.bonusArmor = bonusArmor;
	}
	public int getBonusDamage() {
		return bonusDamage;
	}
	public void setBonusDamage(int bonusDamage) {
		this.bonusDamage = bonusDamage;
	}
	
	
	

}
