
class Solution {
    public long countSubarrays(int[] nums, int k) {

        int n = nums.length;

        // Find maximum element
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int count = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {

            // Include current element
            if (nums[right] == max) {
                count++;
            }

            // Shrink while maximum appears at least k times
            while (count >= k) {

                if (nums[left] == max) {
                    count--;
                }

                left++;
            }

            // Count all valid starting positions
            ans += left;
        }

        return ans;
    }
}
