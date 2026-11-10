
class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0 ; 
        int winlen = 0;
        int sum = 0;
        int totalsum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            totalsum += nums[i];
        }
            if(totalsum == x){
                return nums.length;
             }
             if(totalsum < x){
                return -1;
             }
        int target =  totalsum - x;
        for(int right = 0 ; right < nums.length ; right++){
             sum += nums[right];
             while(sum > target && left <= right){
                sum -= nums[left];
                left++;
             }
              if(sum == target){
                winlen = Math.max(winlen ,right-left+1);
             }
        }
         if(winlen == 0){
                return -1;
             }
        return nums.length - winlen;
    }
}
