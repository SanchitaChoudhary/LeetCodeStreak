
class Solution {
    public int findJudge(int n, int[][] trust) {

        if(trust.length == 0 && n == 1) return n;

        int[] in_Deg = new int[n + 1];
        int[] out_Deg = new int[n + 1];

        for(int i = 0; i < trust.length; i++) {

            int u = trust[i][0];
            int v = trust[i][1];

            in_Deg[v]++;
            out_Deg[u]++;
        }

        for(int i = 0; i <= n; i++) {

            if(in_Deg[i] == n - 1 && out_Deg[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
