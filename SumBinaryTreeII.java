public class SumBinaryTreeII {
    /* 输入一颗二叉树和一个整数
     * 打印出二叉树中结点值和位输入整数的所有路径
     * 从树的根结点开始往下一直到叶节点所经过的结点形成一条路径
     *
     * 以下算法的时间复杂度 O(n*log(n)) 空间复杂度O(log(n))
     */
    public static void main(String[] args) {
        /*        1
         *     /    \
         *    3      4
         *   / \    / \
         *  2  -1  1   2
         *    /
         *   3
         */
        Node head = new Node(1);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.right = new Node(-1);
        head.left.right.left = new Node(3);
        head.right = new Node(4);
        head.right.left = new Node(1);
        head.right.right = new Node(2);
        findSum(head, 6);
    }

    public static int depth(Node node){
        if(node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    public static void print(int[] path, int start, int end) {
        for(int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void findSum(Node node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0, 0);
    }

    public static void findSum(Node node, int sum, int[] path, int level, int currentSum){
        if(node == null) {
            return;
        }
        currentSum += node.val;
        path[level] = node.val;
        if (node.left == null && node.right == null) {
            if(sum == currentSum) {
                print(path, 0, level);
            }
            return;
        } else {
            if (node.left != null) {
                findSum(node.left, sum, path, level+1, currentSum);
            }
            if (node.right != null) {
                findSum(node.right, sum, path, level+1, currentSum);
            }

        }
    }

}