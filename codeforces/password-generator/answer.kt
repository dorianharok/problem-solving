import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.text.html.HTML.Attribute.N

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        println(generatePassword(a, b, c))
    }
}

fun generatePassword(digits: Int, uppercase: Int, lowercase: Int): String {
    val result = StringBuilder()

    repeat(digits) { result.append((it % 10).toString()) }
    repeat(uppercase) { result.append(('A' + it % 26)) }
    repeat(lowercase) { result.append(('a' + it % 26)) }

    return result.toString()
}