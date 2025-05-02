package ch06


private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val t = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = t
}

private fun downHeap(a: IntArray, left: Int, right: Int) {
    var temp = a[left] // 루트
    var parent = left
    var child: Int

    while(parent < (right + 1) / 2) {
        val cl = parent * 2 + 1
        val cr = cl + 1
        child = if(cr <= right && a[cr] > a[cl]) cr else cl

        if(temp >= a[child]) break

        a[parent] = a[child]
        parent = child
    }
    a[parent] = temp
}

private fun heapSort(a: IntArray){
    val n = a.size

    for(i in (n - 1) / 2 downTo 0)
        downHeap(a, i, n - 1)

    for(i in n - 1 downTo 1) {
        swap(a, 0 , i)
        downHeap(a, 0, i - 1)
    }
}

fun main() {
    println("힙 정렬")
    print("요솟수: ")
    val nx = readLine()!!.toInt()
    val x = IntArray(nx)

    for (i in 0 until nx) {
        print("x[$i]: ")
        x[i] = readLine()!!.toInt()
    }

    heapSort(x)

    println("오름차순으로 정렬했습니다.")
    for (i in x.indices)
        println("x[$i] = ${x[i]}")
}