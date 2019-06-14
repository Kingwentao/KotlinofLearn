package HigherFunction

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.StringBuilder

/**
 * Created by wentaoKing on 2019-06-12
 * description: 常用的高阶函数
 */


fun main(args: Array<String>) {
    val list = listOf(1,3,4,5,10,8,2)

    //1.在list的基础上创建一个新的集合并遍历
    var newList = list.map {
        it*2+3
    }
    newList.forEach(::println)

    //2.把list集合的int元素类型转化成double类型
    var newList2 = list.map {
        it.toDouble()
    }
    newList2.forEach(::println)

    val listOfList = listOf(
        1..10,
        11..20,
        21..30
    )
    //3.把list集合中的集合元素摊开，赋值到一个新的集合中
    var flatList = listOfList.flatMap {intRange ->
        intRange.map {intElement->
            intElement
        }
    }
    println(flatList)


    //4.对集合的元素进行运算
    val addResult = flatList.reduce { acc, s -> acc+s }
    println("结果是$addResult")

    //5.求阶乘
    val factorResult = factorial(6)
    println("阶乘结果=$factorResult")
    //输出阶乘遍历过程的结果
    (0..6).map(::factorial).forEach(::println)

    //6.fold叠加集合元素
    val fold = (0..6).map(::factorial).fold(0){
        acc, i ->  acc + i
    }
    println("fold叠加后结果=$fold")

    //7.fold叠加字符
    val foldString = (0..6).map(::factorial).fold(StringBuilder()){
        acc: StringBuilder, i: Int ->
          acc.append(i).append(",")
    }
    println("fold字符串后的结果=$foldString")

    val foldString2 = (0..6).map(::factorial).foldRight(StringBuilder()){
        i: Int,acc: StringBuilder ->
        acc.append(i).append(",")
    }
    println("fold右字符串后的结果=$foldString2")
    //上面等价于此方式
    println((0..6).map(::factorial).joinToString(","))


    //8.filter的使用
    val filterRes = (0..6).map(::factorial).filter { it % 2 == 0 }
    println("过滤掉奇数的结果=$filterRes")
    val filterIndexRes = (0..6).map(::factorial).filterIndexed{index, i -> index % 2 == 0 }
    println("过滤掉奇数位置的值=$filterIndexRes")

    //9.takeWhile 取符合条件的数据，如遇到不符合条件的跳出
    val takeWhileRes = (0..6).map(::factorial).takeWhile { it % 2 == 1 }
    println("取出奇数（未遇到偶数前）= $takeWhileRes")

    //10.let he apply

    findPerson()?.let { (name,age) ->
        println("姓名 : $name")
        println("年龄 : $age")
    }

    findPerson()?.apply {
        work()
        println("年龄 : $age")
    }


    //11.读取一个文件感受with的作用
    val br = BufferedReader(FileReader(File("/Users/wentaoking/IdeaProjects/KotlinOfLearn/src/" +
            "main/resources/hello.txt")))
    with(br){
        var line: String?
        while (true){
            line = readLine()?:break
            println(line)
        }
        close()
    }

    //以上读取文件的简单方式,使用readText
    val brEasy = BufferedReader(FileReader(File("/Users/wentaoking/IdeaProjects/KotlinOfLearn/src/" +
            "main/resources/hello.txt"))).readText()
    println(brEasy)

    //使用use简化读取文本
    BufferedReader(FileReader(File("/Users/wentaoking/IdeaProjects/KotlinOfLearn/src/" +
            "main/resources/hello.txt"))).use {
        var line: String
        while (true){
            line = it.readLine()?: break
            println("使用了use高级函数：$line")
        }
    }

    // example()


}


fun factorial(n: Int): Int{
    if( n == 0) return 1
    return (1..n).reduce { acc, i ->  acc * i }
}


data class Person(val name: String,val age: Int){
    fun work(){
        println("年仅$age 的$name 正在工作")
    }
}

fun findPerson(): Person?{
    return Person("jwt",23)
}




//官方文档的栗子
fun example(){

    // Lambdas are code blocks enclosed in curly braces.
    val items = listOf(1, 2, 3, 4, 5)
    items.fold(0,{
            acc: Int, i: Int ->
        println("acc=$acc,i=$i")
        val result = acc + i
        println("result = $result")
        result
    })

    // Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("0",{acc, i -> acc + "," + i })
    println(joinedToString)

    //Function references can also be used for higher-order function calls:
    val product = items.fold(2.0,Double::times)
    println(product)
}