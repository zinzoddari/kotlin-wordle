package wordle

class WordResolver(
    private val word: Word,
    private val counter: MutableMap<Char, Int> = init(word)
) {

    fun check(input: Word): List<Result> {
        val result = MutableList(word.length()) { Result.ABSENT }
        val answerArray = word.toCharArray()
        val charArray = input.toCharArray()

        // 인덱스와 char가 같은지 판단
        for (it in charArray.indices) {
            val checkValue = word.check(it, charArray[it])

            // result 같으면, word count 차감 및 결과 반환
            if (checkValue) {
                result[it] = Result.CORRECT
                answerArray[it] = BLANK_CHAR
                counter[charArray[it]] = counter.getValue(charArray[it]) - 1
            }
        }

        // 다른 인덱스에도 해당 문자열이 있는지 판단
        for (it in charArray.indices) {
            if (answerArray[it] == BLANK_CHAR) {
                continue
            }

            // 아예 문자열이 존재하지 않을 때
            if (!counter.containsKey(charArray[it])) {
                continue
            }

            if (counter.getValue(charArray[it]) == 0) {
                continue
            }

            // 존재할 때
            counter[charArray[it]] = counter.getValue(charArray[it]) - 1
            result[it] = Result.PRESENT
        }

        return result
    }

    companion object {
        const val BLANK_CHAR: Char = '_'

        private fun init(word: Word): MutableMap<Char, Int> {
            return word.charCountMap()
        }
    }
}
