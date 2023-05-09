class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length - 1, n = matrix[0].length;
    int x = 0, y = 0;
    var list = new ArrayList<Integer>();

    while (true) {
      if (n == 0) break;
      for (var i=0; i<n; i++, y++) list.add(matrix[x][y]);
      x++; y--; n--;

      if (m == 0) break;
      for (var i=0; i<m; i++, x++) list.add(matrix[x][y]);
      y--; x--; m--;

      if (n == 0) break;
      for (var i=0; i<n; i++, y--) list.add(matrix[x][y]);
      x--; y++; n--;

      if (m == 0) break;
      for(var i=0; i<m; i++, x--) list.add(matrix[x][y]);
      y++; x++; m--;
    }
    return list;
  }
}
