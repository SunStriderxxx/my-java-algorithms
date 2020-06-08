package BasicKnowledge;

/**
 * @author Fcb
 * @date 2020/6/4
 * @description 二叉树的基础知识
 * 二叉树的前序、中序、后序遍历：包括递归和非递归
 *
 * 二叉树解题多考虑用递归，因为确实很好用，递归能遍历一个节点三次：当前节点，去其左子节点并返回，去其右子节点并返回。
 */
public class BinayTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    /**
     * TODO 递归前序遍历
     */
    public void preOrder(TreeNode node) {

    }

    /**
     * TODO 递归中序遍历
     */
    public void inOrder(TreeNode node) {

    }

    /**
     * TODO 递归后序遍历
     */
    public void postOrder(TreeNode node) {

    }

    /**
     * TODO 判断二叉树是否平衡
     */
    public boolean isBalance(TreeNode node) {
        return true;
    }

}
