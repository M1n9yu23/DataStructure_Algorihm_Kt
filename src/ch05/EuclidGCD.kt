package ch05

private fun gcd(x: Int, y: Int): Int {
    return if(y == 0) x else gcd(y, x % y)
}
/*
1. x 22 y 8 main
2. x 8  y 6
3. x 6  y 2
4. x 2  y 0 return 2
 */
fun main() {
    val x = readln().toInt()
    val y = readln().toInt()

    println("최대 공약수: ${gcd(x,y)}")
}