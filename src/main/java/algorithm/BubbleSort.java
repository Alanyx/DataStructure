package algorithm;

/**
 * 冒泡排序
 *
 * @author yinxing
 * @date 2019/1/14
 */

public class BubbleSort {

    /**
     * 基本版
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        int i, j;

        for (i = n - 1; i > 0; i--) {
            //将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    //交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 改进版
     *
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {
        int i, j;
        //标记(若有交换为1;否则为0,表示已经有序无需再比较)
        int flag;

        for (i = n - 1; i > 0; i--) {
            //初始化标记为0
            flag = 0;
            //将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;

                    //若发生交换，则设为1
                    flag = 1;
                }
            }

            //如果某一趟没有发生交换，说明排序已经完成，直接跳出循环
            if (flag == 0) {
                break;
            }
        }
    }

}
