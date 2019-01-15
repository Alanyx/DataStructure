package algorithm;

import org.junit.Test;

/**
 * @author yinxing
 * @date 2019/1/15
 */

public class BubbleSortTest {

    @Test
    public void bubbleSort() throws Exception {
        int i;

        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.println("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");

        BubbleSort.bubbleSort(a, a.length);
//        BubbleSort.bubbleSort2(a, a.length);

        System.out.println("after sort:");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}