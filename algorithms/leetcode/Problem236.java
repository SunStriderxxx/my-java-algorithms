package leetcode;

import java.util.PriorityQueue;

/**
 * @author Fcb
 * @date 2020/5/31
 * @description 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem236 {

    /**
     * 解题思路：递归
     * 首先确定判定条件：当p在当前节点的左子节点，q在当前节点的右子节点时，当前节点即为最近公共祖先
     * 再确定终止条件：当当前节点为null，或者当前节点为p，当前节点为q时，递归终止返回该节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //假如没返回，找左子树的最近公共祖先
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        //假如没返回，找右子树的最近公共祖先
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        //左子树有一个节点，右子树有一个节点，说明当前节点就是最近公共祖先
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode != null) {
            return leftNode;
        }
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }


    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
