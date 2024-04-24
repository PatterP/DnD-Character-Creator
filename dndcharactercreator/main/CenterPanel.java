package dndcharactercreator.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Random;

import dndcharactercreator.races.*;
import dndcharactercreator.classes.*;
import dndcharactercreator.classes.Class;
import dndcharactercreator.backgrounds.*;

public class CenterPanel extends JPanel
{	
	private static final long serialVersionUID = -3135316718219106468L;
	GridLayout entryGrid = new GridLayout(0,2);
	private String[] race = {"Dragonborn", "Dwarf", "Hill Dwarf", "Mountain Dwarf", "Elf", "High Elf",
			"Wood Elf", "Dark Elf", "Gnome", "Forest Gnome", "Rock Gnome", "Halfling", "Half Elf",
			"Half Orc", "Lightfoot", "Stout", "Human", "Tiefling"};
	private String[] alignment = {"Lawful Good", "Neutral Good", "Chaotic Good", "Neutral Good",
			"Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
	private String[] characterClass = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
			"Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
	private String[] backgrounds = {"Acolyte", "Charlatan", "Criminal", "Entertainer",
			"Folk Hero", "Guild Artisan", "Hermit", "Noble", "Outlander", "Sage",
			"Sailor", "Soldier", "Urchin"};
	private String personalityString = "";
	private String idealsString = "";
	private String bondsString = "";
	private String flawsString = "";
	
	public CenterPanel()
	{
		// Renderer for centering JComboBox options.
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
		
		setLayout(entryGrid);
		JLabel characterName = new JLabel("Character Name");
		add(characterName);
		characterName.setHorizontalAlignment(JLabel.CENTER);
		JTextField characterEntry = new JTextField();
		add(characterEntry);
		
		setLayout(entryGrid);
		JLabel playerName = new JLabel("Player Name");
		add(playerName);
		playerName.setHorizontalAlignment(JLabel.CENTER);
		JTextField playerEntry = new JTextField();
		add(playerEntry);
		
		JLabel alignmentLabel = new JLabel("Alignment");
		add(alignmentLabel);
		alignmentLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<String> alignmentChoice = new JComboBox<String>(alignment);
		add(alignmentChoice);
		alignmentChoice.setSelectedIndex(-1);
		alignmentChoice.setRenderer(dlcr);
		
		JLabel raceLabel = new JLabel("Race");
		add(raceLabel);
		raceLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<String> raceChoice = new JComboBox<String>(race);
		add(raceChoice);
		raceChoice.setSelectedIndex(-1);
		raceChoice.setRenderer(dlcr);
		
		JLabel classLabel = new JLabel("Class");
		add(classLabel);
		classLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<String> classChoice = new JComboBox<String>(characterClass);
		add(classChoice);
		classChoice.setSelectedIndex(-1);
		classChoice.setRenderer(dlcr);
		classChoice.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						// TODO action event for adding new ComboBox selections.
					}
				});
		
		JLabel backgroundLabel = new JLabel("Background");
		add(backgroundLabel);
		backgroundLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<String> backgroundChoice = new JComboBox<String>(backgrounds);
		add(backgroundChoice);
		backgroundChoice.setSelectedIndex(-1);
		backgroundChoice.setRenderer(dlcr);
		
		JLabel strengthLabel = new JLabel("Strength");
		add(strengthLabel);
		strengthLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<Integer> strengthNum = new JComboBox<Integer>();
		add(strengthNum);
		populateComboBox(strengthNum);
		strengthNum.setRenderer(dlcr);
		strengthNum.setSelectedIndex(-1);
		
		JLabel dexterityLabel = new JLabel("Dexterity");
		add(dexterityLabel);
		dexterityLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<Integer> dexterityNum = new JComboBox<Integer>();
		add(dexterityNum);
		populateComboBox(dexterityNum);
		dexterityNum.setRenderer(dlcr);
		dexterityNum.setSelectedIndex(-1);
		
		JLabel constitutionLabel = new JLabel("Constitution");
		add(constitutionLabel);
		constitutionLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<Integer> constitutionNum = new JComboBox<Integer>();
		add(constitutionNum);
		populateComboBox(constitutionNum);
		constitutionNum.setRenderer(dlcr);
		constitutionNum.setSelectedIndex(-1);
		
		JLabel intelligenceLabel = new JLabel("Intelligence");
		add(intelligenceLabel);
		intelligenceLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<Integer> intelligenceNum = new JComboBox<Integer>();
		add(intelligenceNum);
		populateComboBox(intelligenceNum);
		intelligenceNum.setRenderer(dlcr);
		intelligenceNum.setSelectedIndex(-1);
		
		JLabel wisdomLabel = new JLabel("Wisdom");
		add(wisdomLabel);
		wisdomLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<Integer> wisdomNum = new JComboBox<Integer>();
		add(wisdomNum);
		populateComboBox(wisdomNum);
		wisdomNum.setRenderer(dlcr);
		wisdomNum.setSelectedIndex(-1);
		
		JLabel charismaLabel = new JLabel("Charisma");
		add(charismaLabel);
		charismaLabel.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<Integer> charismaNum = new JComboBox<Integer>();
		add(charismaNum);
		populateComboBox(charismaNum);
		charismaNum.setRenderer(dlcr);
		charismaNum.setSelectedIndex(-1);
		
		JButton personalityButton = new JButton("Personality");
		add(personalityButton);
		personalityButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isPopulated(backgroundChoice) == true)
				{
					Object chosenBackground = determineBackground(backgroundChoice);
					Object personality = displayPersonalityDialogBox(chosenBackground);
					personalityString = personality.toString();
				}
			}
		});
		
		JButton idealsButton = new JButton("Ideals");
		add(idealsButton);
		idealsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isPopulated(backgroundChoice) == true)
				{
					Object chosenBackground = determineBackground(backgroundChoice);
					Object ideals = displayIdealsDialogBox(chosenBackground);
					idealsString = ideals.toString();
				}
			}
		});
		
		JButton bondsButton = new JButton("Bonds");
		add(bondsButton);
		bondsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isPopulated(backgroundChoice) == true)
				{
					Object chosenBackground = determineBackground(backgroundChoice);
					Object bonds = displayBondsDialogBox(chosenBackground);
					bondsString = bonds.toString();
				}
			}
		});
		
		JButton flawsButton = new JButton("Flaws");
		add(flawsButton);
		flawsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isPopulated(backgroundChoice) == true)
				{
					Object chosenBackground = determineBackground(backgroundChoice);
					Object flaws = displayFlawsDialogBox(chosenBackground);
					flawsString = flaws.toString();
				}
			}
		});
		
		JButton submitButton = new JButton("Generate Character");
		add(submitButton);
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Each type of entry field is added to an ArrayList that is iterated through.
				ArrayList<JTextField> textFields = new ArrayList<JTextField>();
				textFields.add(characterEntry);
				textFields.add(playerEntry);
				ArrayList<JComboBox<String>> stringCombo = new ArrayList<JComboBox<String>>();
				stringCombo.add(alignmentChoice);
				stringCombo.add(raceChoice);
				stringCombo.add(classChoice);
				stringCombo.add(backgroundChoice);
				ArrayList<JComboBox<Integer>> intCombo = new ArrayList<JComboBox<Integer>>();
				intCombo.add(strengthNum);
				intCombo.add(dexterityNum);
				intCombo.add(constitutionNum);
				intCombo.add(intelligenceNum);
				intCombo.add(wisdomNum);
				intCombo.add(charismaNum);
				// Will display an error message if all unique fields are not filled in.
				if(areAllPopulatedTextFields(textFields) == false || 
						areAllPopulatedStrings(stringCombo) == false ||
						areAllPopulatedInts(intCombo) == false)
				{
					JOptionPane.showMessageDialog(null,
						    "Some entries have not been filled in.",
						    "Missing Entries",
						    JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					// Character's racial attributes are added to ArrayList.
					List<String> character = createCharacter(characterEntry, raceChoice, strengthNum,
							dexterityNum, constitutionNum, intelligenceNum,
							wisdomNum, charismaNum);
					List<String> racialBonuses = convertString(character.get(8));
					List<String> subRacialBonuses = convertString(character.get(9));
					List<String> languages = convertString(character.get(10));
					// Each ability modifier is calculated.
					int strengthMod = getAbilityModifier(Integer.parseInt(character.get(1)));
					int dexterityMod = getAbilityModifier(Integer.parseInt(character.get(2)));
					int constitutionMod = getAbilityModifier(Integer.parseInt(character.get(3)));
					int intelligenceMod = getAbilityModifier(Integer.parseInt(character.get(4)));
					int wisdomMod = getAbilityModifier(Integer.parseInt(character.get(5)));
					int charismaMod = getAbilityModifier(Integer.parseInt(character.get(6)));
					
					// Perception is calculated.
					int perception = Integer.parseInt(character.get(5)) + 10;
					
					// Each ability modifier as well as perception is added to a list.
					List<String> abilityModifiers = new ArrayList<String>();
					abilityModifiers.add(String.valueOf(strengthMod));
					abilityModifiers.add(String.valueOf(dexterityMod));
					abilityModifiers.add(String.valueOf(constitutionMod));
					abilityModifiers.add(String.valueOf(intelligenceMod));
					abilityModifiers.add(String.valueOf(wisdomMod));
					abilityModifiers.add(String.valueOf(charismaMod));
					abilityModifiers.add(String.valueOf(perception));
					
					int constitution = (Integer.parseInt(character.get(3)));
					
					// Character's class features are added to ArrayList.
					List<String> characterClass = determineClass(classChoice, constitution);
					//List<String> savingThrows = convertString(characterClass.get(3));
					
					List<String> background = new ArrayList<String>();
					background.add(backgroundChoice.getSelectedItem().toString());
					background.add(personalityString);
					background.add(idealsString);
					background.add(bondsString);
					background.add(flawsString);
					
					List<String> skills = convertString(characterClass.get(5));
					List<String> features = convertString(characterClass.get(6));
					List<String> proficiencies = convertString(characterClass.get(7));
					List<String> guaranteedEquipment = convertString(characterClass.get(8));
					List<String> miscCharacterInfo = new ArrayList<String>();
					miscCharacterInfo.add(raceChoice.getSelectedItem().toString());
					miscCharacterInfo.add(alignmentChoice.getSelectedItem().toString());
					miscCharacterInfo.add(playerEntry.getText());
					miscCharacterInfo.add(classChoice.getSelectedItem().toString());
					try 
					{
						FillForm fill = new FillForm();
						fill.fillAllFields(character, characterClass, background,
								abilityModifiers, skills, features, proficiencies,
								guaranteedEquipment, languages,
								racialBonuses, subRacialBonuses, 
								miscCharacterInfo);
					} 
					catch (IOException ex) 
					{
						ex.getMessage();
					}
				}
			}
		});
	
		//All fields will be cleared if the user selects yes on the option pane.
		JButton clearButton = new JButton("Clear Fields");
		add(clearButton);
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int clearChoice = JOptionPane.showConfirmDialog(null, "Are you sure you "
						+ "want to clear all fields?", "Clear Confirmation",
						JOptionPane.YES_NO_OPTION);
				if(clearChoice == JOptionPane.YES_OPTION)
				{
				characterEntry.setText("");
				playerEntry.setText("");
				alignmentChoice.setSelectedIndex(-1);
				raceChoice.setSelectedIndex(-1);
				classChoice.setSelectedIndex(-1);
				backgroundChoice.setSelectedIndex(-1);
				strengthNum.setSelectedIndex(-1);
				dexterityNum.setSelectedIndex(-1);
				constitutionNum.setSelectedIndex(-1);
				intelligenceNum.setSelectedIndex(-1);
				wisdomNum.setSelectedIndex(-1);
				charismaNum.setSelectedIndex(-1);
				}
			}
		});
	}
	
	/**
	 * Fills each ability score ComboBox with 3 values rolled by a d6.
	 * @param comboBox
	 */
	public void populateComboBox(JComboBox<Integer> comboBox)
	{
		for (int i = 0; i < 3; i++) {
			int lowestRoll = Integer.MAX_VALUE;
			int total = 0;
			for (int j = 0; j < 4; j++) {
				Random r = new Random();
				int low = 1;
				int high = 6;
				int result = r.nextInt(high-low) + low;

				if (result < lowestRoll)
					lowestRoll = result;
				total += result;
			}
			total -= lowestRoll;
			comboBox.addItem(total);
		}
		//for(int i = 8; i < 17; i++)
		//{
		//	comboBox.addItem(i);
		//}
	}
	
	/**
	 * Checks if an option from the background ComboBox has been selected.
	 * @param comboChoice
	 * @return boolean
	 */
	public boolean isPopulated(JComboBox<String> comboChoice)
	{
		Object userBackground = comboChoice.getSelectedItem();
		if(userBackground == null)
		{
			JOptionPane.showMessageDialog(null,
				    "No background has been selected.",
				    "Background Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Checks if all ComboBoxes containing strings have an option selected.
	 * @param comboBox
	 * @return boolean
	 */
	public boolean areAllPopulatedStrings(ArrayList<JComboBox<String>> comboBox)
	{
		for(JComboBox<String> entry : comboBox)
		{
			if(entry.getSelectedItem() == null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if all ComboBoxes containing integers have an option selected.
	 * @param comboBox
	 * @return boolean
	 */
	public boolean areAllPopulatedInts(ArrayList<JComboBox<Integer>> comboBox)
	{
		for(JComboBox<Integer> entry : comboBox)
		{
			if(entry.getSelectedItem() == null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if all text fields have been filled.
	 * @param entryField
	 * @return boolean
	 */
	public boolean areAllPopulatedTextFields(ArrayList<JTextField> entryField)
	{
		for(JTextField entry : entryField)
		{
			if(entry.getText().trim().equals(""))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines the object associated with the ComboBox choice. This object
	 * will have to be cast to its proper type in order to be used.
	 * @param comboChoice, characterEntry, strengthNum, dexterityNum,
	 * constitutionNum, intelligenceNum, wisdomNum, charismaNum
	 * @return race
	 */
	public ArrayList<String> createCharacter(JTextField characterEntry, JComboBox<String> raceChoice,
			JComboBox<Integer> strengthNum,
			JComboBox<Integer> dexterityNum, JComboBox<Integer> constitutionNum,
			JComboBox<Integer> intelligenceNum, JComboBox<Integer> wisdomNum,
			JComboBox<Integer> charismaNum)
	{
		String name = characterEntry.getText();
		int strength = getAbilityScore(strengthNum);
		int dexterity = getAbilityScore(dexterityNum);
		int constitution = getAbilityScore(constitutionNum);
		int intelligence = getAbilityScore(intelligenceNum);
		int wisdom = getAbilityScore(wisdomNum);
		int charisma = getAbilityScore(charismaNum);
		ArrayList<String> attributes = new ArrayList<String>();
		String choice = (String)raceChoice.getSelectedItem();
		switch(choice)
		{
		case "Dark Elf": DarkElf darkElfRace = new DarkElf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = darkElfRace.getAllAttributes();
			break;
		case "Dragonborn": Dragonborn dragonbornRace = new Dragonborn(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = dragonbornRace.getAllAttributes();
			break;
		case "Dwarf": Dwarf dwarfRace = new Dwarf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = dwarfRace.getAllAttributes();
			break;
		case "Elf": Elf elfRace = new Elf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = elfRace.getAllAttributes();
			break;
		case "Forest Gnome": ForestGnome forestGnomeRace = new ForestGnome(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = forestGnomeRace.getAllAttributes();
			break;
		case "Gnome": Gnome gnomeRace = new Gnome(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = gnomeRace.getAllAttributes();
			break;
		case "Half Elf": HalfElf halfElfRace = new HalfElf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = halfElfRace.getAllAttributes();
			break;
		case "Halfling": Halfling halflingRace = new Halfling(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = halflingRace.getAllAttributes();
			break;
		case "Half Orc": HalfOrc halfOrcRace = new HalfOrc(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = halfOrcRace.getAllAttributes();
			break;
		case "High Elf": HighElf highElfRace = new HighElf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = highElfRace.getAllAttributes();
			break;
		case "Hill Dwarf": HillDwarf hillDwarfRace = new HillDwarf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = hillDwarfRace.getAllAttributes();
			break;
		case "Human": Human humanRace = new Human(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = humanRace.getAllAttributes();
			break;
		case "Lightfoot": LightFoot lightFootRace = new LightFoot(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = lightFootRace.getAllAttributes();
			break;
		case "Mountain Dwarf": MountainDwarf mountainDwarfRace = new MountainDwarf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = mountainDwarfRace.getAllAttributes();
			break;
		case "Rock Gnome": RockGnome rockGnomeRace = new RockGnome(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = rockGnomeRace.getAllAttributes();
			break;
		case "Stout": Stout stoutRace = new Stout(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = stoutRace.getAllAttributes();
			break;
		case "Tiefling": Tiefling tieflingRace = new Tiefling(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = tieflingRace.getAllAttributes();
			break;
		case "Wood Elf": WoodElf woodElfRace = new WoodElf(name, strength, dexterity, constitution,
				intelligence, wisdom, charisma);
				attributes = woodElfRace.getAllAttributes();
			break;
		}
		return attributes;
	}
	
	/**
	 * Method for returning all attributes associated with the selected class.
	 * @param classChoice
	 * @param constitution
	 * @return features
	 */
	public ArrayList<String> determineClass(JComboBox<String> classChoice, 
			int constitution)
	{
		String choice = (String)classChoice.getSelectedItem();
		ArrayList<String> features = new ArrayList<String>();
		switch(choice)
		{
		case "Barbarian": Barbarian barbarianClass = new Barbarian();
				features = barbarianClass.getAllFeatures(constitution);
			break;
		case "Bard": Bard bardClass = new Bard();
				features = bardClass.getAllFeatures(constitution);
			break;
		case "Cleric": Cleric clericClass = new Cleric();
				features = clericClass.getAllFeatures(constitution);
			break;
		case "Druid": Druid druidClass = new Druid();
				features = druidClass.getAllFeatures(constitution);
			break;
		case "Fighter": Fighter fighterClass = new Fighter();
				features = fighterClass.getAllFeatures(constitution);
			break;
		case "Monk": Monk monkClass = new Monk();
				features = monkClass.getAllFeatures(constitution);
			break;
		case "Paladin": Paladin paladinClass = new Paladin();
				features = paladinClass.getAllFeatures(constitution);
			break;
		case "Ranger": Ranger rangerClass = new Ranger();
				features = rangerClass.getAllFeatures(constitution);
			break;
		case "Rogue": Rogue rogueClass = new Rogue();
				features = rogueClass.getAllFeatures(constitution);
			break;
		case "Sorcerer": Sorcerer sorcererClass = new Sorcerer();
				features = sorcererClass.getAllFeatures(constitution);
			break;
		case "Warlock": Warlock warlockClass = new Warlock();
				features = warlockClass.getAllFeatures(constitution);
			break;
		case "Wizard": Wizard wizardClass = new Wizard();
				features = wizardClass.getAllFeatures(constitution);
			break;
		}
		return features;
	}
	
	/**
	 * Determines the object associated with the ComboBox choice. This object
	 * is passed into the populateDialogBox method to be cast as type Class.
	 * @param comboChoice
	 * @return background
	 */
	public Object determineClass(JComboBox<String> comboChoice)
	{
		Object classChoice = null;
		String choice = (String)comboChoice.getSelectedItem();
		switch(choice)
		{
		case "Barbarian": classChoice = new Barbarian();
			break;
		case "Bard": classChoice = new Bard();
			break;
		case "Cleric": classChoice = new Cleric();
			break;
		case "Druid": classChoice = new Druid();
			break;
		case "Fighter": classChoice = new Fighter();
			break;
		case "Monk": classChoice = new Monk();
			break;
		case "Paladin": classChoice = new Paladin();
			break;
		case "Ranger": classChoice = new Ranger();
			break;
		case "Rogue": classChoice = new Rogue();
			break;
		case "Sorcerer": classChoice = new Sorcerer();
			break;
		case "Warlock": classChoice = new Warlock();
			break;
		case "Wizard": classChoice = new Wizard();
			break;
		}
		return classChoice;
	}
	
	/**
	 * Determines the object associated with the ComboBox choice. This object
	 * is passed into the populateDialogBox method to be cast as type Background.
	 * @param comboChoice
	 * @return background
	 */
	public Object determineBackground(JComboBox<String> comboChoice)
	{
		Object background = null;
		String choice = (String)comboChoice.getSelectedItem();
		switch(choice)
		{
		case "Acolyte": background = new Acolyte();
			break;
		case "Charlatan": background = new Charlatan();
			break;
		case "Criminal": background = new Criminal();
			break;
		case "Entertainer": background = new Entertainer();
			break;
		case "Folk Hero": background = new FolkHero();
			break;
		case "Guild Artisan": background = new GuildArtisan();
			break;
		case "Hermit": background = new Hermit();
			break;
		case "Noble": background = new Noble();
			break;
		case "Outlander": background = new Outlander();
			break;
		case "Sage": background = new Sage();
			break;
		case "Sailor": background = new Sailor();
			break;
		case "Soldier": background = new Soldier();
			break;
		case "Urchin": background = new Urchin();
			break;
		}
		return background;
	}
	
	/**
	 * Populates a dialog box pop up with personality traits for selected background.
	 * @param comboBoxSelection
	 * @return personalityComboBox.getSelectedItem()
	 */
	public Object displayPersonalityDialogBox(Object comboBoxSelection)
	{
		Background userBackground = (Background) comboBoxSelection;
		String[] backgroundPersonalityTraits = userBackground.getPersonalityTraits();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Choose a personality trait: "));
		JComboBox<String> personalityComboBox = new JComboBox<String>(backgroundPersonalityTraits);
		panel.add(personalityComboBox);
		int result = JOptionPane.showConfirmDialog(null, panel, "Personality Traits For " 
		+ userBackground.getBackgroundName(), JOptionPane.OK_CANCEL_OPTION);
		
		if(result == JOptionPane.OK_OPTION)
		{
			return personalityComboBox.getSelectedItem();
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Populates a dialog box pop up with ideals for selected background.
	 * @param comboBoxSelection
	 * @return idealsComboBox.getSelectedItem()
	 */
	public Object displayIdealsDialogBox(Object comboBoxSelection)
	{
		Background userBackground = (Background) comboBoxSelection;
		String[] backgroundIdeals = userBackground.getIdeals();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Choose a personality trait: "));
		JComboBox<String> idealsComboBox = new JComboBox<String>(backgroundIdeals);
		panel.add(idealsComboBox);
		int result = JOptionPane.showConfirmDialog(null, panel, "Ideals For " 
		+ userBackground.getBackgroundName(), JOptionPane.OK_CANCEL_OPTION);
		
		if(result == JOptionPane.OK_OPTION)
		{
			return idealsComboBox.getSelectedItem();
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Populates a dialog box pop up with bonds for selected background.
	 * @param comboBoxSelection
	 * @return bondsComboBox.getSelectedItem()
	 */
	public Object displayBondsDialogBox(Object comboBoxSelection)
	{
		Background userBackground = (Background) comboBoxSelection;
		String[] backgroundBonds = userBackground.getBonds();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Choose a bond: "));
		JComboBox<String> bondsComboBox = new JComboBox<String>(backgroundBonds);
		panel.add(bondsComboBox);
		int result = JOptionPane.showConfirmDialog(null, panel, "Bonds For " 
		+ userBackground.getBackgroundName(), JOptionPane.OK_CANCEL_OPTION);
		
		if(result == JOptionPane.OK_OPTION)
		{
			return bondsComboBox.getSelectedItem();
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Populates a dialog box pop up with flaws for selected background.
	 * @param comboBoxSelection
	 * @return flawsComboBox.getSelectedItem()
	 */
	public Object displayFlawsDialogBox(Object comboBoxSelection)
	{
		Background userBackground = (Background) comboBoxSelection;
		String[] backgroundFlaws = userBackground.getFlaws();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Choose a flaw: "));
		JComboBox<String> flawsComboBox = new JComboBox<String>(backgroundFlaws);
		panel.add(flawsComboBox);
		int result = JOptionPane.showConfirmDialog(null, panel, "Flaws For " 
		+ userBackground.getBackgroundName(), JOptionPane.OK_CANCEL_OPTION);
		
		if(result == JOptionPane.OK_OPTION)
		{
			return flawsComboBox.getSelectedItem();
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Gets the ability score entered by the user for one ComboBox.
	 * @param comboBoxSelection
	 * @return
	 */
	public int getAbilityScore(JComboBox<Integer> comboBoxSelection)
	{
		return (int)comboBoxSelection.getSelectedItem();
	}
	
	public int getAbilityModifier(int abilityNum)
	{
		int modifier = 0;
		if(abilityNum == 16 || abilityNum == 17)
		{
			modifier = 3;
		}
		if(abilityNum == 14 || abilityNum == 15)
		{
			modifier = 2;
		}
		if(abilityNum == 12 || abilityNum == 13)
		{
			modifier = 1;
		}
		if(abilityNum == 10 || abilityNum == 11)
		{
			modifier = 0;
		}
		if(abilityNum == 8 || abilityNum == 9)
		{
			modifier = -1;
		}
		return modifier;
	}
	
	/**
	 * Returns the saving throw numbers the class if prodicient in.
	 * @param abilityNum
	 * @param proficiencyBonus
	 * @return
	 */
	public int getProficientSavingThrow(int abilityNum, int proficiencyBonus)
	{
		return abilityNum + proficiencyBonus;
	}
	
	/**
	 * Takes a string and places each comma separated word into a list.
	 * @param string
	 * @return
	 */
	public List<String> convertString(String string)
	{
		String noBrackets = string.substring(1, string.length() - 1);
		List<String> list = Arrays.asList(noBrackets.split("\\s*,\\s*"));
		return list;
	}
	
	// TODO add all class cases.
	public void createAdditionalChoices(String comboChoice)
	{
		switch(comboChoice)
		{
		case "Barbarian":
			// createRow for first and second equipment choice.
			break;
		case "Bard":
			break;
		}
	}
	
	// TODO Make this method work.
	public void createRow(Object comboBoxSelection, String numChoice)
	{
		Class classChoice = (Class) comboBoxSelection;
		String[] equipment = classChoice.getFirstEquipmentChoice();
		JLabel choice = new JLabel(numChoice + " Equipment Choice:");
		add(choice);
		choice.setHorizontalAlignment(JLabel.CENTER);
		JComboBox<String> choices = new JComboBox<String>(equipment);
		add(choices);
		choices.setSelectedIndex(-1);
	}
}