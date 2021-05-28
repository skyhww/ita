package tree;

/**
 * 首先是个二叉查找树，其次
 * 1、每个节点要么是红色，要么是黑色
 * 2、跟是黑色
 * 3、 叶子是黑色
 * 4、红节点的儿子都是黑色
 * 5、从根节点开始到任意子孙节点，所包含的黑节点数是相同的
 * 红黑树的高度总是小于 2lg(n+1)
 */
public class RedBlackTree<T> extends BTree {
    private Color color;

    public RedBlackTree(Comparable key, Color color) {
        super(key);
        color = color;
    }

    @Override
    public void insert(Comparable key) {
        RedBlackTree redBlackTree = new RedBlackTree(key, Color.Red);
        super.insert(key);
    }

    protected void fixUpInsert(RedBlackTree redBlackTree) {
        while (((RedBlackTree) redBlackTree.parent).color != Color.Black) {
            if (((RedBlackTree) redBlackTree.parent.parent).color == Color.Red) {

            }
        }

    }
}


enum Color {
    Red, Black
}