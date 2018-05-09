package com.jiehang.hash;

/**
 * 平衡二叉树简单实现
 */
public class AvlTree<T extends Comparable<? super T>> {

    private AvlNode<T> root;// AVL树根  

    /**
     * 初始化为空树
     */
    public AvlTree() {
        root = null;
    }

    /**
     * 在AVL树中插入数据
     */
    public void insert(T x) {
        root = insert(x, root);
    }

    /**
     * 在AVL树中找最小的数据
     */
    public T findMin() {
        if (isEmpty())
            System.out.println("树空");
        return findMin(root).element;
    }

    /**
     * 在AVL树中找最大的数据
     */
    public T findMax() {
        if (isEmpty())
            System.out.println("树空");
        return findMax(root).element;
    }

    /**
     * 搜索，查找记录，找到返回 true 否则返回false
     */
    public boolean find(T x) {
        return find(x, root);
    }

    /**
     * 清空AVL 树
     */
    public void clear() {
        root = null;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 排序输出AVL树, 采用中序输出
     */
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    /**
     * 以根节点开始，将新节点插入到合适的位置
     */
    private AvlNode<T> insert(T x, AvlNode<T> root) {
        if (root == null)
            return new AvlNode<T>(x, null, null);

        int compareResult = x.compareTo(root.element);

        if (compareResult < 0) {
            root.left = insert(x, root.left);// 将x插入左子树中  
            if (height(root.left) - height(root.right) == 2)// 打破平衡  
                if (x.compareTo(root.left.element) < 0)// LL型（左左型）  
                    root = rotateWithLeftChild(root);
                else
                    root = doubleWithLeftChild(root);   // LR型（左右型）  
        } else if (compareResult > 0) {
            root.right = insert(x, root.right);// 将x插入右子树中  
            if (height(root.right) - height(root.left) == 2)// 打破平衡  
                if (x.compareTo(root.right.element) > 0)// RR型（右右型）  
                    root = rotateWithRightChild(root);
                else
                    // RL型  
                    root = doubleWithRightChild(root);
        } else
            ; // 重复数据，什么也不做  
        root.height = Math.max(height(root.left), height(root.right)) + 1;// 更新高度  
        return root;
    }

    /**
     * 找最小值
     */
    private AvlNode<T> findMin(AvlNode<T> n) {
        if (n == null)
            return n;
        while (n.left != null)
            n = n.left;
        return n;
    }

    /**
     * 找最大值
     */
    private AvlNode<T> findMax(AvlNode<T> n) {
        if (n == null)
            return n;
        while (n.right != null)
            n = n.right;
        return n;
    }

    /**
     * 搜索（查找）,以某个节点作为根开始查找
     */
    @SuppressWarnings("unchecked")
    private boolean find(T x, AvlNode<?> root) {
        while (root != null) {
            int compareResult = x.compareTo((T) root.element);

            if (compareResult < 0)
                root = root.left;
            else if (compareResult > 0)
                root = root.right;
            else
                return true; //找到  
        }
        return false; //未找到  
    }

    /**
     * 中序遍历AVL树
     */
    private void printTree(AvlNode<T> n) {
        if (n != null) {
            printTree(n.left);
            System.out.print(n.element + "  ");
            printTree(n.right);
        }
    }

    /**
     * 求AVL树的高度
     */
    private int height(AvlNode<T> n) {
        return n == null ? -1 : n.height;
    }

    /**
     * 带左子树旋转,适用于LL型
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> n) {
        AvlNode<T> k = n.left;
        n.left = k.right;
        k.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        k.height = Math.max(height(k.left), n.height) + 1;
        return k;
    }

    /**
     * 带右子树旋转，适用于RR型
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> n) {
        AvlNode<T> k = n.right;
        n.right = k.left;
        k.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        k.height = Math.max(height(k.right), n.height) + 1;
        return k;
    }

    /**
     * 双旋转，适用于LR型
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> n) {
        n.left = rotateWithRightChild(n.left);
        return rotateWithLeftChild(n);
    }

    /**
     * 双旋转,适用于RL型
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> n) {
        n.right = rotateWithLeftChild(n.right);
        return rotateWithRightChild(n);
    }

    public static void main(String[] args) {
        AvlTree<Integer> t = new AvlTree<Integer>();

        int[] value = {6, 1, 20, 7, 10, 8, 9, 3, 14, 5, 18};
        for (int v : value) {
            t.insert(v);
        }
        System.out.println("中序遍历： ");
        t.printTree();

        System.out.println();
        System.out.println("树的高度： " + t.height(t.root));

        System.out.println("最小值： " + t.findMin());
        System.out.println("最大值： " + t.findMax());
        System.out.println("查找“10”： " + t.find(10));
    }
}

class AvlNode<T> {

    T element; // 节点中的数据
    AvlNode<T> left; // 左孩子
    AvlNode<T> right; // 右孩子
    int height; // 节点的高度

    AvlNode(T theElement) {
        this(theElement, null, null);
    }

    AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt) {
        element = theElement;
        left = lt;
        right = rt;
        height = 0;
    }

}