//Name: Zakary Haider
//Student Number: 300066608

public class Item {
	String letter;
	int value;
	int weight;
	
	public Item(String letter, int value, int weight) {
		this.letter = letter;
		this.value = value;
		this.weight = weight;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getLetter() {
		return letter;
	}
	
	@Override
	public String toString() {
		return "[" + getLetter() + "," + getValue() + "," + getWeight() + "]";
	}
}
