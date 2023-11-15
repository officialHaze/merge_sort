import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	public static void main(String[] args) {
		int maxArrSize = 100_000;
		int randomMaxVal = 1000000;
		
		int[] arr= new int[maxArrSize];
		Random rand = new Random();
		
		long startTime, endTime;
		
		// Assign random values to array
		print("Assigning random integers to array....");
		for(int i=0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(randomMaxVal);
		}
		print("Assignment complete!");
		
//		print("Unsorted Array: ");
//		print(Arrays.toString(arr)+"\n");
		
		print("Starting the sort process....");
		
		startTime = System.currentTimeMillis();
		mergeSort(arr);
		endTime = System.currentTimeMillis();
		
//		print("Sorted Array: ");
//		print(Arrays.toString(arr)+"\n");
		
		print("Sorting complete !");
		
		// Print the program execution time
		String execTimeInSec = Integer.toString(executionTimeInSec(startTime, endTime));
		print("Program executed in: " + execTimeInSec + " secs");
	}
	
	private static void mergeSort(int arr[])
	{
		int arrSize = arr.length;
		
		if(arrSize < 2) return;
		
		int mid = arrSize / 2;
		
		// Left subarray
		int leftSubArr[] = new int[mid];
		// Right subarray
		int rightSubArr[] = new int[arrSize - mid];
		
		// Fill the left subarray
		for(int i=0; i < mid; i++)
		{
			leftSubArr[i] = arr[i];
		}
		// Fill the right subarray
		for(int i=mid; i < arrSize; i++)
		{
			rightSubArr[i - mid] = arr[i];
		}
		
		mergeSort(leftSubArr);
		mergeSort(rightSubArr);
		
		// merge
//		System.out.println("Merging.....");
		merge(arr, leftSubArr, rightSubArr);
	}

	private static void merge(int arr[], int leftSubarr[], int rightSubarr[])
	{
//		System.out.println("Main array: "+Arrays.toString(arr));
//		System.out.println("Left Subarray: "+Arrays.toString(leftSubarr));
//		System.out.println("Right Subarray: "+Arrays.toString(rightSubarr));
		
		int leftSubarrLength = leftSubarr.length;
		int rightSubarrLength = rightSubarr.length;
		
		int i = 0; // left subarr iterator
		int j = 0; // right subarr iterator
		int k = 0; // main arr iterator
		
		// Merge the left and right subarrs
		while(i < leftSubarrLength && j < rightSubarrLength)
		{
			if(leftSubarr[i] <= rightSubarr[j])
			{
				arr[k] = leftSubarr[i];
				i++;
			}
			else
			{
				arr[k] = rightSubarr[j];
				j++;
			}
			k++;
		}
		
		// clean up
		while(i < leftSubarrLength)
		{
			arr[k] = leftSubarr[i];
			i++;
			k++;
		}
		
		while(j < rightSubarrLength)
		{
			arr[k] = rightSubarr[j];
			j++;
			k++;
		}
		
//		System.out.println("\n Sorted Subarray: "+Arrays.toString(arr) + "\n");
	}
	
	private static int  executionTimeInSec(long startTime, long endTime)
	{
		int execTime = (int) (endTime - startTime) / 1000;
		return execTime;
	}
	
	private static void print(String value)
	{
		System.out.println(value);
	}
}
