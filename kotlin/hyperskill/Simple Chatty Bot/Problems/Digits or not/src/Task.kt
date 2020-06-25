import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val c1 = scanner.next().first()
    val c2 = scanner.next().first()
    val c3 = scanner.next().first()
    val c4 = scanner.next().first()

    print(c1.isDigit())
    print('\\')
    print(c2.isDigit())
    print('\\')
    print(c3.isDigit())
    print('\\')
    print(c4.isDigit())
}