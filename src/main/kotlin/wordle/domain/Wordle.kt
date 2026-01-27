package wordle.domain

/**
 * Wordle 게임 한 판을 의미합니다.
 */
class Wordle(
    private val validator: WordValidator,
    private val todayWord: Word
) {
    /**
     * 입력된 단어의 유효성과 정답을 판단합니다.
     *
     * @param word 입력된 단어
     * @return 정답
     */
    fun round(word: Word): Results {
        validator.validate(word)

        return WordResolver(todayWord).check(word)
    }
}
