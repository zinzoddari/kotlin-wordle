package wordle.translation

import wordle.domain.WordBook
import wordle.io.FileReader

class WordBookExtractor {
    companion object {
        fun create(fileName: String): WordBook {
            return WordBook.from(FileReader.read(fileName))
        }
    }
}