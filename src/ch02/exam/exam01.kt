package ch02.exam

import kotlin.random.Random

private fun  maxOf(a: IntArray): Int{
    var max = a[0]

    for(i in 1 until a.size) { // 인덱스 1부터 끝까지
        if(a[i] > max) max = a[i]
    }

    return max
}

fun main() {
    println("키의 최댓값을 구합니다.")

    val num = Random.nextInt(1, 11)

    println("사람 수: $num")

    val height = IntArray(num) { Random.nextInt(100, 190)}

    for(i in height.indices){
        println("height[$i] = ${height[i]}")
    }

    val max = maxOf(height)

    println("최댓값은 $max 입니다.")
}