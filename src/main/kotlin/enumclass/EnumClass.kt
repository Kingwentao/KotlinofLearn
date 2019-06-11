package enumclass

/**
 * Created by wentaoKing on 2019-06-11
 * description: 枚举类
 */

enum class EnumClass(id: Int){
    VERBOSE(0),DEBUG(1),INFO(2),WARN(3),ERROR(4);

    override fun toString(): String {
        return "[$ordinal]=$name"
    }
}


fun main() {
    println(EnumClass.values().map(::println))
    println(EnumClass.valueOf("DEBUG"))
}