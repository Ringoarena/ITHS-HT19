public class CountingSort {

    public int[] sort(int[] list) {
        int k, maxNumber = list[0];

        for (int i = 1; i < list.length; i++) {
            if (maxNumber < list[i]) {
                maxNumber = list[i];
            }
        }
        k = maxNumber +1;
        return sort(list, k);
    }

    public int[] sort(int[] list, int k) {
        int n = list.length;
        int[] sortedOutput = new int[n];
        int[] counts = new int[k];

        for (int i = 0; i < k; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            counts[list[i]]++;
        }
        for (int i = 1; i < k; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            sortedOutput[counts[list[i]] - 1] = list[i];
            counts[list[i]]--;
        }
        return sortedOutput;
    }
}
