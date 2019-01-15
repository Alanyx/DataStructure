package algorithm;

/**
 * 直接插入排序
 *
 * @author yinxing
 * @date 2019/1/15
 */

public class InsertSort {

    public static void insertSort(int[] a) {
        int i, j, k;

        //从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < a.length; i++) {
            //为a[i]在前面的a[0...i-1]有序区间中找到一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    break;
                }
            }

            //如果找到了一个合适的位置(j从0找到i-1)
            if (j != i - 1) {
                //将比a[i]大的数据向后移动
                int tmp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                //将a[i]放到正确的位置上
                a[k + 1] = tmp;
            }
        }
    }

    /**
     * 改进版(更好理解)
     *
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        int i, j;
        // 要插入的数据
        int insertNote = 0;
        int[] array = arr;
        // 从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < array.length; i++) {
            // 设置数组中的第2个元素为第一次循环要插入的数据
            insertNote = array[i];
            j = i - 1;
            // 比较关键元素与前一个，若成立后退一个位置
            // 在最幸运的那种情况当中，这个循环语句是不会执行的
            for (; j >= 0 && insertNote < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = insertNote;
        }
    }
}
