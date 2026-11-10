
class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int maxlen = 0;
        int windowSum = 0;
        int totalSum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum == x) {
            return n;
        }
        if (totalSum < x) {
            return -1;
        }
        int target = totalSum - x;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum > target && left <= right) {
                windowSum -= nums[left];
                left++;
            }
            if (windowSum == target) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
        }
        if (maxlen == 0) {
            return -1;
        }
        return n- maxlen;
    }
}
