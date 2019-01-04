package linear_structure;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yinxing on 2019/1/4.
 * 测试java集合包中的Stack的演示程序
 */
public class StackTest {

    @Test
    public void test() {
        int tmp = 0;
        Stack<Integer> stack = new Stack<>();

        //将10，20，30依次推入栈中
        stack.push(10);
        stack.push(20);
        stack.push(30);

        //将栈顶元素赋值给tmp,并删除栈顶元素
        tmp = stack.pop();
        System.out.println("tmp=" + tmp);

        //只将栈顶赋值给tmp,不删除该元素
        tmp = stack.peek();
        System.out.println("tmp=" + tmp);

        while (!stack.empty()) {
            tmp = stack.pop();
            System.out.println("tmp=" + tmp);
        }

    }
}
