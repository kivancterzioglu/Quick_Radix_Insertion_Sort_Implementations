package RadixSort;


import java.util.*;
 
class Radix {
 
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[])
    {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int exp)
    {
        int output[] = new int[arr.length]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        for (i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
       
        for (i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[])
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, exp);
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
 
    // Main driver method
    public static void main(String[] args)
    {
        int[] myArray = new int[100];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }

  
      System.out.println("Unsorted array: ");
       shuffleArray(myArray);
       System.out.println(Arrays.toString( myArray ));
       long start = System.currentTimeMillis();
       // System.out.println("Sorted array: ");
        radixsort(myArray);
        long finish = System.currentTimeMillis();
       System.out.println( Arrays.toString( myArray ) );

        

        long timeElapsed = (long)(finish - start);
        double seconds = (double) timeElapsed / 1000; 
        System.out.println("time");
        System.out.println(seconds);
 
       
        
        
    }
}