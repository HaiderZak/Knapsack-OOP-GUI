//Name: Zakary Haider
//Student Number: 300066608

public class KnapsackProblem {

	//Static Class Variables
	private static int maxWeight;
	private static int numItems;
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
		maxWeight = Integer.parseInt(w.maxWeightLabel.getText());
		numItems = Integer.parseInt(w.numItemsLabel.getText());
		int[] values = new int[numItems];
		int[] weights = new int[numItems];
		for(int i=0; i<numItems; i++) {
			String[] newElementV = w.valuesLabel.getText().split(" ");
			String[] newElementW = w.weightsLabel.getText().split(" ");
			values[i] = Integer.parseInt(newElementV[i]);
			weights[i] = Integer.parseInt(newElementW[i]);
		}
		return this.knapsackRecursive(values, weights, maxWeight, 0) + "";
	}

	public int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;
		
		//System.out.println(Arrays.toString(profits) + " , " + Arrays.toString(weights) + " , " + currentIndex);

		// recursive call after choosing the element at the currentIndex
		// if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
		int profit1 = 0;
		if(weights[currentIndex] <= capacity) {
			profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
		}
		// recursive call after excluding the element at the currentIndex
		int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
		return Math.max(profit1, profit2);
	}
	
	public String dynamicProgrammingSol() {
		startTime = System.nanoTime();

		maxWeight = Integer.parseInt(w.maxWeightLabel.getText());
		numItems = Integer.parseInt(w.numItemsLabel.getText());

		int[] values = new int[numItems];
		int[] weights = new int[numItems];
		for(int i=0; i<numItems; i++) {
			String[] newElementV = w.valuesLabel.getText().split(" ");
			String[] newElementW = w.weightsLabel.getText().split(" ");
			values[i] = Integer.parseInt(newElementV[i]);
			weights[i] = Integer.parseInt(newElementW[i]);
		}

		int[][] M = new int[numItems + 1][maxWeight + 1];

		//Dynamic Programming Knapsack Implementation (Modified): https://www.baeldung.com/java-knapsack
		for(int i=1; i<numItems + 1; i++) {
			for(int j=1; j<maxWeight + 1; j++) {
				if(weights[i-1] > j) {
					M[i][j] = M[i-1][j];
				}
				else {
					if(M[i-1][j] > M[i-1][j-weights[i-1]] + values[i-1]) {
						M[i][j] = M[i-1][j];
					}
					else {
						M[i][j] = M[i-1][j-weights[i-1]] + values[i-1];
					}
				}
			}
		}
		endTime = System.nanoTime();

		return M[numItems][maxWeight] + "";
	}
}
