package algorithm;

/**
 * 希尔排序
 *
 * @author yinxing
 * @date 2019/1/17
 */

public class ShellSort {

    /**
     * @param a:待排序的数组
     * @param n:数组的长度
     */
    public static void shellSort(int[] a, int n) {

        //gap为补偿，每次减为原来的一半
        for (int gap = n / 2; gap > 0; gap /= 2) {

            //共gap个组，对每一个组都执行直接插入排序
            for (int i = 0; i < gap; i++) {

                for (int j = i + gap; j < n; j += gap) {
                    //如果a[j]<a[j-gap],则寻找a[j]位置，并将后面数据的位置都后移
                    if (a[j] < a[j - gap]) {
                        int tmp = a[j];
                        int k = j - gap;

                        while (k >= 0 && a[k] > tmp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = tmp;
                    }
                }

            }
        }
    }

    public static void groupSort(int[] a, int n, int i, int gap) {

        for (int j = i + gap; j < n; j += gap) {
            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (a[j] < a[j - gap]) {

                int tmp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > tmp) {
                    a[k + gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = tmp;
            }
        }
    }

    public static void shellSort2(int[] a, int n) {
        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {
                groupSort(a, n, i, gap);
            }
        }
    }


}
