Question Link: https://leetcode.com/problems/construct-quad-tree/



class Solution {
    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return gen(0, 0, grid.length);
    }

    Node gen(int x, int y, int len) {
        if (len == 1) return new Node(grid[x][y] == 1, true);

        Node cur = new Node(grid[x][y] == 1, true);
        len /= 2;

        Node tl = gen(x, y, len);
        Node tr = gen(x, y + len, len);
        Node bl = gen(x + len, y, len);
        Node br = gen(x + len, y + len, len);

        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && areSame(tl.val, tr.val, bl.val, br.val))
            return cur;
        cur.isLeaf = false;
        
        cur.topLeft = tl;
        cur.topRight = tr;
        cur.bottomLeft = bl;
        cur.bottomRight = br;

        return cur;
    }

    boolean areSame(boolean a, boolean b, boolean c, boolean d) {
        return a == b && b == c && c == d;
    }
}
