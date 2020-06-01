// Daniel Chen
// 21 December 2019
// Pokemon battle simulator?

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;

/* todo
 * make things work
 * implement ivs
 * implement evs
 * implement catching
 * implement leveling
 */

public class PokemonSimulator {
	public class PokemonGooey extends JFrame implements ActionListener {
		JPanel pStats = new JPanel(); // health, pics if adding them, level, name, etc
		JPanel pEvent = new JPanel(); // text (e.g., <pokemon> used Water Gun!)
		JPanel pMoves = new JPanel(); // button click, probably should figure out how to put sublabels in buttons and colour buttons
		JButton[] bMoves = {new JButton(), new JButton(), new JButton(), new JButton()};
		
		String[] moves = {}; // move name
		int[] movePower = {}; // base damage
		String[] moveType = {}; // type of move
		
		String[] messages = {"<pokemon> used <move>!", "It's super effective!", "It's not very effective...", "It had no effect", "<pokemon>'s attack missed!", "<trainer> used <item>!", "<trainer> sent out <pokemon>!", "Go, <pokemon>!"};
		String[] specialMessages = {"<pokemon>'s Intimidate lowered the attack of <enemypokemon>!"};
		/* later defined variables for string set above:
			 - <pokemon>
			 - <move>
			 - <trainer>
			 - <item>
			 - <enemypokemon>
		*/
		
		public PokemonGooey() {
			pEvent.setLayout(new FlowLayout());
			pMoves.setLayout(new GridLayout(2, 2));
			pStats.setLayout(new FlowLayout());
			
			// temp testing remove later
			
			for (JButton button : bMoves) {
				pMoves.add(button);
				button.addActionListener(this);
			}
			
			add(pStats);
			add(pEvent);
			add(pMoves);
			setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
			setTitle("Pokemon Simulator");
			setSize(480, 280);
			setVisible(true);
		} // end constructor
		
		public void useMove(int move) {
			if (move == 4) {
				move = (int) (Math.random() * 4);
			}
			
			if (move == 0) {
				return;
			} else if (move == 1) {
				return;
			} else if (move == 2) {
				return;
			} else if (move == 3) {
				return;
			}
		}	
		
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == bMoves[0]) {
				return;
			} else if (event.getSource() == bMoves[1]) {
				return;
			} else if (event.getSource() == bMoves[2]) {
				return;
			} else if (event.getSource() == bMoves[3]) {
				return;
			}
		} // end actionPerformed
			
	} // end gooey

	public class Pokemon {
		String name = null;
		String[] type;
		String[] ability;
		int sAbility = 0; // selected ability, the first ability is always the hidden one
		
		int level = 1;
		int[] stats = new int[6]; // HP, Atk, Def, SpA, SpD, Spe
		int[] ivs = new int[6];
		int[] evs = new int[6];
		
		float weight = 0;
		float height = 0;
		boolean isMale = true;	
		
		String category = null;
		String[] dexEntry;
		
		// moveset
		
		// evolution data
		
		public Pokemon(String inputName, String[] inputType, String[] inputAbility, String inputCategory, String inputDexEntryString) {
			name = inputName;
			type = inputType;
			ability = inputAbility;
			category = inputCategory;
			
			char[] tempCharArray = inputDexEntryString.toCharArray();
			dexEntry = new String[((int) Math.ceil(tempCharArray.length / 20.0))];
			for (int i = 0; i < dexEntry.length; i++) {
				dexEntry[i] = "";
			}
			
			int temp = 0;
			int counter = 0;
			for (int i = 50; i < tempCharArray.length + 49; i += 50) {
				if (i > tempCharArray.length) {
					i = tempCharArray.length - 1;
				} else {
					while (tempCharArray[i] != ' ') {
						i++;
					}
				}
				
				dexEntry[counter] += inputDexEntryString.substring(temp, i + 1);
				counter++;
				temp = i + 1;
			}
		}
			
	}
	
	public PokemonSimulator() { // acts as database
		PokemonGooey window = new PokemonGooey();
		// im sure theres a more efficient way to do this but i give up screw it
		// oh yeah idiot you can just use sets of arrays like the store thing
		// but objects are cool so whatever
		Pokemon bulbasaur = new Pokemon("Bulbasaur", new String[] {"Grass", "Poison"}, new String[] {"Chlorophyll", "Overgrow"}, "Seed",
			"A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.");
		Pokemon charmander = new Pokemon("Charmander", new String[] {"Fire"}, new String[] {"Solar Power", "Blaze"}, "Lizard",
			"Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.");
		Pokemon squirtle = new Pokemon("Squirtle", new String[] {"Water"}, new String[] {"Rain Dish", "Torrent"}, "Tiny Turtle",
			"After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.");
		Pokemon pikachu = new Pokemon("Pikachu", new String[] {"Electric"}, new String[] {"Lightning Rod", "Static"}, "Mouse",
			"When several of these Pokémon gather, their electricity could build and cause lightning storms.");
		Pokemon eevee = new Pokemon("Eevee", new String[] {"Normal"}, new String[] {"Anticipation", "Run Away", "Adaptability"}, "Evolution",
			"Its genetic code is irregular. It may mutate if it is exposed to radiation from element Stones.");
	}
	
	public static void main(String[] args) {
		PokemonSimulator window = new PokemonSimulator();
	} // end main
} // end class
