package ch02

private fun primeNumber2(){
    var counter = 0 // 나눗셈 횟수
    var ptr = 0 // 찾은 소수의 개수
    val prime = IntArray(500) // 소수를 저장하는 배열

    prime[ptr++] = 2 // 2는 소수

    for(n in 3..1000 step 2) { // 조사 대상은 홀수만
        var i = 1
        while(i < ptr) {
            counter++
            if(n % prime[i] == 0)
                break
            i++
        }
        if(ptr == i) {
            prime[ptr++] = n
        }
    }

    for(i in 0 until ptr) {
        println(prime[i])
    }

    println("나눗셈 수행한 횟수: $counter")
}

fun main() {
    primeNumber2()
}