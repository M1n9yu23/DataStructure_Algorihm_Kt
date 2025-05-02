package ch06

private fun swap(a: IntArray, idx1: Int, idx2: Int) {
    val tmp = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = tmp
}

private fun partition(a: IntArray) {
    var pl = 0
    var pr = a.size - 1
    var x = a[a.size / 2]

    do {
        while(a[pl] < x) pl++
        while(a[pr] > x) pr--
        if(pl <= pr)
            swap(a, pl++, pr--)
    } while(pl <= pr)

    println("피벗 값은 $x 입니다.")

    println("피벗 이하의 그룹")
    for(i in 0..pl-1) // a[0] ~ a[pl - 1]
        print("${a[i]} ")
    println()

    if(pl > pr + 1){
        println("피벗과 같은 그룹")
        for(i in (pr + 1)..(pl - 1)) {
            print("${a[i]} ")
        }
        println()
    }

    println("피벗 이상의 그룹")
    for(i in (pr + 1) until a.size) {
        print("${a[i]} ")
    }
    println()
}

fun main() {
    print("요솟수: ")
    val x = IntArray(readln().toInt()) { index ->
        print("x[$index] : ")
        readln().toInt()
    }

    partition(x)
}