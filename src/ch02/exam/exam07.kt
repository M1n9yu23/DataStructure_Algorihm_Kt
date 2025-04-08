package ch02.exam


class exam07 {
    class PhyscData(
        var name: String,
        var height: Int,
        var vision: Double,
    )

    companion object {
        const val VMAX = 21

        fun aveHeight(dat: Array<PhyscData>): Double {
            var sum = 0.0

            for (i in 0 until dat.size) {
                sum += dat[i].height
            }

            return sum / dat.size
        }

        fun distVision(dat: Array<PhyscData>, dist: IntArray) {
            var i = 0
            dist[i] = 0
            while (i < dat.size) {
                if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
                    dist[(dat[i].vision * 10).toInt()]++
                }
                i++
            }
        }
    }
}

fun main() {
    val x = arrayOf(
        exam07.PhyscData("강민하", 162, 0.3),
        exam07.PhyscData("강수지", 161, 0.3),
        exam07.PhyscData("강하영", 182, 0.3),
        exam07.PhyscData("김찬우", 173, 0.7),
        exam07.PhyscData("박준서", 175, 2.0),
        exam07.PhyscData("유서범", 171, 1.5)
    )

    val vdist = IntArray(exam07.VMAX)

    println("★   신체검사 리스트   ★")
    println("이름       키       시력")
    println("----------------------")

    for(i in 0 until x.size) {
        print("%-8s%3d%5.1f\n".format(x[i].name, x[i].height, x[i].vision))
    }

    print("\n평균 키: %5.1fcm\n".format(exam07.aveHeight(x)))

    exam07.distVision(x, vdist)

    println("\n시력 분포")

    for(i in 0 until  exam07.VMAX) {
        print("%3.1f~: ".format(i / 10.0))
        println("*".repeat(vdist[i]))
    }
}