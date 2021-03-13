//Name: Zakary Haider
//Student Number: 300066608

import java.util.*;

public class KTable {
	public List<Knapsack> table;
	
	public void add(Knapsack items) {
		table.add(items);
	}
	
	public Knapsack get(int i) {
		return table.get(i);
	}
	
	public void remove(int i) {
		table.remove(i);
	}
	
	@Override
	public String toString() { //My version of toString()
		StringBuilder strbul=new StringBuilder();
		int i = 0;
        for(Knapsack str : table)
        {
        	i++;
        	strbul.append("Knapsack " + i + ": ");
            strbul.append(str);
            strbul.append(", ");            	
        }
        StringBuffer sbuff = new StringBuffer(strbul.toString());
        return "[ " + sbuff.deleteCharAt(strbul.toString().length()-2).toString() + "]";
	}
}
