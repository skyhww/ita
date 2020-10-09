package leetcode;


public class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {


        return 0;
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (v == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstCurrent = l1;
        ListNode secondCurrent = l2;
        if (firstCurrent == null) {
            return null;
        }
        ListNode root = new ListNode(0);
        ListNode p = root;
        for (ListNode h = l1.next; h != null; ) {
            p.next = new ListNode(0);
            h = l1.next;
            p = p.next;
        }

        for (ListNode q = root, t = q; firstCurrent != null || secondCurrent != null; ) {
            if (q == null) {
                t.next = new ListNode(0);
                q = t.next;
            }
            int i = q.val;
            if (firstCurrent != null) {
                i += firstCurrent.val;
                firstCurrent = firstCurrent.next;
            }
            if (secondCurrent != null) {
                i += secondCurrent.val;
                secondCurrent = secondCurrent.next;
            }
            if (i >= 10) {
                i = i - 10;
                if (q.next == null) {
                    q.next = new ListNode(0);
                }
                q.next.val += 1;
            }
            q.val = i;
            t = q;
            q = q.next;
        }
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}