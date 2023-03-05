Question Link: https://leetcode.com/problems/jump-game-iv/



class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return steps;
                }
                List<Integer> neighbors = graph.get(arr[curr]);
                neighbors.add(curr - 1);
                neighbors.add(curr + 1);
                for (int neighbor : neighbors) {
                    if (neighbor >= 0 && neighbor < n && !visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
                neighbors.clear(); // avoid unnecessary calculation
            }
            steps++;
        }
        return -1;
    }
}
