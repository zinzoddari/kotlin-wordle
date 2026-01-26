package wordle.domain

data class Word(
    val value: String
) {

    fun check(index: Int, char: Char): Boolean {
        // TODO: Index가 0보다 작은지 확인
        val charArray = value.toCharArray()

        require(charArray.size >= index) { "out of index" }

        return charArray[index] == char
    }
}