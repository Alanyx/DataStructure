package algorithm;

/**
 * 堆排序
 *
 * @author yinxing
 * @date 2019/1/28
 */

public class HeapSort {

    /**
     * (最大)堆的向下调整算法
     * <p>
     * 备注:数组实现的堆中，第N个节点的座孩子的索引值是(2N+1),右孩子索引是(2N+2)。
     * 其中，N为数组下标索引值，如数组中第一个数对应的N为0。
     *
     * @param a:待排序的数组
     * @param start:被下调节点的起始位置(一般从0开始)
     * @param end:截至范围(一般为数组中最后一个元素的索引)
     */
    public static void maxHeapDown(int[] a, int start, int end) {
        //当前节点的位置
        int current = start;
        //左孩子(left)的位置
        int left = 2 * current + 1;
        //当前节点的大小
        int tmp = a[current];

        for (; left <= end; current = left, left = left * 2 + 1) {
            // "left"是左孩子，"left+1"(相当于2 * current + 2)是右孩子
            if (left < end && a[left] < a[left + 1]) {
                //左右孩子中选择较大者,即m_heap[l+1]
                left++;
            }
            //如果一开始的根节点就满足这个条件，后面的节点没有满足该条件，跳出循环是不是不合适？是不是应该换成continue?
            // 这一个方法是针对具体一个节点进行的堆向下调整，不是整个树，所以调整好之后break即可
            if (tmp >= a[left]) {
                //调整结束
                break;
            } else {
                //交换值
                a[current] = a[left];
                a[left] = tmp;
            }
        }
    }

    /**
     * 堆排序(从小到大)
     *
     * @param a:待排序的数组
     * @param n:数组的长度
     */
    public static void heapSortAsc(int[] a, int n) {
        int i, tmp;

        //从(n/2-1)-->0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉树
        for (i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, n - 1);
        }

        //从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            //交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            //调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆
            //即保证a[i-1]是a[0...i-1]中的最大值
            maxHeapDown(a, 0, i - 1);
        }
    }

    /**
     * (最小)堆的向下调整算法[与最大堆正好相反]
     * <p>
     * 备注:数组实现的堆中，第N个节点的座孩子的索引值是(2N+1),右孩子索引是(2N+2)。
     * 其中，N为数组下标索引值，如数组中第一个数对应的N为0。
     *
     * @param a:待排序的数组
     * @param start:被下调节点的起始位置(一般从0开始)
     * @param end:截至范围(一般为数组中最后一个元素的索引)
     */
    public static void minHeapDown(int[] a, int start, int end) {
        //当前节点的位置
        int current = start;
        //左孩子(left)的位置
        int left = 2 * current + 1;
        //当前节点的大小
        int tmp = a[current];

        for (; left <= end; current = left, left = left * 2 + 1) {
            // "left"是左孩子，"left+1"(相当于2 * current + 2)是右孩子
            if (left < end && a[left] > a[left + 1]) {
                //左右孩子中选择较大者,即m_heap[l+1]
                left++;
            }
            //如果一开始的根节点就满足这个条件，后面的节点没有满足该条件，跳出循环是不是不合适？是不是应该换成continue?
            // 这一个方法是针对具体一个节点进行的堆向下调整，不是整个树，所以调整好之后break即可
            if (tmp <= a[left]) {
                //调整结束
                break;
            } else {
                //交换值
                a[current] = a[left];
                a[left] = tmp;
            }
        }
    }

    /**
     * 堆排序(从大到小)
     *
     * @param a:待排序的数组
     * @param n:数组的长度
     */
    public static void heapSortDesc(int[] a, int n) {
        int i, tmp;

        //从(n/2-1)-->0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉树
        for (i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(a, i, n - 1);
        }

        //从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            //交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            //调整a[0...i-1]，使得a[0...i-1]仍然是一个最小堆
            //即保证a[i-1]是a[0...i-1]中的最小值
            minHeapDown(a, 0, i - 1);
        }
    }

}
