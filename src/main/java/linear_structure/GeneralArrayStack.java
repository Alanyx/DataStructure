package linear_structure;

import java.lang.reflect.Array;

/**
 * Created by yinxing on 2019/1/4.
 * Java实现一：数组实现的栈，能存储任意类型的数据
 * Java实现二：jdk中stack实现
 */
public class GeneralArrayStack <T>{

    private static final int DEFAULT_SIZE = 12;
    private T[] mArray;
    private int count;

    public GeneralArrayStack(Class<T> type, int size) {
        ///todo 为什么不行？
        //T不能直接实例化: this.mArray = new T[DEFAULT_SIZE];
        this.mArray =(T[]) Array.newInstance(type,size);
        this.count = 0;
    }

    public GeneralArrayStack(Class<T> type) {
        this(type,DEFAULT_SIZE);
    }

    //将val添加到栈中
    public void push(T val){
        mArray[count++]=val;
    }

    //返回栈顶元素值
    public T peek(){
        return mArray[count-1];
    }

    //返回栈顶元素值，并删除栈顶元素
    public T pop(){
        T del = mArray[count-1];
        count--;
        return del;
    }

    //返回栈的大小
    public int size(){
        return count;
    }

    //返回栈是否为空
    public boolean isEmpty(){
        return size()==0;
    }

    //打印栈
    public void printArrayStack(){
        if(isEmpty()){
            System.out.println("stack is empty\n");
            return;
        }

        System.out.printf("stack size()=%d\n",size());
        int i = size()-1;
        while (i>=0){
            System.out.println(mArray[i]);
            i--;
        }
    }

}
