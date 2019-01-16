package algorithm;

import org.junit.Test;

/**
 * @author yinxing
 * @date 2019/1/16
 */

public class SelectSortTest {

    @Test
    public void selectSort() throws Exception {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        SelectSort.selectSort(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}