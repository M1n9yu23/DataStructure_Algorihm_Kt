package ch06


private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val t = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = t
}

private fun bubbleSort(a: IntArray, n: Int) {
    var k = 0
    while(k < n - 1) {
        var last = n - 1
        for(i in n - 1 downTo k + 1) {
            if(a[i - 1] > a[i]) {
                swap(a, i - 1, i)
                last = i
            }
        }
        k = last
    }
}

fun main() {
    val n = readln().toInt()

    val x = IntArray(n)

    for(i in 0 until n) {
        print("x[$i]: ")
        x[i] = readln().toInt()
    }

    bubbleSort(x, n)

    for(i in 0 until n) {
        println("x[$i] = ${x[i]}")
    }
}