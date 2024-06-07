package com.java.array;

public class sortedRotated {
	public static final int arr[] = new int[] { 2, 2, 3, 4, 5 };

	public static void main(String[] args) {
		boolean istrue = isSortedRotated();
		System.out.println(istrue);
	}

	private static boolean isSortedRotated() {
		return increasing() || decreasing();

	}

	private static boolean decreasing() {
		int index = 1;
		while (arr[index] <= arr[index - 1]) {
			index++;
		}
		if (index == arr.length - 1) {
			return false;
		} else {
			int j = 0;
			if (arr[j] > arr[index]) {
				while (arr[index] >= arr[index + 1] && index < arr.length - 2) {
					j++;
				}
				if (index + 1 == arr.length - 1) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	private static boolean increasing() {
		int i = 1;
		while (arr[i] >= arr[i - 1] && i < arr.length - 1) {
			i++;
		}
		if (i == arr.length - 1) {
			return false;
		} else {
			int j = 0;
			if (arr[j] > arr[i]) {
				while (arr[i] <= arr[i + 1] && i < arr.length - 2) {
					j++;
				}
				if (i + 1 == arr.length - 1) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;

	}
}
