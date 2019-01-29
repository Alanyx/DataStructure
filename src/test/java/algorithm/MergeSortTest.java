package algorithm;

import org.junit.Test;

/**
 * @author yinxing
 * @date 2019/1/29
 */

public class MergeSortTest {

    @Test
    public void mergeSort() throws Exception {
        int i;
        int[] a = {80, 30, 60, 40, 20, 10, 50, 70};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        //归并排序(从上往下)
//        MergeSort.mergeSortUp2Down(a, 0, a.length - 1);
        //归并排序(从下往上)
        MergeSort.mergeSortDown2Up(a);

        System.out.printf("after sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

}