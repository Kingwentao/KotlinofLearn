package ClassesAndObject

import java.lang.StringBuilder

/**
 * Created by wentaoKing on 2019-06-06
 * description: 扩展成员
 */

fun main() {

    println( "abc".copyContent(10))
    println("abc"*10)
    println( 1*2)

}


fun String.copyContent(times: Int): String{

    var string = StringBuilder()
    for (i in 0 until times){
        string.append(this)
    }
    return string.toString()
}


operator fun String.times(times: Int): String{
    var string = StringBuilder()
    for (i in 0 until times){
        string.append(this)
    }
    return string.toString()
}