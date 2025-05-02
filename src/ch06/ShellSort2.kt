package ch06

private fun shellSort(a: IntArray) {
    var h = 1
    while (h < a.size) {
        h = h * 3 + 1
    }

    while (h > 0) {
        h /= 3
        for (i in h until a.size) {
            val tmp = a[i]
            var j = i - h
            while (j >= 0 && a[j] > tmp) {
                a[j + h] = a[j]
                j -= h
            }
            a[j + h] = tmp
        }
    }
}

fun main() {
    println("셸 정렬(버전 2)")
    print("요솟수: ")
    val nx = readLine()?.toInt() ?: return
    val x = IntArray(nx)

    for (i in 0 until nx) {
        print("x[$i]: ")
        x[i] = readLine()?.toInt() ?: return
    }

    shellSort(x)  // 배열 x를 셸정렬

    println("오름차순으로 정렬했습니다.")
    for (i in x.indices) {
        println("x[$i] = ${x[i]}")
    }
}