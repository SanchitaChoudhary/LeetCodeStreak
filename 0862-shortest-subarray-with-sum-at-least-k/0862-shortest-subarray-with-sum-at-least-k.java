
import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int ans = n + 1;

        for (int right = 0; right <= n; right++) {

            // Condition 1: Find valid subarray
            while (!deque.isEmpty() &&
                   prefix[right] - prefix[deque.peekFirst()] >= k) {

                ans = Math.min(ans, right - deque.pollFirst());
            }

            // Condition 2: Maintain increasing prefix sum
            while (!deque.isEmpty() &&
                   prefix[deque.peekLast()] >= prefix[right]) {

                deque.pollLast();
            }

            deque.offerLast(right);
        }

        return ans == n + 1 ? -1 : ans;
    }
}
