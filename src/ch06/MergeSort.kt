package ch06

private lateinit var buff: IntArray

private fun _mergeSort(a: IntArray, left: Int, right: Int) {
    if (left < right) {
        val center = (left + right) / 2
        var i = center + 1
        var p = 0
        var j = 0
        var k = left

        _mergeSort(a, left, center)
        _mergeSort(a, center + 1, right)

        for (index in left..center)
            buff[p++] = a[index]

        i = center + 1

        while (i <= right && j < p)
            a[k++] = if (buff[j] <= a[i]) buff[j++] else a[i++]

        while (j < p)
            a[k++] = buff[j++]
    }
}

private fun mergeSort(a: IntArray) {
    buff = IntArray(a.size)

    _mergeSort(a, 0, a.lastIndex)
}

fun main() {
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    mergeSort(x)

    println("오름차순으로 정렬했습니다.")

    x.forEachIndexed { i, e ->
        println("x[$i] = $e")
    }
}