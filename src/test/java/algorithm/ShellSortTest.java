package algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yinxing
 * @date 2019/1/21
 */

public class ShellSortTest {

    @Test
    public void shellSort() throws Exception {
        int i;
        int[] a =  {80,30,60,40,20,10,50,70};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

//       ShellSort.shellSort(a,a.length);
       ShellSort.shellSort2(a,a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}