
class Solution {
    public long countSubarrays(int[] nums, int k) {
        long n = nums.length;
        long a = n*(n+1)/2;
        return a - helper(nums, k-1);
    }

    public long helper(int[] nums, int k) {
        int left = 0;
        long count = 0;
        long subarr = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (count > k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            subarr += right - left + 1;
        }
        return subarr;
    }
}
