package ch02


fun main() {
    var counter = 0

    for(n in 2..1000) {
        var i = 2
        while(i < n) {
            counter++
            if(n % i == 0) break
            i++
        }
        if(n == i) {
            println(n)
        }
    }

    println("나눗셈을 수행한 횟수: $counter")
}