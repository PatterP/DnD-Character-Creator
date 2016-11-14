/**
 * @author Brandon Campbell
 * @version 1.0
 */
package dndcharactercreator.classes;

public class Druid implements Class
{
	private String hitDice = "1d8";
	private int proficiencyBonus = 2;
	private String[] savingThrows = {"Intelligence", "Wisdom"};
	private String[] skills = {"Arcana", "Animal Handling", "Insight", "Medicine", "Nature", "Perception",
			"Religion", "Survival"};
	private String[] features = {"Druidic", "Spellcasting"};
	private String[] proficiencies = {"Light Armor", "Medium Armor", "Shields", "Clubs", "Daggers",
			"Darts", "Javelins", "Maces", "Quarterstaffs", "Scimtars", "Sickles", "Slings",
			"Spears", "Herbalism Kit"};
	private String[] firstEquipmentChoice = {"Wooden Shield", "Any Simple Weapon"};
	private String[] secondEquipmentChoice = {"Scimtar", "Any Simple Weapon"};
	private String [] guaranteedEquipment = {"Leather Armor", "Explorer's Pack", "Druidic Focus"};

	public Druid()
	{
		
	}

	public String getHitDice()
	{
		return hitDice;
	}

	public int getHitPoints(int constitution)
	{
		return 8 + constitution;
	}

	public int getProficiencyBonus()
	{
		return proficiencyBonus;
	}

	public String[] getSavingThrows() 
	{
		return savingThrows;
	}

	public String[] getSkills() {
		return skills;
	}

	public String[] getFeatures()
	{
		return features;
	}

	public String[] getProficiencies()
	{
		return proficiencies;
	}

	public String[] getFirstEquipmentChoice()
	{
		return firstEquipmentChoice;
	}

	public String[] getSecondEquipmentChoice()
	{
		return secondEquipmentChoice;
	}

	public String[] getThirdEquipmentChoice()
	{
		return null;
	}
	
	public String[] getFourthEquipmentChoice()
	{
		return null;
	}
	
	public String[] getGuaranteedEquipment()
	{
		return guaranteedEquipment;
	}
}