package ch06

private fun countingSort(a: IntArray, max: Int) {
    val f = IntArray(max + 1)
    val b = IntArray(a.size)

    for(i in 0 until a.size) f[a[i]]++
    for(i in 1..max) f[i] += f[i - 1]
    for(i in (a.size - 1) downTo 0) b[--f[a[i]]] = a[i]
    for(i in 0 until a.size) a[i] = b[i]
}

fun main() {
    println("도수 정렬")
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    var max = x[0]
    for(i in 1 until x.size) if(x[i] > max) max = x[i]

    countingSort(x, max)

    println("오름차순으로 정렬")
    for(i in x.indices)
        println("x[$i] = ${x[i]}")

}