import java.util.*

fun isRightEquation(a: Int, b: Int, c: Int): Boolean {
    return a * b == c
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    println(isRightEquation(a, b, c))
}