package linear_structure;

import java.util.Stack;

/**
 * @author yinxing
 * @date 2019/1/7
 * Collection集合 中自带的"队列"(LinkedList)的示例
 */

public class StackList<T> {

    //向队列添加数据时:1.将"已有的全部数据"移到mIn中；2.将"新添加的数据"添加到mIn中
    private Stack<T> mIn = null;
    //从队列获取元素时:1.将"已有的全部数据"都移到mOut中;2.返回并删除mOut队头元素
    private Stack<T> mOut = null;
    //统计计数
    private int mCount = 0;

    public StackList() {
        mIn = new Stack<T>();
        mOut = new Stack<T>();
        mCount = 0;
    }

    public void add(T t){
        // 将“已有的全部数据”都移到mIn中
        while (!mOut.isEmpty()){
            mIn.push(mOut.pop());
            /// todo 这里应该加这么一行
            mCount++;
        }

        //将"新添加的数据"添加到mIn中
        mIn.push(t);
        mCount++;
    }

    public T get(){
        //将"已有的全部数据"都移到mOut中
        while(!mIn.isEmpty()){
            mOut.push(mIn.pop());
        }
        mCount--;

        //返回并删除mOut队头元素
        return mOut.pop();
    }

    public int size(){
        return mCount;
    }

    public boolean isEmpty(){
        return mCount==0;
    }
}
