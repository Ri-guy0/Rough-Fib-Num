class EvaluateFibonacci{	
	void findTermValue (FibonacciValue value) {
		int[] currentValues= {0, 1};
		int n = value.termNum;
		int temp = 0;

		for (int i=1; i<n; i++) {
			temp = currentValues[1];
			currentValues[1] += currentValues[0];
			currentValues[0] = temp;
		}
		
		value.termValue = currentValues[0];
	}
	
	void findTermNumber (FibonacciValue value) {
		int number = value.termValue;
		int[] currentValues= {0, 1};
		int temp = 0;
		int counter = 1;
		
		while (number>currentValues[0]) {
			temp = currentValues[1];
			currentValues[1] += currentValues[0];
			currentValues[0] = temp;
			counter++;
		} 
		
		if (number==currentValues[0]) {
			value.fibonacci = true;
			if (value.termNum==3) {return;}
		}
		value.termNum = counter;
	}
	
}

public class FibonacciValue {
	int termNum;
	int termValue;
	boolean fibonacci;
	
	void insertCounter(int n) {
		termNum = n;
		termValue = -1;
		fibonacci=true;
	}	
	
	void insertNumber(int n) {
		termNum = -1;
		termValue = n;
		fibonacci=false;
	}
	
	void display() {
		if (fibonacci) {
			System.out.println("The value " + termValue + " is the " + termNum + " Fibonacci!");
		} else {
			System.out.println(termValue + " is not a Fibonacci!");
		}
	}

	public static void main(String[] args) {
		EvaluateFibonacci fibFunctions = new EvaluateFibonacci();
		
		FibonacciValue countFib = new FibonacciValue();
		FibonacciValue countHigher = new FibonacciValue();
		FibonacciValue roundTrip = new FibonacciValue();
		FibonacciValue notFib = new FibonacciValue();
		FibonacciValue lowFib = new FibonacciValue();
		FibonacciValue highFib = new FibonacciValue();
		
		countFib.insertCounter(8);
		countHigher.insertCounter(12);
		roundTrip.insertCounter(3);
		notFib.insertNumber(24);
		lowFib.insertNumber(0);
		highFib.insertNumber(144);
		
		
		fibFunctions.findTermValue(countFib);
		fibFunctions.findTermValue(countHigher);
		
		fibFunctions.findTermValue(roundTrip);
		fibFunctions.findTermNumber(roundTrip);
		
		fibFunctions.findTermNumber(notFib);
		fibFunctions.findTermNumber(lowFib);
		fibFunctions.findTermNumber(highFib);
		
		countFib.display();
		countHigher.display();
		roundTrip.display();
		notFib.display();
		lowFib.display();
		highFib.display();
	}

}
