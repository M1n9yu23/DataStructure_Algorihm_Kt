package ch06

private fun shellSort(a: IntArray) {
    var h = a.size / 2

    while(h > 0) {
        for(i in h until a.size) {
            var j = i - h
            val tmp = a[i]
            while(j >= 0 && a[j] > tmp) {
                a[j + h] = a[j]
                j -= h
            }
            a[j + h] = tmp
        }
        h /= 2
    }
}

fun main() {
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    shellSort(x)

    println("오름차순으로 정렬했습니다.")
    x.forEachIndexed { index, value ->
        println("x[$index] = $value")
    }
}