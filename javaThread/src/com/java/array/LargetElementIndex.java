package com.java.array;

public class LargetElementIndex {
	public static final int arr[] = new int[] { 10, 10, 10, 10, 10 };

	public static void main(String[] args) {
		System.out.println("Application started");
		int indexMax = largtest();
		System.out.println(indexMax);

		secomdLargest();
	}

	private static void secomdLargest() {
		int largest = -1;
		int sencondlargest = -1;
		int temp=-1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest) {
				temp=largest;
				largest = arr[i];
				if(temp>sencondlargest) {
					sencondlargest=temp;
				}

			} else if (arr[i] > sencondlargest&&largest!=arr[i]) {
				sencondlargest = arr[i];
			}
			
		}
		System.out.println("Second largest: " + sencondlargest);
		System.out.println(" largest: " + largest);
	}

	private static int largtest() {
		int indexMax = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[indexMax]) {
				indexMax = i;
			}
		}
		return indexMax;
	}
}
