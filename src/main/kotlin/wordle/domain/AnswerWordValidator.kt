package wordle.domain

class AnswerWordValidator(
    private val maxLength: Int = 5,
    private val wordRegex: Regex = ALPHABET_REGEX,
) : WordValidator {
    override fun validate(input: String) {
        require(input.length == maxLength) { "입력값은 ${maxLength}글자여야 합니다." }

        require(wordRegex.matches(input)) { "입력값은 영어여야 합니다." }
    }

    companion object {
        private val ALPHABET_REGEX = Regex("^[a-zA-Z]*$")
    }
}
