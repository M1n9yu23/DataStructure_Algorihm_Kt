package ch02

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

    print("사람 수: ")
    val num = readln().toInt()

    val height = IntArray(num) { Random.nextInt(100, 190)} // 100부터 189까지의 난수 생성해서 각 요소에 넣음
    // IntArray(num) { index -> 초기화할 값 }
    // 크기는 num인 배열을 생성하고 각 요소는 인덱스 자체 값(0 1 2 같은)을 이용해서 초기화

    for(i in height.indices){
        println("height[$i] = ${height[i]}")
    }

    val max = maxOf(height)

    println("최댓값은 $max 입니다.")
}