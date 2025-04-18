package ch04

class IntStack(private val capacity: Int) {
    private var ptr = 0
    private val stk = try {
        IntArray(capacity)
    } catch (e: OutOfMemoryError) {
        IntArray(0)
    }

    class EmptyIntStackException : RuntimeException()
    class OverflowIntStackException : RuntimeException()

    fun push(x: Int): Int {
        if (ptr >= capacity) throw OverflowIntStackException()
        stk[ptr] = x
        return stk[ptr++] // stk[ptr] 값을 반환하고 난 다음에 ptr 증가
    }

    fun pop(): Int {
        if (ptr <= 0) throw EmptyIntStackException()
        return stk[--ptr] // 푸시 할 때 마지막으로 증가를 시키니깐 --ptr을 해줘야함
    }

    fun peek(): Int {
        if (ptr <= 0) throw EmptyIntStackException()
        return stk[ptr - 1]
    }

    fun clear() {
        ptr = 0
    }

    fun indexOf(x: Int): Int {
        for (i in ptr - 1 downTo 0) {
            if (stk[i] == x)
                return i
        }
        return -1
    }

    fun getCapacity(): Int {
        return capacity
    }

    fun size(): Int {
        return ptr
    }

    fun isEmpty(): Boolean {
        return ptr <= 0
    }

    fun isFull(): Boolean {
        return ptr >= capacity
    }

    fun dump() {
        if (ptr <= 0) println("스택이 비어 있습니다.")
        else {
            for (i in 0 until ptr) print("${stk[i]} ")
            println()
        }
    }
}

fun main() {
    val stack = IntStack(64)

    while (true) {
        println()
        println("현재 데이터 개수: ${stack.size()} / ${stack.getCapacity()}")
        print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료: ")

        var menu = readln().toInt()
        if(menu == 0) break

        var x: Int? = null

        when (menu) {
            1 -> {
                print("데이터: ")
                x = readln().toInt()
                try {
                    stack.push(x)
                } catch (e: IntStack.OverflowIntStackException) {
                    println("스택이 가득 찼습니다.")
                }
            }
            2 -> {
                try {
                    x = stack.pop()
                    println("팝한 데이터는 $x 입니다.")
                } catch (e: IntStack.EmptyIntStackException) {
                    println("스택이 비어 있습니다.")
                }
            }
            3 -> {
                try {
                    x = stack.peek()
                    println("피크한 데이터는 $x 입니다.")
                } catch (e: IntStack.EmptyIntStackException) {
                    println("스택이 비어 있습니다.")
                }
            }
            4 -> {
                stack.dump()
            }
        }
    }
}