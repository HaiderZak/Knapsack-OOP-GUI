//Name: Zakary Haider
//Student Number: 300066608

import java.util.*;
import java.io.*;

public class KnapsackProblem {

	//Static Class Variables
	private static int maxWeight;
	private static int numItems;
	private static List<Item> items = new ArrayList<Item>();
	private static Knapsack kp = new Knapsack();
	private static KTable tb = new KTable();
	private static Window w;
	private static long endTime = 0;
	private static long startTime = 0;


	public static void main(String[] args) {
		w = new Window();
		if(w.chkbox1.isSelected()) {
			KnapsackProblem b = new KnapsackProblem();
			b.bruteForceSol();
		}
		else if(w.chkbox2.isSelected()) {
			KnapsackProblem d = new KnapsackProblem();
			d.dynamicProgrammingSol();
		}
	}
	
	public long getRunTime() {
		return endTime - startTime;
	}

	public String bruteForceSol() {	
		startTime = System.nanoTime();

		//Implementation of Knapsack
		maxWeight = Integer.parseInt(w.maxWeightLabel.getText());
		numItems = Integer.parseInt(w.numItemsLabel.getText());
		String letter = "";
		int value = 0;
		int weight = 0;
		String[] values = w.valuesLabel.getText().split(" ");
		String[] weights = w.weightsLabel.getText().split(" ");
		String[] letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		for(int i=0; i<numItems; i++) {
			letter = letters[i];
			value = Integer.parseInt(values[i]);
			weight = Integer.parseInt(weights[i]);
			items.add(new Item(letter, value, weight));			
		}
		
		int weight1 = 0;
		int cost1 = 0;
		int optWeight = 0;
		int optCost = 0;
		String newVar = "";
		kp.knapsack = new ArrayList<Item>();

		List<String> arr = new ArrayList<String>();

		// Functional Part of Knapsack implemented using help from StackoverFlow:
		// https://stackoverflow.com/questions/36086370/knapsack-optimal-solutionbrute-force

		for (int i = 1; i < (1 << numItems); i++) {
			String newVariable = Integer.toBinaryString(i);
			int k = numItems - 1;
			for (int j = newVariable.length() - 1; j >= 0; j--) {
				if (newVariable.charAt(j) == '1') {
					newVar = items.get(k).getLetter();
					weight1 += items.get(k).getWeight();
					cost1 += items.get(k).getValue();
					arr.add(newVar);
				}
				k--;
			}      

			if (weight1 <= maxWeight) {
				if (optWeight == 0 && optCost == 0) {
					optWeight = weight1;
					optCost = cost1;
				} else if (optWeight <= weight1) {
					for(int l=0; l<arr.size(); l++) { //Adding Items to Knapsack
						for(int g=0; g<items.size(); g++){
							if(items.get(g).getLetter() == arr.get(l)) {
								kp.add(new Item(arr.get(l), items.get(g).getValue(), items.get(g).getWeight()));
							}
						}

					}
					optWeight = weight1;
					optCost = cost1;
				}
			}
			weight1 = 0;
			cost1 = 0;
			arr.clear();
		}
		endTime = System.nanoTime();

		return optCost + "";
	}
	public String dynamicProgrammingSol() {
		startTime = System.nanoTime();

		maxWeight = Integer.parseInt(w.maxWeightLabel.getText());
		numItems = Integer.parseInt(w.numItemsLabel.getText());
		String letter = "";
		int value = 0;
		int weight = 0;
		String[] values = w.valuesLabel.getText().split(" ");
		String[] weights = w.weightsLabel.getText().split(" ");
		String[] letters = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		for(int i=0; i<numItems; i++) {
			letter = letters[i];
			value = Integer.parseInt(values[i]);
			weight = Integer.parseInt(weights[i]);
			items.add(new Item(letter, value, weight));			
		}
		
		tb.table = new ArrayList<Knapsack>();
		kp.knapsack = new ArrayList<Item>();			

		int[][] M = new int[numItems + 2][maxWeight + 1];

		// TB => [ [Item 1, Item 2], [Item 3, Item 4], [Item 3, Item 5], [Item 2], [Item 2, Item 3, Item 4] ... numItems * maxWeight ]
		//Dynamic Programming Knapsack Implementation (Modified): https://www.baeldung.com/java-knapsack
		for(int i=1; i<numItems + 1; i++) {
			for(int j=1; j<maxWeight + 1; j++) {
				tb.add(new Knapsack());
				if(items.get(i-1).getWeight() > j) {
					M[i][j] = M[i-1][j];
				}
				else { // get the max of => M[i-1][j] , M[i-1][j-items.get(i-1).getWeight()] + items.get(i-1).getValue()
					if(M[i-1][j] > M[i-1][j-items.get(i-1).getWeight()] + items.get(i-1).getValue()) {
						M[i][j] = M[i-1][j];
					}
					else {
						M[i][j] = M[i-1][j-items.get(i-1).getWeight()] + items.get(i-1).getValue();
					}
				}
			}
		}
		endTime = System.nanoTime();

		return M[numItems][maxWeight] + "";
	}
}
