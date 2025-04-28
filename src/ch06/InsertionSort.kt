package ch06

private fun insertionSort(a: IntArray, n: Int) {
    for(i in 1 until n) {
        var j = i
        val tmp = a[i]
        while(j > 0 && a[j - 1] > tmp) {
            a[j] = a[j - 1]
            j--
        }
        a[j] = tmp
    }
}

fun main() {
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    insertionSort(x, x.size)

    println("오름차순으로 정렬했습니다.")
    x.forEachIndexed { index, value ->
        println("x[$index] = $value")
    }
}