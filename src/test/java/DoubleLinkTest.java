import linear_structure.DoubleLink;
import org.junit.Test;

/**
 * Created by yinxing on 2019/1/4.
 * 注：java自带的集合包中有实现双向链表，路径是:java.util.LinkedList
 */
public class DoubleLinkTest {


    /**
     * 双向链表操作int数据
     */
    @Test
    public void intTest() {
        System.out.println("-------intTest------");
        int[] iArr = {10, 20, 30, 40};

        //创建双向链表
        DoubleLink<Integer> doubleLink = new DoubleLink<>();

        //将5插入表头
        doubleLink.insert(0, iArr[0]);
        //将5插入表尾
        doubleLink.insertLast(iArr[1]);
        //将35插入表头
        doubleLink.insertFirst(iArr[2]);

        //判断双向链表是否为空
        System.out.printf("isEmpty()=%b\n", doubleLink.isEmpty());
        //双向链表的大小
        System.out.printf("size()=%d\n", doubleLink.size());

        //打印全部的节点
        for (int i = 0; i < doubleLink.size(); i++) {
            System.out.println("dlink(" + i + ")=" + doubleLink.getValue(i));
        }
    }

    @Test
    public void stringTest() {
        System.out.println("---------stringTest--------");
        String[] sArr = {"one", "two", "three", "four"};

        //注释同上
        DoubleLink<String> doubleLink = new DoubleLink<>();

        doubleLink.insert(0, sArr[0]);
        doubleLink.insertLast(sArr[1]);
        doubleLink.insertFirst(sArr[2]);

        System.out.printf("isEmpty()=%b\n", doubleLink.isEmpty());
        System.out.printf("size()=%d\n", doubleLink.size());

        for (int i = 0; i < doubleLink.size(); i++) {
            System.out.println("dlink(" + i + ")=" + doubleLink.getValue(i));
        }
    }

    public class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "id=" + id + ";name=" + name;
        }
    }

    @Test
    public void objectTest() {
        System.out.println("---------objectTest--------");

        Student[] students = new Student[]{
                new Student(1,"Alan"),
                new Student(2,"Bob"),
                new Student(3,"Catlina"),
                new Student(4,"David"),
        };
        //注释同上
        DoubleLink<Student> doubleLink = new DoubleLink<>();

        doubleLink.insert(0, students[0]);
        doubleLink.insertLast(students[1]);
        doubleLink.insertFirst(students[2]);

        System.out.printf("isEmpty()=%b\n", doubleLink.isEmpty());
        System.out.printf("size()=%d\n", doubleLink.size());

        for (int i = 0; i < doubleLink.size(); i++) {
            System.out.println("dlink(" + i + ")=" + doubleLink.getValue(i));
        }
    }



}