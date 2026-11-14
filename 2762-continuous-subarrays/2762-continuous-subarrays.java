
import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing order for maximum
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain increasing order for minimum
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink while condition is invalid
            while (nums[maxDeque.peekFirst()] -
                   nums[minDeque.peekFirst()] > 2) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            // Count valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
