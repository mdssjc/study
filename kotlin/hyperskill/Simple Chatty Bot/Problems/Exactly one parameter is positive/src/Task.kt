import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n1 = scanner.nextInt()
    val n2 = scanner.nextInt()
    val n3 = scanner.nextInt()

    println(n1 > 0 && n2 <= 0 && n3 <= 0 ||
            n2 > 0 && n1 <= 0 && n3 <= 0 ||
            n3 > 0 && n1 <= 0 && n2 <= 0)
}