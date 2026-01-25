package wordle

data class Word(
    val value: String
) {

    fun check(index: Int, char: Char): Boolean {
        val charArray = value.toCharArray()
        require(charArray.size >= index) { "out of index" }
        return charArray[index] == char
    }
}

