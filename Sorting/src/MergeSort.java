public class MergeSort {

    public Integer[] sort(Integer[] list, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return list;
        } else {
            int midIndex = (lowIndex + highIndex) / 2;
            sort(list, lowIndex, midIndex);
            sort(list, midIndex + 1, highIndex);
            merge(list, lowIndex, midIndex, highIndex);
        }
        return list;
    }

    private void merge(Integer[] list, int lowIndex, int midIndex, int highIndex) {
        int[] L = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            L[i-lowIndex] = list[i];
        }
        L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
        int[] R = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            R[i - midIndex - 1] = list[i];
        }
        R[highIndex - midIndex] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = lowIndex; k <= highIndex; k++) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            } else {
                list[k] = R[j];
                j++;
            }
        }
    }
}
