package ch06

import ch04.IntStack

private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val tmp = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = tmp
}

private fun quickSort(a: IntArray, left: Int, right: Int) {
    val lStack = IntStack(right - left + 1)
    val rStack = IntStack(right - left + 1)

    lStack.push(left)
    rStack.push(right)

    while(!lStack.isEmpty()) {
        var pl = lStack.pop()
        var pr = rStack.pop()
        val x = a[(pl + pr) / 2]

        var l = pl
        var r = pr

        do {
            while(a[l] < x) l++
            while(a[r] > x) r--
            if(l <= r) swap(a, l++, r--)
        } while(l <= r)

        if(pl < r) {
            lStack.push(pl)
            rStack.push(r)
        }

        if(l < pr) {
            lStack.push(l)
            rStack.push(pr)
        }
    }
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