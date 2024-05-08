package QuickSort;

import java.util.Arrays;
import java.util.Random;


public class QuickSort {
    
    private static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for(int i = pivotIndex + 1; i<= endIndex; i++){
            if(array[i] < array[pivotIndex]){
                swapIndex++;
                //swap the values of two elements in an array.
                swap(array, swapIndex , i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }
    private static void quickSortHelper(int[] array, int left, int right){
        if(left < right){
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex-1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }
    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length - 1);
    }

      public static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }


     public static void main(String[] args) {

        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }

    //System.out.println("Unsorted array: ");
       shuffleArray(myArray);
       // System.out.println(Arrays.toString( myArray ));
       long start = System.currentTimeMillis();
         System.out.println("Sorted array: ");
        quickSort(myArray);
        long finish = System.currentTimeMillis();
       // System.out.println( Arrays.toString( myArray ) );

        

        long timeElapsed = (long)(finish - start);
        double seconds = (double) timeElapsed / 1000; 
        System.out.println("time");
        System.out.println(seconds);
    }


}
