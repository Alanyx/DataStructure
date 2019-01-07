package linear_structure;

import org.junit.Test;

/**
 * @author yinxing
 * @date 2019/1/4
 */

public class ArrayQueueTest {

    @Test
    public void test() {
        int tmp = 0;
        ArrayQueue queue = new ArrayQueue(12);

        //将10,20,30依次推入队列
        queue.add(10);
        queue.add(20);
        queue.add(30);

        //将对列头元素赋给tmp,并删除列头元素
        tmp = queue.pop();
        System.out.println("tmp=" + tmp);

        //只将队列赋值给tmp,不删除该元素
        tmp = queue.front();
        System.out.println("tmp=" + tmp);

        queue.add(40);

        System.out.println("isEmpty()=" + queue.isEmpty());
        System.out.println("size()=" + queue.size());
        while (!queue.isEmpty()) {
            System.out.println("size()=" + queue.pop());
        }
    }

}