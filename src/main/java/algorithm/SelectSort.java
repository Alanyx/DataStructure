package algorithm;

/**
 * 选择排序
 *
 * @author yinxing
 * @date 2019/1/16
 */

public class SelectSort {

    /**
     * @param a:待排序的数组
     * @param n:数组的长度
     */
    public static void selectSort(int[] a, int n) {
        //有序区的末尾位置
        int i;
        //无序区的起始位置
        int j;
        //无序区中最小元素位置
        int min;

        for (i = 0; i < n; i++) {
            min = i;

            //找出a[i+1]~a[n]之间的最小元素，并赋值给min
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }

                //若min!=i，交换a[i]和a[min]
                if (min != i) {
                    int tmp = a[i];
                    a[i] = a[min];
                    a[min] = tmp;
                }
            }

        }

    }
}
