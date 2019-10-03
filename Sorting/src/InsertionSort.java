public class InsertionSort {

    public int[] sort(int[] list) {
        int i, j, k, temp;

        for (i = 1; i < list.length; i++) {
            k = list[i];
            j = i - 1;
            while (j >= 0 && k < list[j]) {
                temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                j--;
            }
        }
        return list;
    }
}
