import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Coded by Breno

public class Main {
    public static void main(String[] args) {
        FastReader inputReader = new FastReader();
        StringBuilder sb = new StringBuilder();

        int itemCount = inputReader.nextInt();
        int queryCount = inputReader.nextInt();

        int[] itemPrices = new int[itemCount];
        for (int i = 0; i < itemCount; i++) {
            itemPrices[i] = inputReader.nextInt();
        }

        mergeSort(itemPrices, 0, itemCount - 1);

        long[] prefixSum = new long[itemCount + 1];
        for (int index = 1; index <= itemCount; index++) {
            prefixSum[index] = prefixSum[index - 1] + itemPrices[index - 1];
        }

        for (int index = 0; index < queryCount; index++) {
            long requiredItemCount = inputReader.nextLong();
            long freeItemCount = inputReader.nextLong();

            long totalValue = prefixSum[itemCount - (int) requiredItemCount + (int) freeItemCount]
                    - prefixSum[itemCount - (int) requiredItemCount];

            sb.append(totalValue).append("\n");
        }

        System.out.print(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; ++i) {
            leftArray[i] = arr[low + i];
        }

        for (int j = 0; j < rightSize; ++j) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
