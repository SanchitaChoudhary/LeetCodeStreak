
import java.util.*;

class Solution {
    public int minimumRounds(int[] tasks) {
        int round = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int ele = tasks[i];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
            for (int freq : map.values()) {
                if (freq == 1) {
                    return -1;
                }
                round += (freq + 2) / 3;
            }
        return round;
    }
}
