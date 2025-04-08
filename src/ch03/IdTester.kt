package ch03

private class Id private constructor(val id: Int) {
    companion object {
        private var _counter = 0

        val counter = _counter

        fun create(): Id = Id(++_counter)
    }
}

fun main() {
    val a = Id.create()
    val b = Id.create()

    println("a의 아이디: ${a.id}")
    println("b의 아이디: ${b.id}")
    println("부여한 아이디의 개수: ${Id.counter}")
}