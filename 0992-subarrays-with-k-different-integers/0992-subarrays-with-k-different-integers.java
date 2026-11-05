class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
        public int helper(int [] nums , int k){
        int left = 0 ;
        int subarr = 0;
        HashMap < Integer , Integer> map = new HashMap<>();
          for( int right = 0 ; right < nums.length ; right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num,0)+1);
            while(map.size()>k){
                int leftnum = nums[left];
                map.put(leftnum , map.get(leftnum)-1);
                if(map.get(leftnum)==0){
                    map.remove(leftnum);
                }
                left++;
            }
             subarr += right - left+1; 
          }
          return subarr;
        }
    }
