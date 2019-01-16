package algorithm;

/**
 * @author yinxing
 * @date 2019/1/16
 */

public class QuickSortTest {

    /**
     * TestNG测试
     *
     * @throws Exception
     */
    @org.testng.annotations.Test
    public void testQuickSort() throws Exception {
        int i;
        int a[] = {30, 40, 60, 10, 20, 50};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}