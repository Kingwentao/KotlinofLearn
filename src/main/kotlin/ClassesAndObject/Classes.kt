package ClassesAndObject

/**
 * Created by wentaoKing on 2019-06-04
 * description: 学习类的特性
 */

class InitOrderDemo(name: String) {

    var firstProperty = "First property: $name".also (::println)
    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)
    init {
        println("Second initializer block that prints ${name.length}")
    }

}

fun main() {

    var init = InitOrderDemo("jason")
    println( init.firstProperty )

    var con = Constructors(1)
    con.toString()
}




class Constructors {

    constructor(i: Int) {
        println("Constructor")
    }

    init {
        println("Init block")
    }

}