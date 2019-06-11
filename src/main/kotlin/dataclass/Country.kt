package dataclass

/**
 * Created by wentaoKing on 2019-06-10
 * description: 国家类
 */

data class Country(val id: Int,val name: String)

class ComponentX{
    operator fun component1(): String{
        return "我是"
    }

    operator fun component2(): String{
        return "007"
    }
}

fun main() {
    val china = Country(0,"中国")
    println(china)
    println(china.component1())
    println(china.component2())
    val(id,name) = china
    println(id)
    println(name)

    val componentX = ComponentX()
    val(a,b) = componentX
    println("$a$b")


    //copy方法
    val newCountry = china.copy()
    println(newCountry)

}

