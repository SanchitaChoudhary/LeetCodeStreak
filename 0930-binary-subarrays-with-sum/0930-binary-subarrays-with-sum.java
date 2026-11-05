class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal == 0){
             return helper(nums,goal);
        }
        return helper(nums,goal) - helper(nums,goal-1);
    }
     public int helper(int [] nums , int goal){
        int left = 0;
        int sum = 0;
        int subarr = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum = sum - nums[left];
                left++;
            }
            subarr += right - left + 1;
        }
        return subarr;
        }
    }
