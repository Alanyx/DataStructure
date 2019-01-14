package tree_structure;

/**
 * 二叉查找树
 *
 * @author yinxing
 * @date 2019/1/10
 */

public class BSTree<T extends Comparable<T>> {

    /**
     * 根节点
     */
    private BSTNode<T> mRoot;

    public class BSTNode<T extends Comparable<T>> {
        /**
         * 关键字（键值）
         */
        T key;
        /**
         * 左孩子
         */
        BSTNode<T> left;
        /**
         * 右孩子
         */
        BSTNode<T> right;
        /**
         * 父结点
         */
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public BSTree() {
        mRoot = null;
    }

    //==================================================================================

    /**
     * 前序遍历"二叉树"
     *
     * @param tree
     */
    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.print(" " + tree.key);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 中序遍历"二叉树"
     *
     * @param tree
     */
    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(" " + tree.key);
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 后序遍历"二叉树"
     *
     * @param tree
     */
    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(" " + tree.key);
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }
    //==================================================================================

    /**
     * 递归实现：查找二叉树中键值为key的节点
     *
     * @param x
     * @param key
     * @return
     */
    private BSTNode<T> recursiveSearch(BSTNode<T> x, T key) {
        //树为空
        if (x == null) {
            return x;
        }

        //树不为空
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return recursiveSearch(x.left, key);
        } else if (cmp > 0) {
            return recursiveSearch(x.right, key);
        } else {
            return x;
        }
    }

    public BSTNode<T> recursiveSearch(T key) {
        return recursiveSearch(mRoot, key);
    }

    /**
     * 非递归实现：查找二叉树中键值为key的节点
     *
     * @param x
     * @param key
     * @return
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }

        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }
    //==================================================================================

    /**
     * 查找最小结点:返回tree为根结点的二叉树的最小结点
     *
     * @param tree
     * @return
     */
    private BSTNode<T> minmum(BSTNode<T> tree) {
        //树为空
        if (tree == null) {
            return null;
        }

        //树不为空
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minmum() {
        BSTNode<T> minmumNode = minmum(mRoot);
        if (minmumNode != null) {
            return minmumNode.key;
        }
        return null;
    }

    /**
     * 查找最大结点：返回tree为根结点的二叉树的最大结点
     *
     * @param tree
     * @return
     */
    private BSTNode<T> maxmum(BSTNode<T> tree) {
        //树为空
        if (tree == null) {
            return null;
        }

        //树不为空
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public T maxmum() {
        BSTNode<T> maxmumNode = maxmum(mRoot);
        if (maxmumNode != null) {
            return maxmumNode.key;
        }
        return null;
    }
    //==================================================================================

    /**
     * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"
     *
     * @param x
     * @return
     */
    public BSTNode<T> successor(BSTNode<T> x) {
        if (x.right != null) {
            return minmum(x.right);
        }

        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = x.parent;
        while ((y != null) && x == y.right) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /**
     * 找结点(x)的前驱结点。即，查找"二叉树中数据值小于该结点"的"最大结点"
     *
     * @param x
     * @return
     */
    public BSTNode<T> predecessor(BSTNode<T> x) {
        if (x.left != null) {
            return minmum(x.left);
        }

        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = x.parent;
        while ((y != null) && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    //==================================================================================

    /**
     * 将结点插入到二叉树中
     *
     * @param bst :二叉树
     * @param z   :插入的结点
     */
    private void insert(BSTree<T> bst, BSTNode<T> z) {
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;

        //查找z的插入位置
        while (x != null) {
            y = x;
            cmp = z.key.compareTo(y.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if (y == null) {
            bst.mRoot = z;
        } else {
            cmp = z.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = z;
            } else {
                y.right = z;
            }
        }
    }

    public void insert(T key) {
        BSTNode<T> z = new BSTNode<>(key, null, null, null);

        //如果新建结点失败，则返回
        if (z != null) {
            insert(this, z);
        }
    }
    //==================================================================================

    /**
     * 删除结点(z)，并返回被删除的结点
     *
     * @param bst:二叉树
     * @param z:删除的结点
     * @return
     */
    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> x = null;
        BSTNode<T> y = null;

        if (z.left == null || z.right == null) {
            y = z;
        } else {
            y = successor(z);
        }

        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }

        if (x != null) {
            x.parent = y.parent;
        }

        if (y.parent == null) {
            bst.mRoot = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        if (y != z) {
            z.key = y.key;
        }

        return y;
    }

    /**
     * 删除键值为T结点
     *
     * @param key
     */
    public void remove(T key) {
        BSTNode<T> z, node;

        if ((z = recursiveSearch(mRoot, key)) != null) {
            if ((node = remove(this, z)) != null) {
                node = null;
            }
        }
    }
    //==================================================================================

    /**
     * 销毁二叉树
     *
     * @param tree
     */
    private void destroy(BSTNode<T> tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    //==================================================================================

    /**
     * 打印"二叉查找树"
     *
     * @param tree:二叉树
     * @param key:节点的键值
     * @param direction: 0，表示该节点是根节点;
     *                   -1，表示该节点是它的父结点的左孩子;
     *                   1，表示该节点是它的父结点的右孩子。
     */
    private void print(BSTNode<T> tree, T key, int direction) {

        if (tree != null) {
            //tree是根节点
            if (direction == 0) {
                System.out.println(tree.key + " is root");
            } else {
                //tree是分支节点
                String directions = (direction == 1 ? "right" : "left");
                System.out.println(tree.key + " is " + key + "'s " + directions + " child");
            }
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }

}
