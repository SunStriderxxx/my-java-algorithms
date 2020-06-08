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

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    /**
     *  递归前序遍历
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("val is " + node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     *  递归中序遍历
     */
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println("val is " + node.val);
        inOrder(node.right);
    }

    /**
     *  TODO 非递归先序遍历
     */
    public void preOrderNonRecur(TreeNode node) {

    }

    /**
     *  TODO 非递归中序遍历
     */
    public void inOrderNonRecur(TreeNode node) {

    }

    /**
     *  TODO 非递归后序遍历
     */
    public void postOrderNonRecur(TreeNode node) {

    }

    /**
     *  判断二叉树是否平衡
     */
    public boolean isBalance(TreeNode node) {
        return getLevel(node) != -1;
    }

    //返回层级，若返回-1代表不平衡
    private int getLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLevel = getLevel(node.left);
        if (leftLevel == -1) {
            return -1;
        }
        int rightLevel = getLevel(node.right);
        if (rightLevel == -1) {
            return -1;
        }
        if (Math.abs(leftLevel - rightLevel) > 1) {
            return -1;
        }
        return Math.max(leftLevel, rightLevel + 1);
    }

}
