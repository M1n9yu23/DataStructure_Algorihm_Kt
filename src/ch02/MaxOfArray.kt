package ch02

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

    val height = IntArray(num) // 요소수가 num인 배열 생성

    for(i in 0 until num) {
        print("height[$i]: ")
        height[i] = readln().toInt()
    }

    val max = maxOf(height)

    println("최댓값은 $max 입니다.")
}