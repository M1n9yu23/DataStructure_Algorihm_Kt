package ch01.exam

private fun exam11(){
    print("  |")
    for(i in 1..9) {
        print("%3d".format(i))
    }
    println()
    println("---+--------------------------")

    for(i in 1..9) {
        print("%d |".format(i))
        for(j in 1..9) {
            print("%3d".format(i * j))
        }
        println()
    }
}

fun main() {
    exam11()
}