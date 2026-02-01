package wordle.domain

/**
 * 입력된 단어의 유효성 체크하는 검증기
 */
class WordValidator(
    private val wordBook: WordBook,
    private val maxLength: Int = 5,
    private val wordRegex: Regex = ALPHABET_REGEX
) {
    /**
     * 유효성 검증을 합니다.
     * - [maxLength] 글자가 맞는지 확인합니다.
     */
    fun validate(input: String) {
        require(input.length == maxLength) { "입력값은 ${maxLength}글자여야 합니다." }

        require(wordRegex.matches(input)) { "입력값은 영어여야 합니다." }

        require(wordBook.exists(input)) { "입력값은 단어장에 존재하는 단어여야합니다." }
    }

    companion object {
        private val ALPHABET_REGEX = Regex("^[a-zA-Z]*$")
    }
}
