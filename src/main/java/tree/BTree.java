package tree;

public class BTree<T extends Comparable> {
    protected BTree left;
    protected BTree right;
    protected T key;
    protected BTree parent;

    public BTree() {
    }

    public BTree(T key) {
        this.key = key;
    }

    /**
     * 大于x.key的最小值
     *
     * @param x
     * @return
     */
    protected BTree getSuccessor(BTree x) {
        if (x.right != null) {
            return min(x.right);
        }
        BTree p = x.parent;
        while (p != null && p.right == x) {
            x = p;
            p = p.parent;
        }
        return p;
    }

    public void delete(BTree t) {
        BTree x;
        if (t.left != null && t.right != null) {
            x = getSuccessor(t);
        } else {
            x = t;
        }

        //删节点x
        BTree z = null;
        if (x.left != null) {
            z = x.left;
        } else if (x.right != null) {
            z = x.right;
        }
        if (z != null) {
            z.parent = x.parent;
            x.parent = null;
        }
        if (z.parent == null) {
            //
        } else if (z.parent.right == x) {
            z.parent.right = z;
        } else {
            z.parent.left = z;
        }


    }
    @SuppressWarnings("unchecked")
    public void insert(T key) {
        BTree tmp = new BTree(key);
        BTree tag = this;
        BTree p = null;
        while (tag != null) {
            p = tag;
            tag = tag.key.compareTo(tmp) > 0 ? tag.left : tag.right;
        }
        tmp.parent = p;
        if (p.key.compareTo(tmp) > 0) {
            p.left = tmp;
        } else {
            p.right = tmp;
        }

    }

    /**
     * 比x小的最大值，1、如果有左孩子，则去找左孩子的max 2、如果是个左孩子，直接父节点的左子树的max 3、如果是个右孩子，直接父节点
     *
     * @param x
     * @return
     */
    protected BTree getPredecessor(BTree x) {
        if (x.left != null) {
            return max(x.left);
        }
        BTree p = x.parent;
        while (p != null && p.left == x) {
            x = p;
            p = p.parent;
        }
        return p;
    }

    private BTree min(BTree root) {
        BTree p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    private BTree max(BTree root) {
        BTree p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}
