Question Link: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/



class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(-connections[i][0]);
        }
        boolean vis[]=new boolean[n];
        int cnt=0;
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        vis[0]=true;
        while(!qu.isEmpty()){
            int curr=qu.poll();
            for(int it:adj.get(Math.abs(curr))){
                if(!vis[Math.abs(it)]){
                    qu.add(it);
                    vis[Math.abs(it)]=true;
                    if(it>0)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
