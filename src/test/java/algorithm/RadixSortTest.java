package algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yinxing
 * @date 2019/1/29
 */

public class RadixSortTest {

    @Test
    public void radixSort() throws Exception {
        int i;
        int[] a = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        RadixSort.radixSort(a);

        System.out.printf("after sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

}