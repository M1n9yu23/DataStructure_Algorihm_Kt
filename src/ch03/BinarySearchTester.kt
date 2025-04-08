package ch03

fun main() {
    print("요솟수: ")
    val n = readln().toInt()
    val x = IntArray(n)

    println("오름차순으로 입력하세요.")

    print("x[0]: ")
    x[0] = readln().toInt()

    for(i in 1 until n) {
        while(true) {
            print("x[$i]: ")
            x[i] = readln().toInt()

            if(x[i] > x[i-1])
                break
        }
    }

    print("검색할 값: ")
    val key = readln().toInt()

    val idx = x.binarySearch(key)

    if(idx < 0) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
    }
}