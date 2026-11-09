
import java.util.*;

class Solution {
    public int minimumRounds(int[] tasks) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int rounds = 0;

        // Step 2: Calculate minimum rounds
        for (int count : map.values()) {

            if (count == 1) {
                return -1;
            }

            rounds += (count + 2) / 3;
        }

        return rounds;
    }
}
