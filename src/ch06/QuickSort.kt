package ch06

private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val tmp = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = tmp
}

private fun quickSort(a: IntArray, left: Int, right: Int) {
    var pl = left
    var pr = right
    var x = a[(pl + pr) / 2]

    do {
        while(a[pl] < x) pl++
        while(a[pr] > x) pr--
        if(pl <= pr) swap(a, pl++, pr--)
    } while(pl <= pr)

    if(left < pr) quickSort(a, left, pr)
    if(pl < right) quickSort(a, pl, right)
}

fun main() {
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    quickSort(x, 0, x.size - 1)

    for(i in 0 until x.size) {
        println("x[$i] = ${x[i]}")
    }
}