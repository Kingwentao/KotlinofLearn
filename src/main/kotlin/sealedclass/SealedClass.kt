package sealedclass

/**
 * Created by wentaoKing on 2019-06-11
 * description: 密封类的使用：用于
 */

sealed class PlayerCmd{
    class play(val url: String):PlayerCmd()
    class seek(val pos: Long): PlayerCmd()
    object pause: PlayerCmd()
}

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()


fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}

fun main() {
    eval(Const(12.0))
}