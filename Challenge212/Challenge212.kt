import kotlin.jvm.internal.iterator

fun isSwedishVowel(c : Char): Boolean {
    when(c.toUpperCase()){
        'A', 'E', 'I', 'O', 'U', 'Å', 'Ä', 'Ö' -> return true
        else -> return false
    }
}

fun main(args: Array<String>){
    val input = readLine() ?: ""
    var output = ""

    for(c : Char in input.asIterable()){
        if(!isSwedishVowel(c) && c.isLetter()){
            output += c + 'o'.toString() + c.toLowerCase()
        } else {
            output += c
        }
    }

    println("${output}")
}
