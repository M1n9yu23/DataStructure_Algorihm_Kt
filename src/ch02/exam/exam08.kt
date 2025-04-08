package ch02.exam

private class Exam08(var y: Int, var m: Int, var d: Int) {


    companion object {
        val mdays = arrayOf(
            intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31), // 평년
            intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)  // 윤년
        )

        fun isLeap(year: Int) = if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1 else 0
    }

    fun after(n: Int): Exam08 {
        val temp = Exam08(y, m, d)
        if(n < 0) return before(-n)

        temp.d += n

        while(temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1]
            if(++temp.m > 12) {
                temp.y++
                temp.m = 1
            }
        }

        return temp
    }

    fun before(n: Int): Exam08 {
        val temp = Exam08(y, m, d)
        if(n < 0) return after(-n)

        temp.d -= n

        while(temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--
                temp.m = 12
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1]
        }

        return temp
    }
}

fun main() {
    print("날짜를 입력하세요.\n")
    print("년 : ")
    val y = readln().toInt()
    print("월 : ")
    val m = readln().toInt()
    print("일 : ")
    val d = readln().toInt()

    val date = Exam08(y,m,d)

    print("며칠 전/후의 날짜를 구할까요? : ")
    val n = readln().toInt()

    val d1 = date.after(n)
    print("%d일 후의 날짜는 %d년%d월%d일입니다.\n".format(n, d1.y, d1.m, d1.d))

    val d2 = date.before(n)
    print("%d일 전의 날짜는 %d년%d월%d일입니다.\n".format(n, d2.y, d2.m, d2.d))
}