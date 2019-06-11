package innerclass

/**
 * Created by wt.King on 2019-06-10
 * description:
 */


//Kotlin里内部类默认是静态内部类，用inner表示非静态内部类
class Outter {
    inner class Inner {
        fun print() {
            println("我是非静态内部类")
        }
    }

    class StaticInner {
        fun print2() {
            println("我是静态内部类")
        }
    }
}

fun main() {

    println( Outter().Inner().print() )
    println(Outter.StaticInner().print2())
}