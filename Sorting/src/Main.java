import java.util.Random;

// https://visualgo.net/bn/sorting

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        double divider = 1000;
        long start, finish, elapsed;

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        RandomQuickSort randomQuickSort = new RandomQuickSort();
        CountingSort countingSort = new CountingSort();
        RadixSort radixSort = new RadixSort();

        int size = 10;
        System.out.println("Size: " + size);
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(size + 1);
        }
        array = randomizeArray(array);

        //Bubble sort
        start = System.currentTimeMillis();
        bubbleSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Bubble sort elapsed time: "+ elapsed/divider);
        printArray(array);
        array = randomizeArray(array);

        //Selection sort
        start = System.currentTimeMillis();
        selectionSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Selection sort elapsed time: "+ elapsed/divider);
        printArray(array);
        array = randomizeArray(array);

        //Insertion sort
        start = System.currentTimeMillis();
        insertionSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Insertion sort elapsed time: "+ elapsed/divider);
        printArray(array);
        array = randomizeArray(array);

        //Merge sort
        start = System.currentTimeMillis();
        mergeSort.sort(array, 0, array.length-1);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Merge sort elapsed time: "+ elapsed/divider);
        printArray(array);
        array = randomizeArray(array);

        //Random quick sort
        start = System.currentTimeMillis();
        randomQuickSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Random quick sort elapsed time: "+ elapsed/divider);
        printArray(array);
        array = randomizeArray(array);

        //Counting sort
        start = System.currentTimeMillis();
        array = countingSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Counting sort elapsed time: " + elapsed/divider);
        printArray(array);
        array = randomizeArray(array);

        //Radix sort
        start = System.currentTimeMillis();
        radixSort.sort(array);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Radix sort elapsed time: " + elapsed/divider);
        printArray(array);
        array = randomizeArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(int[] array, String message) {
        System.out.println(message);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] randomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator
        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        System.out.print("\nShuffled: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        return array;
    }
}
