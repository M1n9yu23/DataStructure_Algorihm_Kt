package ch06

data class PhyscData(
    val name: String,
    val height: Int,
    val vision: Double
)

fun main() {
    val x = arrayOf(
        PhyscData("강민하", 162, 0.3),
        PhyscData("김찬우", 173, 0.7),
        PhyscData("박준서", 175, 2.0),
        PhyscData("유서범", 171, 1.5),
        PhyscData("이수연", 168, 0.4),
        PhyscData("장경오", 174, 1.2),
        PhyscData("황지안", 169, 0.8)
    )

    // 키 기준 오름차순 정렬
    x.sortBy {
        it.height
    }
    // 자바는 Comparator를 구현해서 키 기준으로 정렬 하게 해줘야하지만 코틀린에서는 람다로 간단하게 가능

    println("■ 신체검사 리스트 ■")
    println(" 이름     키    시력")
    println("---------------------")
    for (data in x) {
        // 출력 형식 맞추기
        println("%-8s%3d%5.1f".format(data.name, data.height, data.vision))
    }
}