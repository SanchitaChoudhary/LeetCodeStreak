class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int k1 = k - 1;
        int left = 0;
        int count = 0;
        int subarr = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0){
                count++;
            }
            while (count > k) {
                if (nums[left] % 2 != 0) {
                    count--;
                }
                left++;
            }
            subarr += right - left +1;
        }
        left = 0 ;
        count = 0;
       int subarr_2 = 0;
        for(int right = 0 ; right < nums.length ; right ++){
            if(nums[right] % 2 != 0){
                count ++;
            }
            while (count > k1){
                  if(nums[left]%2 != 0){
                    count--;
                  }
                  left++;
            }
            subarr_2 += right - left+1;
        }
        return subarr - subarr_2;
    }
}