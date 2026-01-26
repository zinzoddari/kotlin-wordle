package wordle

import kotlin.text.groupBy

data class Word(
    val value: String
) {
    init {
        require(value.trim().isNotBlank()) { "단어는 빈 값일 수 없습니다." }
    }

    /**
     * 입력 된 index의 문자열이 입력된 char와 같은지 확인합니다.
     */
    fun check(index: Int, char: Char): Boolean {
        val charArray = value.toCharArray()
        require(charArray.size > index) { "범위를 벗어났습니다." }
        return charArray[index] == char
    }

    /**
     * 단어의 문자열을 반환합니다.
     */
    fun length(): Int {
        return value.length
    }

    /**
     * 단어를 char 배열로 만들어 반환합니다.
     */
    fun toCharArray(): CharArray {
        return value.toCharArray()
    }

    /**
     * 단어를 char를 기준으로 각 count만큼 만들어 mutableMap으로 반환합니다.
     */
    fun charCountMap(): MutableMap<Char, Int> {
        return value.groupBy { it }
            .mapValues { (_, v) -> v.size }
            .toMutableMap()
    }
}
