/**
 * Created by WenTaoKing on 2019-06-11
 * description:
 */
public class InnerClass {
    class nonStaticInner{
        public void print(){
            System.out.println("我是非静态内部类");
        }
    }

    public static class StaticInner{
        public static void print(){
            System.out.println("我是静态内部类");
        }
    }

    public static void main(String[] args){
        InnerClass.StaticInner.print();                  //静态内部类

        new InnerClass().new nonStaticInner().print();  //非静态内部类
    }
}

