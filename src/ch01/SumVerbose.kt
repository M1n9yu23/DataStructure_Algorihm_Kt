package ch01

private fun sumVerbose(){
    println("1부터 n까지의 합을 구합니다.")
    var n = -1

    do {
        print("n: ")
        n = readln().toInt()
    } while(n <= 0)

    var sum = 0

    for(i in 1..n){
        if(i < n) {
            print("$i + ")
        } else { // 마지막
            print("$i = ")
        }
        sum += i
    }

    println(sum)
}

fun main() {
    sumVerbose()
}