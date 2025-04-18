package ch05

private val flag = BooleanArray(8)
private val pos = IntArray(8)


private fun print(){
    for(i in 0 until 8) {
        print("%2d".format(pos[i]))
    }
    println()
}

private fun set(i: Int) {
    for(j in 0 until 8) {
        if(flag[j] == false) {
            pos[i] = j
            if( i == 7) {
                print()
            } else {
                flag[j] = true
                set(i + 1)
                flag[j] = false
            }
        }
    }
}


fun main() {
    set(0)
}