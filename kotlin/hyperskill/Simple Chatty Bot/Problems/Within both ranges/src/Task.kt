import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n1 = scanner.nextInt()
    val n2 = scanner.nextInt()
    val n3 = scanner.nextInt()
    val n4 = scanner.nextInt()
    val n5 = scanner.nextInt()

    val range1 = n1..n2
    val range2 = n3..n4

    println(n5 in range1 && n5 in range2)
}