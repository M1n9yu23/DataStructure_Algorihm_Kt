package ch02


private class PhysicalExamination {

    class PhyscData(
        var name: String,
        var height: Int,
        var vision: Double,
    )

    companion object {
        const val VMAX = 21

        fun aveHeight(dat: Array<PhyscData>) : Double {
            var sum = 0.0

            for(i in 0 until dat.size) {
                sum += dat[i].height
            }

            return sum / dat.size
        }

        fun distVision(dat: Array<PhyscData>, dist: IntArray) {
            var i = 0
            dist[i] = 0
            while(i < dat.size) {
                if(dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
                    dist[(dat[i].vision * 10).toInt()]++
                }
                i++
            }
        }
    }
}

fun main() {
    val x = arrayOf(
        PhysicalExamination.PhyscData("강민하", 162, 0.3),
        PhysicalExamination.PhyscData("김찬우", 173, 0.7),
        PhysicalExamination.PhyscData("박준서", 175, 2.0),
        PhysicalExamination.PhyscData("유서범", 171, 1.5)
    )

    val vdist = IntArray(PhysicalExamination.VMAX)

    println("★   신체검사 리스트   ★")
    println("이름       키       시력")
    println("----------------------")

    for(i in 0 until x.size) {
        print("%-8s%3d%5.1f\n".format(x[i].name, x[i].height, x[i].vision))
    }

    print("\n평균 키: %5.1fcm\n".format(PhysicalExamination.aveHeight(x)))

    PhysicalExamination.distVision(x, vdist)

    println("\n시력 분포")

    for(i in 0 until  PhysicalExamination.VMAX) {
        print("%3.1f~: %2d명\n".format(i / 10.0, vdist[i]))
    }
}