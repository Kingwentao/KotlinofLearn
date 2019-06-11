package ClassesAndObject

/**
 * Created by wentaoKing on 2019-06-05
 * description: Kotlin的单例实现
 */


abstract class OnMusicStateListener{
    abstract fun play()
}

object MusicPlayer: OnMusicStateListener() {

    var state :Int = 0
    override fun play(){
        println("播放音乐")
    }

}


fun main() {

    println(MusicPlayer.play())
}