package ch01

private fun med3(a: Int, b: Int, c: Int): Int{
    return if(a >= b) {
        if(b >= c) {
            b
        } else if(a <= c) {
            a
        } else {
            c
        }
    } else if(a > c) {
        a
    } else if(b > c) {
        c
    } else {
        b
    }
}
