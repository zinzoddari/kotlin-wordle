package wordle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import wordle.domain.WordBook

class WordExtractorTest {

    @Test
    @DisplayName("파일을 읽어 단어장으로 반환합니다.")
    fun test01() {
        // arrange
        val fileName: String = "testWord.txt"

        // act
        val sut: WordBook = WordExtractor.extract(fileName)

        // assert
        assertThat(sut).isNotNull
    }
}
