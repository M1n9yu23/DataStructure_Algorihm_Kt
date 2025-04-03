package ch01

private fun multi99Table(){
    println("---------구구단 곱셈표---------")

    for(i in 1..9) {
        for(j in 1..9) {
            print("%3d".format(i * j))
        }
        println()
    }
}

fun main() {
    multi99Table()
}