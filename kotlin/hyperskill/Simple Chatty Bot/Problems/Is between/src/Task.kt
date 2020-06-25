import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n1 = scanner.nextInt()
    val n2 = scanner.nextInt()
    val n3 = scanner.nextInt()

    println(n1 >= n2 && n1 <= n3 || n1 >= n3 && n1 <= n2)
}