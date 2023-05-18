class Solution {
  List<Integer>[] adj;
  int[] parent;
  boolean[] seen;

  private void dfs(int node, int start) {
    parent[node] = start;

    if (seen[node]) return;
    seen[node] = true;

    for (var neighbor : adj[node])
      dfs(neighbor, start);
  }

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    var ans = new ArrayList<Integer>();

    seen = new boolean[n];
    parent = new int[n];
    adj = new ArrayList[n];

    for (var i=0; i<n; i++) 
      adj[i] = new ArrayList<>();
    
    for (var e : edges)
      adj[e.get(0)].add(e.get(1));

    for (var i=0; i<n; i++)
      if (!seen[i]) dfs(i, i);

    Arrays.fill(seen, false);

    for (var i=0; i<n; i++) {
      if (seen[parent[i]]) continue;

      int j;
      for (j = i; parent[j] != j; j = parent[j]);
    
      if (!seen[j]) ans.add(j);
      seen[parent[i]] = seen[j] = true;
    }
    return ans;
  }
}
