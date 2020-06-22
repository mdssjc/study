import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val c1 = scanner.nextInt()
    val c2 = scanner.nextInt()
    val c3 = scanner.nextInt()

    println(c1 / 2 + c1 % 2 + c2 / 2 + c2 % 2 + c3 / 2 + c3 % 2)
}