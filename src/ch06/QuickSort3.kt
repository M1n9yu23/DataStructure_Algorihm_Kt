package ch06

private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val t = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = t
}

private fun sort3elem(x: IntArray, a: Int, b: Int, c: Int): Int {
    if (x[b] < x[a]) swap(x, b, a)
    if (x[c] < x[b]) swap(x, c, b)
    if (x[b] < x[a]) swap(x, b, a)

    return b
}

private fun quickSort(a: IntArray, left: Int, right: Int) {

    if(right - left < 2) {
        if (a[left] > a[right]) swap(a, left, right)
        return
    }

    var pl = left
    var pr = right
    val m = sort3elem(a, pl, (pl + pr) / 2, pr)
    val x = a[m]

    swap(a, m, right - 1)
    pl++
    pr -= 2

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
        print("x[$index]: ")
        readln().toInt()
    }

    quickSort(x, 0, x.size - 1)

    println("오름차순으로 정렬했습니다.")
    x.forEachIndexed { i, value ->
        println("x[$i]= $value")
    }
}