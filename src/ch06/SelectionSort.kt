package ch06

private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val t = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = t
}

private fun selectionSort(a: IntArray, n: Int) {
    for(i in 0 until n - 1) {
        var min = i
        for(j in i + 1 until n) {
            if(a[j] < a[min])
                min = j
        }
        swap(a, i, min)
    }
}

fun main() {
    val n = readln().toInt()

    val x = IntArray(n)

    for(i in 0 until n) {
        print("x[$i]: ")
        x[i] = readln().toInt()
    }

    selectionSort(x, n)

    for(i in 0 until n) {
        println("x[$i] = ${x[i]}")
    }
}