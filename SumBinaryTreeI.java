public class SumBinaryTreeI {
    /*
     * 给定一颗二叉树,其中每个节点都含有一个数值.
     * 设计一个算法,打印数值总和等于某个给定值的所有路径.
     * 路径不一定非得从二叉树的根节点或叶节点开始或结束!
     *
     * 下面所示算法时间复杂度O(n*log(n)), 空间复杂度O(log(n))
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
        findSum(node, sum, path, 0);
    }

    public static void findSum(Node node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }
        // 将当前结点插入路径
        path[level] = node.val;

        // 查找以此结点为终点,总和为sum的路径
        int t = 0;
        for(int i = level; i >= 0; i--) {
            t += path[i];
            if(t == sum) {
                print(path, i, level);
            }
        }

        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

        path[level] = Integer.MIN_VALUE;
    }
}

class Node {
    int val;
    Node left, right;
    public Node(int val) {
        this.val = val;
    }
}