04二叉堆与Java实现
=====
 
##概要

###目录
1. 二叉堆的介绍
2. 二叉堆的图文解析
3. 二叉堆的Java实现(完整源码)
4. 二叉堆的Java测试程序

##介绍
二叉堆是完全二元树或者是近似完全二元树，按照数据的排列方式可以分为两种：最大堆和最小堆。
最大堆：父结点的键值总是大于或等于任何一个子节点的键值；最小堆：父结点的键值总是小于或等于任何一个子节点的键值。

二叉堆一般都通过"数组"来实现，下面是数组实现的最大堆和最小堆的示意图：

<img src="/Users/yinxing/Desktop/imag/heap/01.jpg" style="zoom:100%" ></img>

##图文解析
图文解析是以"最大堆"来进行介绍的。
最大堆的核心内容是"添加"和"删除"，理解这两个算法，二叉堆也就基本掌握了。下面对它们进行介绍，其它内容请参考后面的完整源码。

####1. 添加

假设在最大堆[90,80,70,60,40,30,20,10,50]种添加85，需要执行的步骤如下：

<img src="/Users/yinxing/Desktop/imag/heap/02.jpg" style="zoom:100%" ></img>

如上图所示，当向最大堆中添加数据时：先将数据加入到最大堆的最后，然后尽可能把这个元素往上挪，直到挪不动为止！
将85添加到[90,80,70,60,40,30,20,10,50]中后，最大堆变成了[90,85,70,60,80,30,20,10,50,40]。

最大堆的插入代码(Java语言)

~~~
/*
 * 最大堆的向上调整算法(从start开始向上直到0，调整堆)
 *
 * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
 *
 * 参数说明：
 *     start -- 被上调节点的起始位置(一般为数组中最后一个元素的索引)
 */
protected void filterup(int start) {
    int c = start;            // 当前节点(current)的位置
    int p = (c-1)/2;        // 父(parent)结点的位置 
    T tmp = mHeap.get(c);        // 当前节点(current)的大小

    while(c > 0) {
        int cmp = mHeap.get(p).compareTo(tmp);
        if(cmp >= 0)
            break;
        else {
            mHeap.set(c, mHeap.get(p));
            c = p;
            p = (p-1)/2;   
        }       
    }
    mHeap.set(c, tmp);
}
  
/* 
 * 将data插入到二叉堆中
 */
public void insert(T data) {
    int size = mHeap.size();

    mHeap.add(data);    // 将"数组"插在表尾
    filterup(size);        // 向上调整堆
}
~~~

insert(data)的作用：将数据data添加到最大堆中。mHeap是动态数组ArrayList对象。
当堆已满的时候，添加失败；否则data添加到最大堆的末尾。然后通过上调算法重新调整数组，使之重新成为最大堆。


####2. 删除

假设从最大堆[90,85,70,60,80,30,20,10,50,40]中删除90，需要执行的步骤如下：

<img src="/Users/yinxing/Desktop/imag/heap/03.jpg" style="zoom:100%" ></img>

如上图所示，当从最大堆中删除数据时：先删除该数据，然后用最大堆中最后一个的元素插入这个空位；接着，把这个“空位”尽量往上挪，直到剩余的数据变成一个最大堆。
从[90,85,70,60,80,30,20,10,50,40]删除90之后，最大堆变成了[85,80,70,60,40,30,20,10,50]。


注意：考虑从最大堆[90,85,70,60,80,30,20,10,50,40]中删除60，执行的步骤不能单纯的用它的字节点来替换；而必须考虑到"替换后的树仍然要是最大堆"！

<img src="/Users/yinxing/Desktop/imag/heap/04.jpg" style="zoom:100%" ></img>

二叉堆的删除代码(Java语言)

~~~
/* 
 * 最大堆的向下调整算法
 *
 * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
 *
 * 参数说明：
 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
 */
protected void filterdown(int start, int end) {
    int c = start;          // 当前(current)节点的位置
    int l = 2*c + 1;     // 左(left)孩子的位置
    T tmp = mHeap.get(c);    // 当前(current)节点的大小

    while(l <= end) {
        int cmp = mHeap.get(l).compareTo(mHeap.get(l+1));
        // "l"是左孩子，"l+1"是右孩子
        if(l < end && cmp<0)
            l++;        // 左右两孩子中选择较大者，即mHeap[l+1]
        cmp = tmp.compareTo(mHeap.get(l));
        if(cmp >= 0)
            break;        //调整结束
        else {
            mHeap.set(c, mHeap.get(l));
            c = l;
            l = 2*l + 1;   
        }       
    }   
    mHeap.set(c, tmp);
}

/*
 * 删除最大堆中的data
 *
 * 返回值：
 *      0，成功
 *     -1，失败
 */
public int remove(T data) {
    // 如果"堆"已空，则返回-1
    if(mHeap.isEmpty() == true)
        return -1;

    // 获取data在数组中的索引
    int index = mHeap.indexOf(data);
    if (index==-1)
        return -1;

    int size = mHeap.size();
    mHeap.set(index, mHeap.get(size-1));// 用最后元素填补
    mHeap.remove(size - 1);                // 删除最后的元素

    if (mHeap.size() > 1)
        filterdown(index, mHeap.size()-1);    // 从index号位置开始自上向下调整为最小堆

    return 0;
}
~~~

##Java实现
二叉堆的实现同时包含了"最大堆"和"最小堆"。

* 二叉堆(最大堆)的实现文件(MaxHeap.java)

* 二叉堆(最小堆)的实现文件(MinHeap.java)


##Java测试程序
见