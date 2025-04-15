package ch04

private class IntQueue(private var capacity: Int) {
    private val que = try {
        IntArray(capacity)
    } catch (e: OutOfMemoryError) {
        IntArray(0)
    }
    private var front = 0
    private var rear = 0
    private var num = 0

    class EmptyIntQueueException : RuntimeException()
    class OverflowIntQueueException : RuntimeException()

    fun enque(x: Int): Int {
        if (num >= capacity) throw OverflowIntQueueException()
        que[rear++] = x
        num++
        if (rear == capacity) rear = 0
        return x
    }

    fun deque(): Int {
        if (num <= 0) throw EmptyIntQueueException()
        val x = que[front++]
        num--
        if (front == capacity) front = 0
        return x
    }

    // 디큐 될 값을 미리 봄
    fun peek(): Int {
        if(num <= 0) throw EmptyIntQueueException()
        return que[front]
    }

    fun clear() {
        num = 0
        front = 0
        rear = 0
    }

    fun indexOf(x: Int): Int {
        for(i in 0 until num) {
            var idx = (i + front) % capacity // 디큐 될 인덱스 부터 시작
            // 용량 -> 12
            // i -> 0 1 2 3 4 5  num = 6
            // front -> 7 8 9 10 11 0
            // 7 % 12 = 7 즉 idx = 7 8 9 10 11 0 이런식으로 됨
            if(que[idx] == x) return idx
        }
        return -1
    }

    fun getCapacity(): Int {
        return capacity
    }

    fun size(): Int {
        return num
    }

    fun isEmpty(): Boolean{
        return num <= 0
    }

    fun isFull(): Boolean {
        return num >= capacity
    }

    fun dump(){
        if(num <= 0) println("큐가 비어 있습니다.")
        else {
            for(i in 0 until num) {
                print("${que[i + front] % capacity} ")
            }
            println()
        }
    }
}

fun main() {
    val queue = IntQueue(64)

    while(true) {
        println()
        println("현재 데이터 개수: ${queue.size()} / ${queue.getCapacity()}")
        print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (0) 종료: ")

        var menu = readln().toInt()
        if(menu == 0) break

        var x: Int?

        when (menu) {
            1 -> {
                print("데이터: ")
                x = readln().toInt()
                try {
                    queue.enque(x)
                } catch(e: IntQueue.OverflowIntQueueException){
                    println("큐가 가득 찼습니다.")
                }
            }
            2 -> {
                try {
                    x = queue.deque()
                    println("디큐한 데이터는 $x 입니다.")
                } catch (e: IntQueue.EmptyIntQueueException) {
                    println("큐가 비어 있습니다.")
                }
            }
            3 -> {
                try {
                    x = queue.peek()
                    println("다음으로 디큐될 데이터는 $x 입니다.")
                } catch (e: IntQueue.EmptyIntQueueException) {
                    println("큐가 비어 있습니다.")
                }
            }
            4 -> queue.dump()
        }
    }
}