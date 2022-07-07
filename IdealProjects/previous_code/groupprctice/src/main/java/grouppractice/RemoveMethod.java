package grouppractice;

import java.util.Scanner;

public class RemoveMethod {
        private int size;  //定义长度
        private Object a[] = {};   // 数组为空

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            RemoveMethod t = new RemoveMethod();
            do {
                System.out.println("请输入您想要加入的数组，输入“Bye”结束");
                String o = scan.next();
                if (o.equals("Bye")) {
                    break;
                }
                t.add(o);
            } while (true);
            System.out.print("您输入的集合为：[");
            for (Object o : t.a) {
                System.out.print(o);
                if (o != t.a[t.a.length - 1]) {
                    System.out.print("，");
                }
            }
            System.out.println("]");
            System.out.println();
            System.out.println("请输入您想要删除的元素");
            Object o = scan.next();
            t.remove(o);
            System.out.print("删除后的集合为：");
            System.out.print("您输入的集合为：[");
            for (Object o1 : t.a) {
                System.out.print(o1);
                if (o1 != t.a[t.a.length - 1]) {
                    System.out.print("，");
                }
            }
            System.out.println("]");
        }

        public void add(Object o) {
            serchIndex(size + 1);
            a[size++] = o;
        }

        public void serchIndex(int size) {
            if (a.length < size) {
                int oldLength = a.length;
//          int newLength = oldLength*3/2;
                int newLength = oldLength + oldLength >> 1; //自增50%
                if (newLength == oldLength) {
                    newLength = size;
                }
                Object b[] = new Object[newLength];
                System.arraycopy(a, 0, b, 0, oldLength);
                a = b;
            }
        }

        public void remove(Object o) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (o.equals(a[i])) {
                    index = i;
                    break;
                }
            }
            delete(index);
        }

        public void delete(int index) {
            if (index >= 0) {
                System.arraycopy(a, index + 1, a, index, size - 1 - index);
                size--;
//            a[size] = null;
            }
        }
    }

