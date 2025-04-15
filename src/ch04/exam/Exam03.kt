package ch04.exam

// 머리가 둘인 int형 고정 길이 스택
class DoubleHeadIntStack(private val capacity: Int) {
    private val stk = IntArray(capacity) // 스택 본체
    private var ptrA = 0 // 스택포인터 A
    private var ptrB = capacity - 1 // 스택포인터 B

    enum class AorB {
        StackA, StackB
    }

    // 실행 시 예외 : 스택이 비어 있음
    class EmptyDoubleHeadIntStackException : RuntimeException()

    // 실행 시 예외 : 스택이 가득 참
    class OverflowDoubleHeadIntStackException : RuntimeException()

    // 스택에 x를 푸시
    fun push(sw: AorB, x: Int): Int {
        if (ptrA >= ptrB + 1) { // 스택이 가득 참
            throw OverflowDoubleHeadIntStackException()
        }
        when (sw) {
            AorB.StackA -> stk[ptrA++] = x
            AorB.StackB -> stk[ptrB--] = x
        }
        return x
    }

    // 스택에서 데이터를 팝 (꼭대기의 데이터를 꺼냄)
    fun pop(sw: AorB): Int {
        var x = 0
        when (sw) {
            AorB.StackA -> {
                if (ptrA <= 0) throw EmptyDoubleHeadIntStackException()
                x = stk[--ptrA]
            }
            AorB.StackB -> {
                if (ptrB >= capacity - 1) throw EmptyDoubleHeadIntStackException()
                x = stk[++ptrB]
            }
        }
        return x
    }

    // 스택에서 데이터를 피크 (꼭대기의 데이터를 들여다 봄)
    fun peek(sw: AorB): Int {
        var x = 0
        when (sw) {
            AorB.StackA -> {
                if (ptrA <= 0) throw EmptyDoubleHeadIntStackException()
                x = stk[ptrA - 1]
            }
            AorB.StackB -> {
                if (ptrB >= capacity - 1) throw EmptyDoubleHeadIntStackException()
                x = stk[ptrB + 1]
            }
        }
        return x
    }

    // 스택에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환
    fun indexOf(sw: AorB, x: Int): Int {
        when (sw) {
            AorB.StackA -> {
                for (i in ptrA - 1 downTo 0) { // 꼭대기 쪽에서 선형검색
                    if (stk[i] == x) return i // 검색 성공
                }
            }
            AorB.StackB -> {
                for (i in ptrB + 1 until capacity) { // 꼭대기 쪽에서 선형검색
                    if (stk[i] == x) return i // 검색 성공
                }
            }
        }
        return -1 // 검색 실패
    }

    // 스택을 비움
    fun clear(sw: AorB) {
        when (sw) {
            AorB.StackA -> ptrA = 0
            AorB.StackB -> ptrB = capacity - 1
        }
    }

    // 스택 용량을 반환
    fun getCapacity(): Int = capacity

    // 스택에 쌓여 있는 데이터 수를 반환
    fun size(sw: AorB): Int {
        return when (sw) {
            AorB.StackA -> ptrA
            AorB.StackB -> capacity - ptrB - 1
        }
    }

    // 스택이 비어 있는지 확인
    fun isEmpty(sw: AorB): Boolean {
        return when (sw) {
            AorB.StackA -> ptrA <= 0
            AorB.StackB -> ptrB >= capacity - 1
        }
    }

    // 스택이 가득 찼는지 확인
    fun isFull(): Boolean = ptrA >= ptrB + 1

    // 스택 안의 모든 데이터를 바닥 → 꼭대기의 순서로 출력
    fun dump(sw: AorB) {
        when (sw) {
            AorB.StackA -> {
                if (ptrA <= 0) println("스택이 비어 있습니다.")
                else {
                    for (i in 0 until ptrA) print("${stk[i]} ")
                    println()
                }
            }
            AorB.StackB -> {
                if (ptrB >= capacity - 1) println("스택이 비어 있습니다.")
                else {
                    for (i in capacity - 1 downTo ptrB + 1) print("${stk[i]} ")
                    println()
                }
            }
        }
    }
}

