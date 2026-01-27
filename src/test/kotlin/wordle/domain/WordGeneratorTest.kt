package wordle.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import wordle.translation.WordBookExtractor
import java.time.LocalDate

class WordGeneratorTest {
    val fileName: String = "testWord.txt"
    val wordExtractor = WordBookExtractor.extract(fileName)

    @Test
    @DisplayName("오늘의 단어를 반환합니다.")
    fun test01() {
        // arrange
        val wordGenerator = WordGenerator(wordExtractor)
        val today: LocalDate = LocalDate.of(2021, 6, 19)
        val expected = Word("zin")

        // act
        val sut: Word = wordGenerator.generateAnswer(today)

        // assert
        Assertions.assertThat(sut).isEqualTo(expected)
    }
}