import java.util.Arrays;

public class RadixSort {

    public int[] sort(int[] list) {
        int maxNumber = list[0];
        for (int i = 1; i < list.length; i++) {
            if (maxNumber < list[i]) {
                maxNumber = list[i];
            }
        }
        for (int exp = 1; 0 < maxNumber / exp; exp *= 10) {
            countSort(list, list.length, exp);
        }
        return list;
    }

    private void countSort(int[] list, int n, int exp) {
        Integer[] output = new Integer[n];
        int i;
        Integer[] count = new Integer[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(list[i]/exp)%10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; 0 <= i; i--) {
            output[count[(list[i] / exp) % 10] - 1] = list[i];
            count[(list[i]/exp)%10]--;
        }

        for (i = 0; i < n; i++) {
            list[i] = output[i];
        }
    }
}
