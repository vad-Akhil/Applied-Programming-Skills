class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // keep window size <= k
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            // if number already in window, we found pair with distance <= k
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}