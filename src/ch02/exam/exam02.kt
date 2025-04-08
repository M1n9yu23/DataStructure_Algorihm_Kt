package ch02.exam

private fun exam02(){
    println("역순으로 정렬합니다.")
    print("n: ")
    val n = readln().toInt()

    val a = IntArray(n)

    for(i in 0 until a.size) {
        print("a[$i]: ")
        a[i] = readln().toInt()
    }

    for(i in 0 until (a.size / 2)) {
        println(a.joinToString())
        println("a[$i]과 a[${a.size - i - 1}]을 교환합니다.")
        val t = a[i]
        a[i] = a[a.size - i - 1]
        a[a.size - i - 1] = t
    }

    println(a.joinToString())
    println("역순 정렬을 마쳤습니다.")

}

fun main() {
    exam02()
}