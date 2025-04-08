package ch03

private class SeqSearchSen {
    companion object {
        fun seqSearchSen(a: IntArray, n: Int, key: Int): Int {
            var i = 0

            a[n] = key // 배열은 n + 1만큼 생성돼서 맨 마지막 인덱스에 key를 넣음 즉 보초를 추가

            while(true) {
                if(a[i] == key)
                    break
                i++
            }

            return if(i == n) -1 else i
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

    val idx = SeqSearchSen.seqSearchSen(x, num, key)

    if(idx == -1) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
    }
}