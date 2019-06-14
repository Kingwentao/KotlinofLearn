package closure

/**
 * Created by wentaoKing on 2019-06-14
 * description: 闭包的使用: 函数的运行环境
 */


val string = "HelloWorld"

fun makeFun(): () -> Unit{
    var count = 0
    return fun(){
        println(count++)
    }
}


//闭包下求斐波切拉数
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long{
        val res = second
        second += first
        first = res
        return res
    }
}


fun fibonacci2(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
      object: LongIterator(){
          override fun nextLong(): Long {
              val res = second
              second += first
              first = res
              return res
          }
          override fun hasNext() = true
      }
    }
}


fun add(x: Int) = fun(y: Int) = x + y

fun addComplex(x: Int): (Int) -> Int{
    return fun(y: Int): Int{
        return  x+y
    }
}


fun main() {
    val x = makeFun()
    x()
    x()
    println(x)

    val f = fibonacci()
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())

    for (i in fibonacci2()){
        if( i > 200) break
        println(i)
    }


    var add5 = add(5)
    println(" 5+2 的结果= " + add5(2) )

    var addComplex = addComplex(5)
    println(addComplex(2))
    println(addComplex(3))

}