栈与实现(Java)
====

##概要
本章会先对栈的原理进行介绍，然后通过Java来演示栈的实现示例。注意：本文所说的栈是数据结构中的栈，而不是内存模型中栈。内容包括：

* 1. 栈的介绍
* 2. 栈的Java实现

##栈的介绍
栈（stack），是一种线性存储结构，它有以下几个特点：

1.栈中数据是按照"后进先出（LIFO, Last In First Out）"方式进出栈的。

2.向栈中添加/删除数据时，只能从栈顶进行操作。

####栈通常包括的三种操作：push、peek、pop。

* push -- 向栈中添加元素。
* peek -- 返回栈顶元素。
* pop  -- 返回并删除栈顶元素的操作。

###1. 栈的示意图
<img src="/Users/yinxing/Desktop/imag/stack/1.jpg" style="zoom:80%"></img>

栈中的数据依次是 30 --> 20 --> 10

###2. 出栈
<img src="/Users/yinxing/Desktop/imag/stack/2.jpg" style="zoom:80%"></img>

出栈前：栈顶元素是30。此时，栈中的元素依次是 30 --> 20 --> 10 

出栈后：30出栈之后，栈顶元素变成20。此时，栈中的元素依次是 20 --> 10

###3.入栈
<img src="/Users/yinxing/Desktop/imag/stack/3.jpg" style="zoom:80%"></img>

入栈前：栈顶元素是20。此时，栈中的元素依次是 20 --> 10 

入栈后：40入栈之后，栈顶元素变成40。此时，栈中的元素依次是 40 --> 20 --> 10


##栈的Java实现
参见GeneralArrayStack，GeneralArrayStackTest和StackTest

