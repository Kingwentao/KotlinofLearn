package ClassesAndObject

/**
 * Created by wentaoKing on 2019-06-05
 * description: 类的继承
 */


//如果某个类需要被继承，那么需要使用open关键字
//open class Base(p: Int)
//
//class Derived(p: Int) : Base(p)


open class Base {
    open fun v() {  }
    fun nv() { }
}
class Derived() : Base() {
    override fun v() { }
}

open class Foo {
    open val x: Int get() = 1
}

class Bar1 : Foo() {
    override val x: Int get() = 2
}

class Bar2(override val x: Int) : Foo()


fun main() {
    var bar = Bar1()
    var bar2 = Bar2(10)
    println(bar.x)
    println(bar2.x)

    var carDriver = CarDriver()
    var se =  SeniorManager(carDriver)
    var se2 =  SeniorManager2(carDriver)
    se.drive()

}



open class Foo2 {
    open fun f() { println("Foo.f()") }
    open val x: Int get() = 1
}

//调用父类的方法和属性
class Bar : Foo2() {
    override fun f() {
        super.f()
        println("Bar.f()")
    }

    override val x: Int get() = super.x + 1
}


class Bar3 : Foo2() {
    override fun f() { /* ... */ }
    override val x: Int get() = 0

    inner class Baz {
        fun g() {
            super@Bar3.f() // Calls Foo's implementation of f()
            println(super@Bar3.x) // Uses Foo's implementation of x's getter
        }
    }
}


abstract class abstractClass {
    abstract fun f()
}


interface Driver{
    fun drive()
}


//Driver实现
class CarDriver: Driver{
    override fun drive() {
        println("开车呢")
    }
}



//使用接口代码（by 关键字)
class SeniorManager(val driver: Driver):Driver by driver

class SeniorManager2(val driver: Driver){

    init {
        driver.drive()
    }

}



