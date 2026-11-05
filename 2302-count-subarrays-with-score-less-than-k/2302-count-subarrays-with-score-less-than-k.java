class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long subarr = 0;
        long sum = 0;
        for(int right = 0 ; right < nums.length ;right++){
            sum = sum + nums[right];
        while(sum*(right-left +1)>= k){
            sum = sum - nums[left];
                   left++;
        }
             subarr += right - left +1;
        }
       return subarr;
    }
}