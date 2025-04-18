package ch05

private val flag_a = BooleanArray(8)
private val flag_b = BooleanArray(15)
private val flag_c = BooleanArray(15)

private val pos = IntArray(8)

private fun print() {
    for (i in 0 until 8) {
        print("%2d".format(pos[i]))
    }
    println()
}

private fun set(i: Int) {
    for (j in 0 until 8) {
        if (flag_a[j] == false &&
            flag_b[i + j] == false &&
            flag_c[i - j + 7] == false
        ) {
            pos[i] = j
            if(i == 7) print()
            else {
                flag_a[j] = true
                flag_b[i + j] = true
                flag_c[i - j + 7] = true
                set(i + 1)
                flag_a[j] = false
                flag_b[i + j] = false
                flag_c[i - j + 7] = false
            }
        }
    }
}

fun main() {
    set(0)
}