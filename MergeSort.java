package ie.gmit.dip;

import java.util.*;

public class MergeSort {
	public static void main(String[] args) {
		// the user input allows the user to input as many numbers they wish
		// and adds them to the num[i]
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Size of the Array: ");
		int n = s.nextInt();
		int[] num = new int[n];
		System.out.println("Enter " + n + " numbers! ");
		for (int i = 0; i < n; i++) {
			num[i] = s.nextInt();
		}
		// the num[] it then cast to the mergeSort method where it is
		// broken down and split.
		mergeSort(num);
	}

	public static int[] mergeSort(int[] mergNum) {
		if (mergNum.length > 1) {
			int[] left = extract(mergNum, 0, mergNum.length / 2);
			int[] right = extract(mergNum, mergNum.length / 2, mergNum.length);
			System.out.println("left" + Arrays.toString(left));
			System.out.println("right" + Arrays.toString(right));
			// looping through splitting into a Left[] and a Right[] until it
			// cant be split any more.
			// sorting each element recuesively
			mergeSort(left);
			mergeSort(right);

			// each element is then merged in order through merge() method
			// each time until you get the full array back

			merge(left, right, mergNum);
			return mergNum;
		}
		return mergNum;
	}

	// extracting the arrays down into sub arrays each time returning to
	// mergSort
	// to break down further until it only has the one index...
	public static int[] extract(int[] mergNum, int start, int last) {
		int[] sub = new int[last - start];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = mergNum[start + i];
		}
		// returning a sub array of the elements in each array starting at
		// index i
		return sub;
	}

	public static void merge(int[] left, int[] right, int[] result) {
		int i = 0, j = 0, k = 0;

		// while the index at both i and j are less than the size of both left
		// and right arrays the loop will continue...
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				result[k] = left[i];
				i++;
			} else if (right[j] <= left[i]) {
				result[k] = right[j];
				j++;
			}
			k++;
		}
		// the two while loops help fill the last index of the merged[]
		// whether its from the right or the left arrays.
		while (i < left.length) {
			result[k] = left[i];
			k++;
			i++;
		}
		//while (j < right.length) {
		//	result[k] = right[j];
		//	k++;
		//	j++;
		//}
		// prints out the result[]
		System.out.println(Arrays.toString(result));
	}
}
