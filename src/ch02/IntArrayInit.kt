package ch02

private fun intArrayInit(){
    val a = intArrayOf(1,2,3,4,5) // 배열 생성 및 초기화

    for(i in a.indices) {
        println("a[$i] = ${a[i]}")
    }

}

fun main() {
    intArrayInit()
}