package linear_structure;

import org.junit.Test;


/**
 * @author yinxing
 * @date 2019/1/7
 */

public class StackListTest {

    @Test
    public void test() {
        StackList stackList = new StackList();

        stackList.add(10);
        stackList.add(20);
        stackList.add(30);

        System.out.println("isEmpty()=" + stackList.isEmpty());
        System.out.println("size()=" + stackList.size());

        while (!stackList.isEmpty()) {
            System.out.println("stackList:" + stackList.get());
        }
    }

}