//Name: Zakary Haider
//Student Number: 300066608

import java.util.*;

public class Knapsack {
	public List<Item> knapsack;
	
	public Knapsack() {
		knapsack = new ArrayList<Item>();
	}
	
	public void add(Item item) {
		knapsack.add(item);
	}
	
	public Item get(int i) {
		return knapsack.get(i);
	}
	
	public void clear() {
		knapsack.clear();
	}
	
	public int size() {
		return knapsack.size();
	}
	
	public void remove(Item item) {
		knapsack.remove(item);
	}
	
	@Override
	public String toString() { //My version of toString()
		StringBuilder strbul=new StringBuilder();
		int i = 0;
        for(Item str : knapsack)
        {
        	i++;
        	strbul.append("Item " + i + ": ");
            strbul.append(str);
            strbul.append(", ");            	
        }
        StringBuffer sbuff = new StringBuffer(strbul.toString());
        return "[ " + sbuff.deleteCharAt(strbul.toString().length()-2).toString() + "]";
	}
}
