package algorithm;

/**
 * 归并排序
 *
 * @author yinxing
 * @date 2019/1/28
 */

public class MergeSort {

    /**
     * 将一个数组中的两个相邻的有序区间合并成一个
     *
     * @param a:包含两个有序区间的数组
     * @param start:第1个有序区间的起始地址
     * @param mid:第1个有序区间的结束地址，也是第2个有序区间的起始地址
     * @param end:第2个有序区间的结束地址
     */
    public static void merge(int[] a, int start, int mid, int end) {
        //tmp是汇总2个有序区间的临时区域
        int[] tmp = new int[end - start + 1];
        //第1个有序区间的索引
        int i = start;
        //第2个有序区间的索引
        int j = mid + 1;
        //临时区域的索引
        int k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = a[i++];
        }

        while (j <= end) {
            tmp[k++] = a[j++];
        }

        //将排序后的元素，全部都整合到数组a中
        for (i = 0; i < k; i++) {
            a[start + i] = tmp[i];
        }

        tmp = null;
    }

    /**
     * 归并排序(从上往下)
     *
     * @param a:待排序的数组
     * @param start:数组的起始位置
     * @param end:数组的结束地址
     */
    public static void mergeSortUp2Down(int[] a, int start, int end) {
        if (a == null || start >= end) {
            return;
        }

        int mid = (end + start) / 2;
        //递归排序a[start...mid]
        mergeSortUp2Down(a, start, mid);
        //递归排序a[mid...end]
        mergeSortUp2Down(a, mid + 1, end);

        //a[start...mid]和a[mid...end]是两个有序空间，将它们排序成一个有序空间a[start...end]
        merge(a, start, mid, end);
    }

    /**
     * 对数组a做若干次合并:数组a的长度为len,将它分为若干个长度为gap的子数组：
     * 将"每2个相邻的子数组"进行合并排序
     *
     * @param a:待排序的数组
     * @param len:数组的长度
     * @param gap:子数组的长度
     */
    public static void mergeGroups(int[] a, int len, int gap) {
        int i;
        //两个相邻的子数组的长度
        int twolen = 2 * gap;

        //将"每2个相邻的子数组"进行合并排序
        for (i = 0; i + 2 * gap - 1 < len; i += (2 * gap)) {
            merge(a, i, i + gap - 1, i + 2 * gap - 1);
        }

        //若i+gap-1<len-1,则剩余一个子数组没有配对
        //将该子数组合并到已经排序的数组中
        if (i + gap - 1 < len - 1) {
            merge(a, i, i + gap - 1, len - 1);
        }
    }

    /**
     * 归并排序(从下往上)
     * @param a
     */
    public static void mergeSortDown2Up(int[] a) {
        if (a == null) {
            return;
        }

        for (int n = 1; n < a.length; n *= 2) {
            mergeGroups(a, a.length, n);
        }

    }


}
