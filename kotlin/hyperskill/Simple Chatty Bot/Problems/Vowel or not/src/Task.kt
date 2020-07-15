import java.util.*

fun isVowel(l: Char): Boolean {
    val test = l.toLowerCase()
    return test == 'a' || test == 'e' || test == 'i' || test == 'o' || test == 'u'
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val letter = scanner.next()[0]

    println(isVowel(letter))
}