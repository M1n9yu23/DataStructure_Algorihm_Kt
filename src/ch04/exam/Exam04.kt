package ch04.exam


class IntArrayQueue(private val capacity: Int) {

    private var que: IntArray = try {
        IntArray(capacity) // 큐 본체용 배열 생성
    } catch (e: OutOfMemoryError) {
        IntArray(0).also { println("메모리 부족으로 큐를 생성할 수 없습니다.") }
    }
    private var num: Int = 0  // 현재 데이터 개수

    // 예외 클래스: 큐가 비어 있음
    class EmptyIntArrayQueueException : RuntimeException()

    // 예외 클래스: 큐가 가득 참
    class OverflowIntArrayQueueException : RuntimeException()

    // 인큐 (큐에 데이터를 추가)
    fun enque(x: Int): Int {
        if (num >= capacity) throw OverflowIntArrayQueueException()
        que[num++] = x
        return x
    }

    // 디큐 (큐에서 데이터를 꺼냄)
    fun deque(): Int {
        if (num <= 0) throw EmptyIntArrayQueueException()
        val x = que[0]
        for (i in 0 until num - 1) {
            que[i] = que[i + 1]
        }
        num--
        return x
    }

    // 피크 (맨 앞 데이터를 들여다봄)
    fun peek(): Int {
        if (num <= 0) throw EmptyIntArrayQueueException()
        return que[0] // 자바 코드에서는 num-1이었지만 큐의 앞을 보는 것이므로 que[0]이 맞음
    }

    // 검색 (x의 인덱스를 반환, 없으면 -1)
    fun indexOf(x: Int): Int {
        for (i in 0 until num) {
            if (que[i] == x) return i
        }
        return -1
    }

    // 큐 비우기
    fun clear() {
        num = 0
    }

    // 용량 반환
    fun capacity(): Int = capacity

    // 현재 데이터 수 반환
    fun size(): Int = num

    // 큐가 비어있는가?
    fun isEmpty(): Boolean = num <= 0

    // 큐가 가득 찼는가?
    fun isFull(): Boolean = num >= capacity

    // 모든 데이터 출력
    fun dump() {
        if (num <= 0) {
            println("큐가 비어 있습니다.")
        } else {
            for (i in 0 until num) {
                print("${que[i]} ")
            }
            println()
        }
    }
}

fun main() {
    val queue = IntArrayQueue(5) // 용량 5인 큐 생성

    println("=== 큐 테스트 시작 ===")

    // 데이터 추가 (enque)
    try {
        println("인큐: 10")
        queue.enque(10)

        println("인큐: 20")
        queue.enque(20)

        println("인큐: 30")
        queue.enque(30)
    } catch (e: IntArrayQueue.OverflowIntArrayQueueException) {
        println("에러: 큐가 가득 찼습니다.")
    }

    // 현재 상태 출력
    println("현재 큐 내용:")
    queue.dump()

    // 피크
    try {
        val peeked = queue.peek()
        println("피크: $peeked")
    } catch (e: IntArrayQueue.EmptyIntArrayQueueException) {
        println("에러: 큐가 비어 있어 피크할 수 없습니다.")
    }

    // 디큐
    try {
        val dequeued = queue.deque()
        println("디큐: $dequeued")
    } catch (e: IntArrayQueue.EmptyIntArrayQueueException) {
        println("에러: 큐가 비어 있어 디큐할 수 없습니다.")
    }

    // 다시 출력
    println("디큐 후 큐 내용:")
    queue.dump()

    // 검색 테스트
    val searchValue = 20
    val index = queue.indexOf(searchValue)
    if (index != -1) {
        println("$searchValue 는 인덱스 $index 에 있습니다.")
    } else {
        println("$searchValue 는 큐에 없습니다.")
    }

    // 큐 비우기
    println("큐 비우기")
    queue.clear()
    println("큐가 비었는가? -> ${queue.isEmpty()}")

    println("=== 큐 테스트 종료 ===")
}
