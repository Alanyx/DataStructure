package data_structure.linear_structure;

/**
 * Java实现一: 数组实现“队列”，只能存储int数据
 * Java实现二: Java的 Collection集合 中自带的"队列"(LinkedList)的示例
 *
 * @author yinxing
 * @date 2019/1/4
 */
public class ArrayQueue {

    private int[] mArrary;
    private int mCount;

    public ArrayQueue(int size) {
        mArrary = new int[size];
        this.mCount = 0;
    }

    //将val添加到队尾
    public void add(int val) {
        mArrary[mCount++] = val;
    }

    //返回队列的开头元素
    public int front() {
        return mArrary[0];
    }

    //返回队列开头元素并删除
    public int pop() {
        int del = mArrary[0];
        for (int i = 1; i <= mCount; i++) {
            mArrary[i - 1] = mArrary[i];
        }
        mCount--;
        return del;
    }

    //返回队列的大小
    public int size() {
        return mCount;
    }

    //返回队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }
}
