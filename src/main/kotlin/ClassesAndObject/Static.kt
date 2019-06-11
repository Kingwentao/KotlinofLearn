package ClassesAndObject

/**
 * Created by wentaoKing on 2019-06-05
 * description: Kotlin中的静态类
 */

//Kotlin中的静态属性，它和Java不同，Java的静态属性是由一个类包裹起来的，但Kotlin中不是
fun main(args: Array<String>) {
    val a = minOf(args[0].toInt(),args[1].toInt())

    //
    val latitude = Latitude.ofLatitude(Latitude(2.0))
    println("纬度是${latitude.value}")
}



class Latitude constructor(val value: Double){

    //伴生对象
    companion object{
        fun ofLatitude(latitude: Latitude): Latitude{
            return Latitude(latitude.value)
        }
    }
}




class MyClass {
    companion object{
        fun create(): MyClass = MyClass()
        var a = 1
    }


}

val instance = MyClass.create()
var v = MyClass.a



//
class defalutPa{

    fun a(str: String = "1"){

    }

    fun a(str: Int){

    }
}
