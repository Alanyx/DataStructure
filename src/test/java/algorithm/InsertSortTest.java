package algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yinxing
 * @date 2019/1/15
 */

public class InsertSortTest {

    @Test
    public void insertSort() throws Exception {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.println("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");

        InsertSort.insertSort(a);
        System.out.println("after sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }

}