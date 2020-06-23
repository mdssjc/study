import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    print(n % 10)
    print(n / 10 % 10)
    print(n / 100)
}