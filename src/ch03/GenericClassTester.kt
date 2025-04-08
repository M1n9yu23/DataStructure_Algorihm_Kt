package ch03

private class GenericClassTester {
    class GenericClass<T>(val xyz: T)
}

fun main() {
    val s = GenericClassTester.GenericClass<String>("ABC")
    val n = GenericClassTester.GenericClass<Int>(15)

    println("${s.xyz}")
    println("${n.xyz}")
}