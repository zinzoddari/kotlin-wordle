package wordle

class WordResolver(
    private val word: Word,
    private val counter: MutableMap<Char, Int> = init(word)
) {

    fun check(input: Word): List<Result> {
        val result = MutableList(word.value.length) { Result.ABSENT }
        val answerArray = word.value.toCharArray()
        val charArray = input.value.toCharArray()

        // 인덱스와 char가 같은지 판단
        for (it in charArray.indices) {
            val checkValue = word.check(it, charArray[it])

            // result 같으면, word count 차감 및 결과 반환
            if (checkValue) {
                result[it] = Result.CORRECT
                answerArray[it] = '_'
                counter[charArray[it]] = counter.getValue(charArray[it]) - 1
            }
        }

        // 다른 인덱스에도 해당 문자열이 있는지 판단
        for (it in charArray.indices) {
            if (answerArray[it] == '_') {
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
        private fun init(word: Word): MutableMap<Char, Int> {
            val wordString: String = word.value
            return wordString.groupBy { it }
                .mapValues { (_, v) -> v.size } as MutableMap<Char, Int>
        }
    }
}
