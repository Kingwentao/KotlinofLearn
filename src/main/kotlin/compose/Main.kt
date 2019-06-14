package compose

/**
 * Created by wentaoKing on 2019-06-14
 * description: 复合函数的使用
 */

val add5 = {i: Int ->i + 5 }  //f(x)
val multiplyBy2 = {i: Int -> i*2 } //g



fun main() {

    val res = multiplyBy2(add5(2))
    println(" 两次函数运算结果：$res ")

    val add5AndMulitPlayBy2 = multiplyBy2 andThen  add5
    println("复合函数运行结果: " +add5AndMulitPlayBy2(2))

    val addComposeMulitPlayBy2 = multiplyBy2 compose add5
    println("复合函数运行结果: " +addComposeMulitPlayBy2(2))

}



infix fun<P1,P2,R> Function1<P1,P2>.andThen(function: Function1<P2,R>): Function1<P1,R>{
    return fun(p1: P1): R{
        return function.invoke(this.invoke(p1))
    }

}

infix fun<P1,P2,R> Function1<P2,R>.compose(function: Function1<P1,P2>): Function1<P1,R>{
    return fun(p1: P1): R{
        return this.invoke(function.invoke(p1))
    }
}
