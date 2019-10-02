import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double divider = 1000;
        long start, finish, elapsed;
        Random random = new Random();

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        RandomQuickSort randomQuickSort = new RandomQuickSort();
        CountingSort countingSort = new CountingSort();
        RadixSort radixSort = new RadixSort();

        int size = 50000000;
        System.out.println("Size: " + size);
        Integer[] array = new Integer[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(size + 1);
        }

        //Bubble sort
//        start = System.currentTimeMillis();
//        array = bubbleSort.sort(array);
//        finish = System.currentTimeMillis();
//        elapsed = finish - start;
//        System.out.println("Bubble sort elapsed time: "+ elapsed/divider);
//        Collections.shuffle(Arrays.asList(array));

        //Selection sort
//        start = System.currentTimeMillis();
//        array = selectionSort.sort(array);
//        finish = System.currentTimeMillis();
//        elapsed = finish - start;
//        System.out.println("Selection sort elapsed time: "+ elapsed/divider);
//        Collections.shuffle(Arrays.asList(array));

        //Insertion sort
//        start = System.currentTimeMillis();
//        array = insertionSort.sort(array);
//        finish = System.currentTimeMillis();
//        elapsed = finish - start;
//        System.out.println("Insertion sort elapsed time: "+ elapsed/divider);
//        Collections.shuffle(Arrays.asList(array));

        //Merge sort
        start = System.currentTimeMillis();
        array = mergeSort.sort(array, 0, array.length-1);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Merge sort elapsed time: "+ elapsed/divider);
        Collections.shuffle(Arrays.asList(array));

        //Random quick sort
        start = System.currentTimeMillis();
        array = randomQuickSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Random quick sort elapsed time: "+ elapsed/divider);
        Collections.shuffle(Arrays.asList(array));

        //printArray(array,"before countingsort");
        //Counting sort
        start = System.currentTimeMillis();
        array = countingSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Counting sort elapsed time: " + elapsed/divider);
        //printArray(array,"after countingsort");
        Collections.shuffle(Arrays.asList(array));

        //printArray(array,"before radix sort");
        //Radix sort
        start = System.currentTimeMillis();
        array = radixSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Radix sort elapsed time: " + elapsed/divider);
        //printArray(array, "after radix sort");
        Collections.shuffle(Arrays.asList(array));
    }

    public static void printArray(Integer[] array, String message) {
        System.out.println(message);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
