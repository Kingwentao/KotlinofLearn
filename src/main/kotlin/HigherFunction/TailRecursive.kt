package HigherFunction

/**
 * Created by wentaoKing on 2019-06-13
 * description: 尾递归优化 使用tailrec关键字
 * 如果一个函数中所有递归形式的调用都出现在函数的末尾，我们称这个递归函数是尾递归的。
 * 尾递归函数的特点是在回归过程中不用做任何操作，这个特性很重要，因为大多数现代的编译器会利用这种特点自动生成优化的代码。
 */

data class ListNode(val value: Int,var next: ListNode? = null)

tailrec fun findListNode(head: ListNode?,value: Int): ListNode?{
    head?: return null
    if(head.value == value) return head
    return findListNode(head.next,value)
}

fun factorial(n: Long): Long{
    return n * (factorial(n-1))
}


fun main() {
    val nodeCount = 1000000
    val head = ListNode(1)
    var p = head
    for( i in 1..nodeCount){
        p.next = ListNode(i)
        p = p.next!!  //节点可为空
    }
    println("根据值查找节点")
    println(findListNode(head,nodeCount-3)?.value)
}