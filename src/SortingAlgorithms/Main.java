package SortingAlgorithms;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[]testArray = new int[10000];
        for(int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt(100);
        }
        int[]testArray2 = Arrays.copyOf(testArray, testArray.length);
        int[]testArray3 = Arrays.copyOf(testArray, testArray.length);
        int[]testArray4 = Arrays.copyOf(testArray, testArray.length);
        int[]testArray5 = Arrays.copyOf(testArray, testArray.length);
        int[]testArray6 = Arrays.copyOf(testArray, testArray.length);
        int[]testArray7 = Arrays.copyOf(testArray, testArray.length);
        //int[]testArray6 = {9,8,1,6,5,2};

        //BUBBLE SORT
        System.out.println("BUBBLE SORT");
        //Main.printArray(testArray);
        long start = System.currentTimeMillis();
        BubbleSort.sort(testArray);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start) + " milisekund");
        //Main.printArray(testArray);
        //SELECT SORT
        System.out.println("\nSELECT SORT");
        //Main.printArray(testArray2);
        long start2 = System.currentTimeMillis();
        SelectSort.sort(testArray2);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start2) + " milisekund");
        //Main.printArray(testArray2);
        //INSERTION SORT
        System.out.println("\nINSERTION SORT");
        //Main.printArray(testArray3);
        long start3 = System.currentTimeMillis();
        InsertionSort.sort(testArray3);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start3) + " milisekund");
        //Main.printArray(testArray3);
        //MERGE SORT
        System.out.println("\nMERGE SORT");
        //Main.printArray(testArray4);
        long start4 = System.currentTimeMillis();
        MergeSort.sort(testArray4);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start4) + " milisekund");
        //Main.printArray(testArray4);
        //HEAP SORT
        System.out.println("\nHEAP SORT");
        //Main.printArray(testArray5);
        long start5 = System.currentTimeMillis();
        HeapSort.sort(testArray5);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start5) + " milisekund");
        //Main.printArray(testArray5);
        //QUICK SORT
        System.out.println("\nQUICK SORT");
        //Main.printArray(testArray6);
        long start6 = System.currentTimeMillis();
        QuickSort.sort(testArray6);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start6) + " milisekund");
        //Main.printArray(testArray6);
        //SHELL SORT
        System.out.println("\nSHELL SORT");
        //Main.printArray(testArray7);
        long start7 = System.currentTimeMillis();
        //ShellSort.sort(testArray7, ShellSort::shellDistance);
        ShellSort.sort(testArray7, ShellSort::sedgewickDistance);
        System.out.println("Czas sortowania: " + (System.currentTimeMillis() - start7) + " milisekund");
        //Main.printArray(testArray7);

    }
    private static void printArray(int[]arr) {
        for(int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
