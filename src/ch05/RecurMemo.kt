package ch05

private lateinit var memo: Array<String?>

private fun recur(n: Int) {
    if (memo[n + 1] != null) {
        print(memo[n + 1])
    } else {
        if (n > 0) {
            recur(n - 1)
            println(n)
            recur(n - 2)
            // recur(n - 1) 결과 + 현재 n + 줄바꿈 + recur(n - 2) 결과를 저장
            memo[n + 1] = memo[n] + "$n\n" + memo[n - 1] // 메모화
        } else {
            memo[n + 1] = ""
        }
    }
}

fun main() {
    val x = readln().toInt()

    memo = arrayOfNulls(x + 2)
    recur(x)
}