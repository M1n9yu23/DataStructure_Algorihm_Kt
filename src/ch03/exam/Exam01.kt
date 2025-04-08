package ch03.exam

private class Exam01 {
    companion object {
        fun seqSearchSen(a: IntArray, n: Int, key: Int) : Int {
            a[n] = key // 보초

            for(i in 0..n) {
                if(a[i] == key) {
                    return if(i == n) -1 else i
                }
            }

            return -1
        }
    }
}

fun main() {
    print("요솟수: ")
    val num = readln().toInt()
    val x = IntArray(num + 1) // 요솟수가 num + 1인 배열 보초를 추가하기 위해

    for(i in 0 until x.lastIndex) {
        print("x[$i]: ")
        x[i] = readln().toInt()
    }

    print("검색할 값: ")
    val key = readln().toInt()

    val idx = Exam01.seqSearchSen(x, num, key)

    if(idx == -1) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
    }
}