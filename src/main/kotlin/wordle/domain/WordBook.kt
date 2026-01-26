package wordle.domain

@JvmInline
value class WordBook(
    private val values: List<Word>
) {
    fun getSize(): Int {
        return values.size
    }

    @Throws(IllegalAccessException::class)
    fun get(index: Int): Word {
        if (index < 0 || index >= getSize()) {
            throw IllegalArgumentException("Index out of range: $index")
        }

        return values[index]
    }


    fun exists(word: Word): Boolean {
        return values.contains(word)
    }

    companion object {
        fun from(words: List<String>): WordBook {
            return WordBook(words.map { Word(it)})
        }
    }
}