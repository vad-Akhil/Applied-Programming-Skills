import java.util.Arrays;
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int[] result = new int[n];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            int leftDiff = nums[i] * i - prefixSum;
            int rightDiff = totalSum - prefixSum - nums[i] * (n - i);
            result[i] = leftDiff + rightDiff;
            prefixSum += nums[i];
        }
        return result;
    }
}