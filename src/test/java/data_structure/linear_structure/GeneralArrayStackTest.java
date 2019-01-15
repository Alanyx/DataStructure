package data_structure.linear_structure;

import org.junit.Test;

/**
 * Created by yinxing on 2019/1/4.
 */
public class GeneralArrayStackTest {

    @Test
    public void test() {
        String tmp;
        GeneralArrayStack<String> stack = new GeneralArrayStack<String>(String.class);

        //将10，20，30依次推入栈中
        stack.push("10");
        stack.push("20");
        stack.push("30");

        //将栈顶元素赋值给tmp,并删除栈顶元素
        tmp = stack.pop();
        System.out.println("tmp=" + tmp);

        //只将栈顶赋值给tmp,不删除该元素
        tmp = stack.peek();
        System.out.println("tmp=" + tmp);

        stack.push("40");
        //打印栈(非空)
        stack.printArrayStack();

        System.out.println("isEmpty()=" + stack.isEmpty());
        System.out.println("size()=" + stack.size());

        GeneralArrayStack<String> emptyStack = new GeneralArrayStack<String>(String.class);
        //打印栈(空)
        emptyStack.printArrayStack();
    }

}