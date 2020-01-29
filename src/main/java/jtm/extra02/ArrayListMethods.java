package jtm.extra02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListMethods {
	List<Integer> myList = new ArrayList<Integer>();

	public List<Integer> checkArray(int comparator, int... numbers) {
		// TODO #1:Implement method that compares values of passed array with
		// passed comparator.
		// Return list with values that are smaller than comparator.
		// Hint: Investigate how varargs are used.
		Collections.sort(myList);
		
			return myList;
		}



	public int sumResult() {
		int sum = 0;
		// TODO #2: Count element sum of the list
		int i;
		for (i = 0; i < myList.size(); i++) ;
		sum = sum + myList.get(i);
		return sum;
	}
}
