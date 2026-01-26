package wordle.translation

import wordle.domain.WordBook
import wordle.io.FileReader

object WordBookExtractor {

    fun extract(fileName: String): WordBook {
        return WordBook.from(FileReader.read(fileName))
    }
}