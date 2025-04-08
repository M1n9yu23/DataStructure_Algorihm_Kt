package ch03

private class SeqSearch {
    companion object {
        fun seqSearch(a: IntArray, n: Int, key: Int): Int{
            var i = 0

            while(true) {
                if(i == n) {
                    return -1 // 검색 실패
                }

                if(a[i] == key) {
                    return i // 검색 성공
                }
                i++
            }
        }

        fun seqSearchFor(a: IntArray, key: Int): Int {
            for(i in a.indices) {
                if(a[i] == key) {
                    return i
                }
            }
            return -1
        }
    }
}

fun main() {
    print("요솟수: ")
    val num = readln().toInt()
    val x = IntArray(num)

    for(i in 0 until num) {
        print("x[$i]: ")
        x[i] = readln().toInt()
    }

    print("검색할 값: ")
    val key = readln().toInt()

    var idx = SeqSearch.seqSearch(x, num, key)

    println("while 사용")
    if(idx == -1) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
    }

    println("for 사용")
    idx = SeqSearch.seqSearchFor(x, key)
    if(idx == -1) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
    }
}