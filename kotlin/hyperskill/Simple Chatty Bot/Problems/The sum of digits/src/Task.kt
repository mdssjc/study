import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    println(n / 100 + n / 10 % 10 + n % 10)
}