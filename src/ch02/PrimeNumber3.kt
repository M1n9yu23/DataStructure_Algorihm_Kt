package ch02

fun main() {
    var counter = 0
    var ptr = 0
    val prime = IntArray(500)

    prime[ptr++] = 2
    prime[ptr++] = 3

    for(n in 5..1000 step 2) {
        var flag = false
        var i = 1
        while(prime[i] * prime[i] <= n) {
            counter += 2
            if(n % prime[i] == 0){
                flag = true
                break
            }
            i++
        }

        if(!flag) {
            prime[ptr++] = n
            counter++
        }
    }

    for(i in 0 until ptr) {
        println(prime[i])
    }

    println("곱셈과 나눗셈을 수행한 횟수: $counter")
}