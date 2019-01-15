package data_structure.tree_structure;

import org.junit.Test;

/**
 * @author yinxing
 * @date 2019/1/14
 */

public class BSTreeTest {

    private static final int arr[] = {1, 5, 4, 3, 2, 6};

    @Test
    public void BSTreeTest() {
        BSTree<Integer> tree = new BSTree<>();

        System.out.println("依次添加:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("插入" + arr[i]);
            tree.insert(arr[i]);
        }

        System.out.println("====================");
        System.out.println("\n前序遍历：");
        tree.preOrder();

        System.out.println("\n中序遍历:");
        tree.inOrder();

        System.out.println("\n后序遍历:");
        tree.postOrder();

        System.out.println("\n====================");
        System.out.println("最小值:" + tree.minmum());
        System.out.println("最大值:" + tree.minmum());
        System.out.println("打印树的详细信息:");
        tree.print();

        System.out.println("====================");
        System.out.println("\n删除节点:" + arr[3]);
        tree.remove(arr[3]);

        System.out.println("\n中序遍历:");
        tree.inOrder();

        System.out.println("\n====================");
        //销毁二叉树
        tree.clear();
        tree.print();
    }

}