fun main() {
    val s = DoubleHeadIntStack(64) // 최대 64개 푸시할 수 있는 머리가 둘인 스택

    while (true) {
        println("현재 데이터 개수 : A : ${s.size(DoubleHeadIntStack.AorB.StackA)} / B : ${s.size(DoubleHeadIntStack.AorB.StackB)}")
        println("( 1) A 푸시 ( 2) A 팝 ( 3) A 피크 ( 4) A 덤프 ( 5) A 검색 ( 6) A 비움")
        println("( 7) B 푸시 ( 8) B 팝 ( 9) B 피크 (10) B 덤프 (11) B 검색 (12) B 비움")
        println("(13) 출력 ( 0) 종료 : ")

        val menu = readln().toInt()
        if (menu == 0) break

        var x :Int?
        when (menu) {
            1 -> { // A에 푸시
                println("데이터 : ")
                x = readln().toInt()
                try {
                    s.push(DoubleHeadIntStack.AorB.StackA, x)
                } catch (e: DoubleHeadIntStack.EmptyDoubleHeadIntStackException) {
                    println("스택이 가득 찼습니다.")
                }
            }
            2 -> { // A에서 팝
                try {
                    x = s.pop(DoubleHeadIntStack.AorB.StackA)
                    println("팝한 데이터는 $x 입니다.")
                } catch (e: DoubleHeadIntStack.EmptyDoubleHeadIntStackException) {
                    println("스택이 비어 있습니다.")
                }
            }
            3 -> { // A에서 피크
                try {
                    x = s.peek(DoubleHeadIntStack.AorB.StackA)
                    println("피크한 데이터는 $x 입니다.")
                } catch (e: DoubleHeadIntStack.EmptyDoubleHeadIntStackException) {
                    println("스택이 비어 있습니다.")
                }
            }
            4 -> s.dump(DoubleHeadIntStack.AorB.StackA) // A를 덤프
            5 -> { // A에서 검색
                println("검색할 데이터 : ")
                x = readln().toInt()
                val n = s.indexOf(DoubleHeadIntStack.AorB.StackA, x)
                if (n >= 0) {
                    println("꼭대기에서 ${s.size(DoubleHeadIntStack.AorB.StackA) - n}번째에 있습니다.")
                } else {
                    println("그 데이터가 없습니다.")
                }
            }
            6 -> s.clear(DoubleHeadIntStack.AorB.StackA) // A를 비움
            7 -> { // B에 푸시
                println("데이터 : ")
                x = readln().toInt()
                try {
                    s.push(DoubleHeadIntStack.AorB.StackB, x)
                } catch (e: DoubleHeadIntStack.OverflowDoubleHeadIntStackException) {
                    println("스택이 가득 찼습니다.")
                }
            }
            8 -> { // B에서 팝
                try {
                    x = s.pop(DoubleHeadIntStack.AorB.StackB)
                    println("팝한 데이터는 $x 입니다.")
                } catch (e: DoubleHeadIntStack.EmptyDoubleHeadIntStackException) {
                    println("스택이 비어 있습니다.")
                }
            }
            9 -> { // B에서 피크
                try {
                    x = s.peek(DoubleHeadIntStack.AorB.StackB)
                    println("피크한 데이터는 $x 입니다.")
                } catch (e: DoubleHeadIntStack.EmptyDoubleHeadIntStackException) {
                    println("스택이 비어 있습니다.")
                }
            }
            10 -> s.dump(DoubleHeadIntStack.AorB.StackB) // B를 덤프
            11 -> { // B에서 검색
                println("검색할 데이터 : ")
                x = readln().toInt()
                val n = s.indexOf(DoubleHeadIntStack.AorB.StackB, x)
                if (n >= 0) {
                    println("꼭대기에서 ${s.size(DoubleHeadIntStack.AorB.StackB) - (s.getCapacity() - n) + 1}번째에 있습니다.")
                } else {
                    println("그 데이터가 없습니다.")
                }
            }
            12 -> s.clear(DoubleHeadIntStack.AorB.StackB) // B를 비움
            13 -> { // 데이터 출력
                println("용량 : ${s.getCapacity()}")
                println("A의 데이터수 : ${s.size(DoubleHeadIntStack.AorB.StackA)}")
                println("B의 데이터수 : ${s.size(DoubleHeadIntStack.AorB.StackB)}")
                println("A는 비어 ${if (s.isEmpty(DoubleHeadIntStack.AorB.StackA)) "있습니다." else "있지 않습니다."}")
                println("B는 비어 ${if (s.isEmpty(DoubleHeadIntStack.AorB.StackB)) "있습니다." else "있지 않습니다."}")
                println("가득 차 ${if (s.isFull()) "있습니다." else "있지 않습니다."}")
            }
        }
    }
}
