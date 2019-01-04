package linear_structure;

/**
 * Created by yinxing on 2019/1/4.
 */
public class DoubleLink<T> {

    //双向链表"节点"对应的结构体
    private class DNode<T> {
        public DNode prev;
        public DNode next;
        public T value;

        public DNode(T value, DNode prev, DNode next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    //表头
    private DNode<T> mHead;

    //节点个数
    private int mCount;

    //构造函数
    public DoubleLink() {
        // 创建"表头"。注意：表头没有存储数据！
        mHead = new DNode<T>(null, null, null);
        mHead.prev = mHead.next = mHead;
        //初始化"节点个数"为0
        mCount = 0;
    }

    //返回节点数目
    public int size() {
        return mCount;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return mCount == 0;
    }

    //获取第index位置的节点
    private DNode<T> getNode(int index) {
        if (index < 0 || index >= mCount) {
            throw new IndexOutOfBoundsException();
        }

        //正向查找
        if (index <= mCount / 2) {
            //从头节点开始往下查找
            DNode<T> node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        //反向查找
        //找到最后一个节点
        DNode<T> rNode = mHead.prev;
        int rIndex = mCount - index + 1;
        for (int j = 0; j < rIndex; j++) {
            rNode = rNode.prev;
        }

        return rNode;
    }

    //获取第index位置的节点值
    public T getValue(int index) {
        return getNode(index).value;
    }

    //获取第1个节点的值
    public T getFirstValue() {
        return getNode(0).value;
    }

    //获取最后一个节点的值
    public T getLastValue() {
        return getNode(mCount - 1).value;
    }

    //将节点插入到第index位置之前
    public void insert(int index, T t) {
        //插入的位置为表头时
        if (index == 0) {
            DNode<T> node = new DNode<T>(t, mHead, mHead.next);
            mHead.prev.next = node;
            mHead.prev = node;
            mCount++;
            return;
        }

        //插入中间位置
        DNode<T> iNode = getNode(index);
        DNode<T> tNode = new DNode<T>(t, iNode.prev, iNode);
        iNode.prev.next = tNode;
        iNode.prev = tNode;
        mCount++;
        return;
    }

    //将节点插入第一个节点处
    public void insertFirst(T t) {
        insert(0, t);
    }

    //将节点追加到链表的末尾
    public void insertLast(T t) {
        DNode<T> node = new DNode<T>(t, mHead.prev, mHead);
        mHead.prev.next = node;
        mHead.prev = node;
        mCount++;
    }

    //删除index位置的节点
    public void delete(int index) {
        DNode<T> iNode = getNode(index);
        iNode.prev.next = iNode.next;
        iNode.next.prev = iNode.prev;
    }

    //删除第一个节点
    public void deleteFirst() {
        delete(0);
    }

    //删除最后一个节点
    public void deleteLast() {
        delete(mCount - 1);
    }

}