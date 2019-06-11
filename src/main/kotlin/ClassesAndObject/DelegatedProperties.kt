package ClassesAndObject

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by wentaoKing on 2019-06-06
 * description: 属性代理
 */

class Example{
    var a by Delegate()
}

class Delegate{

    private var value: String ?= null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
        println("$thisRef, thank you for delegating '${property.name}' to me!")
        return value?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

}


fun main() {

//   var e = Example()
//    e.a = "10"
//    println(e.a)


//    println(lazyValue)
//    println(lazyValue)

    var de = Delegate()
    var b: String by de
    b = "10"
    println(b)

}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}
