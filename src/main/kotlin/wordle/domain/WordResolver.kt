package wordle.domain

/**
 * 입력 값이 정답과 일치하는지 판단합니다.
 */
class WordResolver(
    private val answer: Word
) {
    private val counter: MutableMap<Char, Int> = init(answer)

    /**
     * 입력된 [word]가 정답과 동일한지 판단합니다.
     *
     * @param input 입력한 단어
     * @return 정답
     */
    fun check(input: Word): Results {
        val result = MutableList(answer.length()) { Result.ABSENT }
        val answerArray = answer.toCharArray()
        val charArray = input.toCharArray()

        // 인덱스와 char가 같은지 판단
        for (it in charArray.indices) {
            val checkValue = answer.check(it, charArray[it])

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

        return Results(result)
    }

    companion object {
        const val BLANK_CHAR: Char = '_'

        /**
         * 정답 단어의 char와 빈도수를 map으로 초기화합니다.
         *
         * @param answer 오늘의 단어 (정답)
         * @return 오늘의 단어의 char, 빈도수의 map
         */
        private fun init(answer: Word): MutableMap<Char, Int> {
            return answer.charCountMap()
        }
    }
}