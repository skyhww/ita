package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历，左->中->右
 * 迭代算法实现
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        //root：待标记节点
        while (root != null || !nodeStack.isEmpty()) {
            if (root == null) {
                TreeNode r = nodeStack.pop();
                integerList.add(r.val);
                root = r.right;
                continue;
            }

            if (root.left == null) {
                integerList.add(root.val);
                root = root.right;
            } else {
                nodeStack.push(root);
                root = root.left;
            }
        }
        return integerList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.left.right=new TreeNode(2);
        new InorderTraversal().inorderTraversal(treeNode);
    }
}

