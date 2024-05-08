package InsertionSort;

import java.util.Arrays;
import java.util.Random;

public class Insertion {
    
     public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
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

       
         int[] myArray = new int[10000];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }
        
        
        System.out.println("Unsorted array: ");
       shuffleArray(myArray);
        // System.out.println(Arrays.toString( myArray ));
        long start = System.currentTimeMillis();
        insertionSort(myArray);
        long finish = System.currentTimeMillis();
       // System.out.println( Arrays.toString(myArray) );
        long timeElapsed = (long)(finish - start);
        double seconds = (double) timeElapsed / 1000;
        System.out.println("Time:");
        System.out.println(seconds);
 
        

    }
}
