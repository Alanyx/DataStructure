package algorithm;

/**
 * 快速排序
 *
 * @author yinxing
 * @date 2019/1/16
 */

public class QuickSort {

    public static void quickSort(int[] a, int left, int right) {

        if (left < right) {
            int i, j, x;

            i = left;
            j = right;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x) {
                    //从右往左找第一个小于x的数
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }

                while (i < j && a[i] < x) {
                    //从左往右找第一个大于x的数
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }

            a[i] = x;
            //递归调用(左半边)
            quickSort(a, left, i - 1);
            //递归调用(右半边)
            quickSort(a, i + 1, right);
        }
    }
}
