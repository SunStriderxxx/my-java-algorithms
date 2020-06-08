package leetcode;

/**
 * @author Fcb
 * @date 2020/6/8
 * @description 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem990 {


    /**
     * 解题思路：并查集
     * 本人做到这道题的时候也是第一次了解并查集这个概念。
     * 大致思路就是所有的节点都有一个根节点，根节点相同的节点代表其联通，可以解决一些比较相等，能否到达等问题。
     */
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        //将所有相等的连接
        for (String str : equations) {
            if ('=' == str.charAt(1)) {
                unionFind.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        //判断如果有!=的equation两边的字符连接了，则返回false
        for (String str : equations) {
            if ('!' == str.charAt(1) && unionFind.isConnected(str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    public class UnionFind {
        private int[] parent;

        public int find(int x) {
            //查找x的根节点，路径压缩，减少查询时的时间复杂度
            //根节点总是指向自己，如果没有指向自己，则说明不是根节点
            while (parent[x] != parent[parent[x]]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public UnionFind(int x) {
            //构造大小为x的并查集
            parent = new int[x];
            //所有的节点都指向自己
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }
    }

}
