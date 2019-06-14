package HigherFunction

/**
 * Created by wentaoKing on 2019-06-12
 * description: 高阶函数的概念
 */




fun main(args: Array<String>) {
    args.forEach(::print)

    val myfun = MyClass:: MyFun  //两个冒号引用类的方法
    println(myfun)

    args.filter(String:: isNotEmpty)

    args.forEach(PdfPrint():: println)  //kotlin1.1及以后才支持
}


class MyClass{
    fun MyFun(){
        println("我是MyClass类的方法")
    }
}

class PdfPrint{
    fun println(any: Any){
        kotlin.io.println(any)
    }
}