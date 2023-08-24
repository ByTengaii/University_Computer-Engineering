import java.util.Random;
import java.util.Arrays;

public class ComparingSortingAlgorithms {

	public static void selectionSort(int[] arr){
		for(int i = 0 ; i < arr.length-1;i++){
			int minIndex = i;
			for(int j = i+1 ; j < arr.length; j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static void bubbleSort(int[] arr){
		for(int i = 0; i < arr.length ; i++){
			for (int j=0; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
//MERGE SORT*******************************************************
	public static void mergeSort(int [] arr,int left,int right){
		if(left < right){
			int mid =(left+right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}

	public static void merge(int arr[], int left, int mid, int right){
		int[] temp = new  int[right-left+1];
		int i = left , j = mid+1, k= 0;
		while(i <= mid && j<= right){
			if(arr[i] <= arr[j]){
				temp[k] = arr[i];
				i++;
			} else{
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		//remain elements of left side
		while(i <= mid){
			temp[k] = arr[i];
			i++;
			k++;
		}

		// remain elements of right side
		while(j <= right){
			temp[k] = arr[j];
			j++;
			k++;
		}
		
		for(int m = 0; m < temp.length; m++){
			arr[left+m] = temp[m];
		}
	}
//QUICK SORT*****************************************************
	public static void quickSort(int[] arr, int left, int right){
		if(left < right){
			int pivotIndex = partition(arr,left,right);
			quickSort(arr,left,pivotIndex-1);
			quickSort(arr,pivotIndex+1,right);
		}
	}

	public static int partition(int[] arr, int left, int right){
		int pivotValue = arr[right];
		int i = left-1;
		for( int j = left ; j < right; j++){
			if(arr[j] < pivotValue){
				i++;
				int temp = arr[i];
				arr[i]= arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;
		return i+1;
	}

//****************************************************************

	public static void countingSort(int[] arr){
		int maxValue=1000000;
		int[] counts = new int [maxValue+1];
		for(int i =0 ; i < arr.length; i++){
			counts[arr[i]]++;
		}
		int index = 0;
		for(int i = 0; i < counts.length;i++){
			while(counts[i] > 0){
				arr[index] = i;
				index++;
				counts[i]--;
			}
		}
	}

	private static int[] generateRandomArray(int size){
		int [] arr = new int[size];
		Random random = new Random();
		for(int i = 0 ; i < size ; i++){
			arr[i] = random.nextInt(1000001);
		}
		return arr;
	}

	public static void main(String[] args){
		int [][] arrays = new int[4][];
		arrays[0] = generateRandomArray(1000);
		arrays[1] = generateRandomArray(10000);
		arrays[2] = generateRandomArray(50000);
		arrays[3] = generateRandomArray(100000);
		
		String[] algorithmNames = {"Selection Sort", "Bubble Sort", "Merge Sort","Quick Sort","Counting Sort"};

		for(int i=0; i < algorithmNames.length ; i++ ){
			System.out.println("Timing " + algorithmNames[i] + "...");
			for(int j = 0 ; j < arrays.length; j++ ){
				int [] arr = arrays[j].clone();
				long startTime = System.currentTimeMillis();
				switch(i){
					case 0 :
						selectionSort(arr);
						break;
					case 1 : 
						bubbleSort(arr);
						break;
					case 2 :
						mergeSort(arr,0,arr.length-1);
						break;
					case 3 :
						quickSort(arr,0,arr.length-1);
						break;
					case 4:
						countingSort(arr);
						break;
					default:
						System.out.println("ERROR:The algorithm is not finding!");
						break;
				}
				long endTime = System.currentTimeMillis();
				long elapsedTime =endTime - startTime;
				System.out.println("Size "+arrays[j].length+": "+elapsedTime+" ms");
			}
		System.out.println();
		}
	}
}
