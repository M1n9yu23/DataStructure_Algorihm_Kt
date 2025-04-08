package ch03

private class BinSearch {
    companion object {
        fun binSearch(a: IntArray, n: Int, key: Int) : Int {
            var pl = 0
            var pr = n - 1
            var pc = (pl + pr) / 2

            do {
                if(a[pc] == key) {
                    return pc
                } else if(a[pc] < key) {
                    pl = pc + 1
                } else {
                    pr = pc - 1
                }

                pc = (pl + pr) / 2
            } while(pl <= pr)

            return -1
        }
    }
}

fun main() {
    print("요솟수: ")
    val n = readln().toInt()

    val x = IntArray(n)

    println("오름차순으로 입력하세요.")

    print("x[0]: ")
    x[0] = readln().toInt()

    for(i in 1 until n) {
        do {
            print("x[$i]: ")
            x[i] = readln().toInt()
        } while(x[i] < x[i - 1])
    }

    print("검색할 값: ")
    val key = readln().toInt()

    val idx = BinSearch.binSearch(x, n, key)

    if(idx == -1) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
    }
}