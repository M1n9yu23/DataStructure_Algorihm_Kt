package ch03

private data class PhyscData(
    val name: String,
    val height: Int,
    val vision: Double,
) {
    override fun toString(): String = "$name $height $vision"

    companion object {
        // 객체 끼리 어떻게 비교할지 정의 (compare)
        val heightOrder = object : Comparator<PhyscData> {
            override fun compare(o1: PhyscData, o2: PhyscData): Int {
                return when {
                    o1.height > o2.height -> 1
                    o1.height < o2.height -> -1
                    else -> 0
                }
            }
        }
    }
}

fun main() {
    val x = arrayOf(
        PhyscData("강민하", 162, 0.3),
        PhyscData("이수연", 168, 0.4),
        PhyscData("황지안", 169, 0.8),
        PhyscData("유서범", 171, 1.5),
        PhyscData("김찬우", 173, 0.7),
        PhyscData("장경오", 174, 1.2),
        PhyscData("박준서", 175, 2.0)
    )

    print("키가 몇 cm인 사람을 찾고 있나요?: ")

    val height = readln().toInt()
    val idx = x.binarySearch(
        PhyscData("", height, 0.0),
        PhyscData.heightOrder // 객체끼리 이렇게 비교해라 라고 전달
    )

    if(idx < 0) {
        println("그 값의 요소가 없습니다.")
    } else {
        println("그 값은 x[$idx]에 있습니다.")
        println("찾은 데이터: ${x[idx]}")
    }
}