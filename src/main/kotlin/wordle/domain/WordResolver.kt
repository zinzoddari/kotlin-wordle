package wordle.domain

// fun <K,V> MutableMap<K,V>.notContainsKey(key: K): Boolean = this.containsKey(key).not()

class WordResolver(
    private val answer: Word
) {
    private val counter: MutableMap<Char, Int> = init(answer)

    fun check(input: Word): Results {
        val result = MutableList(answer.value.length) { Result.ABSENT }
        val answerArray = answer.value.toCharArray()
        val charArray = input.value.toCharArray()

        // 인덱스와 char가 같은지 판단
        for (it in charArray.indices) {
            val checkValue = answer.check(it, charArray[it])

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

        return Results(result)
    }

    companion object {
        private fun init(word: Word): MutableMap<Char, Int> {
            val wordString: String = word.value
            return wordString.groupBy { it }
                .mapValues { (_, v) -> v.size } as MutableMap<Char, Int>
        }
    }
}


