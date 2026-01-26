package wordle.domain

class WordValidator(
    private val wordBook: WordBook,
    private val maxLength: Int = 5,
    private val wordRegex: Regex = ALPHABET_REGEX
) {
    fun validate(word: Word) {
        require(!word.value.isBlank()
                && word.value.length == maxLength) { "입력값은 ${maxLength}글자여야 합니다." }

        require(wordRegex.matches(word.value)) { "입력값은 영어여야 합니다." }

        require(wordBook.exists(word)) { "입력값은 단어장에 존재하는 단어여야합니다." }
    }

    companion object {
        private val ALPHABET_REGEX = Regex("^[a-zA-Z]*$")
    }
}
