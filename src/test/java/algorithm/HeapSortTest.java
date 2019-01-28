package algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yinxing
 * @date 2019/1/28
 */

public class HeapSortTest {

    @Test
    public void heapSortTest() {
        int i;
        int[] a = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//        HeapSort.heapSortAsc(a, a.length);
        HeapSort.heapSortDesc(a,a.length);

        System.out.printf("after sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

}