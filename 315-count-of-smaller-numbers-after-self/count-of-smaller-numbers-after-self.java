class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];             // Array to store the count of smaller numbers after self
        int[] indices = new int[nums.length];           // This array stores the indices of the numbers to track original positions
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        mergeSort(nums, 0, nums.length - 1, count, indices);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(count[i]);
        }
        return list;
    }

    // Standard Merge Sort function recursively breaking the array
    public static void mergeSort(int arr[], int start, int end, int count[], int indices[]) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            mergeSort(arr, start, mid, count, indices);
            mergeSort(arr, mid + 1, end, count, indices);

            merge(arr, start, mid, end, count, indices);
        }
    }

    // Modified Merge function to count smaller numbers
    public static void merge(int arr[], int start, int mid, int end, int[] count, int[] indices) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        int rightCounter = 0;   // Counter that stores the no. of elements smaller than me in rightSide

        while (i <= mid && j <= end) {
            // Compare values using the original indices
            if (arr[indices[i]] <= arr[indices[j]]) {
                // If left side is smaller/equal, it means all 'rightCounter' elements 
                // processed so far from the right side are smaller than this element.
                count[indices[i]] += rightCounter;
                temp[k++] = indices[i++];
            } else {
                // If right side is smaller, increment the counter
                temp[k++] = indices[j++];
                rightCounter++;
            }
        }

        // If left part still has values, add the accumulated rightCounter to them
        while (i <= mid) {
            count[indices[i]] += rightCounter;
            temp[k++] = indices[i++];
        }

        // If right part still has values, just copy them
        while (j <= end) {
            temp[k++] = indices[j++];
        }

        // Copy sorted indices back to the original indices array
        for (k = 0; k < temp.length; k++) {
            indices[start + k] = temp[k];
        }
    }
}