package wordle

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WordExtractorTest {

    @Test
    @DisplayName("배열의 크기를 구한다.")
    fun test01() {
        // arrange
        val fileName = "testWord.txt"
        val extractor: WordExtractor = WordExtractor.create(fileName)

        // act
        val sut: Int = extractor.getSize()

        // assert
        assertThat(sut).isEqualTo(2)
    }

    @Nested
    @DisplayName("특정 인덱스의 단어를 가져올 때,")
    inner class test02 {

        @Test
        @DisplayName("인덱스 값이 0보다 작으면, 예외가 발생합니다.")
        fun test01() {
            // arrange
            val fileName: String = "testWord.txt"
            val extractor: WordExtractor = WordExtractor.create(fileName)

            val index: Int = -1

            // act & assert
            assertThatThrownBy { extractor.get(index) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("Index out of range")

        }

        @Test
        @DisplayName("인덱스 값이 전체 단어장 갯수보다 작으면, 예외가 발생합니다.")
        fun test02() {
            // arrange
            val fileName: String = "testWord.txt"
            val extractor: WordExtractor = WordExtractor.create(fileName)

            val index: Int = 30

            // act & assert
            assertThatThrownBy { extractor.get(index) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("Index out of range")
        }

        @Test
        @DisplayName("인덱스에 맞는 단어를 추출한다")
        fun test03() {
            // arrange
            val fileName: String = "testWord.txt"
            val extractor: WordExtractor = WordExtractor.create(fileName)
            val index: Int = 1;

            val expected: Word = Word("devlife")

            // act
            val sut: Word = extractor.get(index)

            // assert
            assertThat(sut).isEqualTo(expected)
        }
    }

    @Test
    @DisplayName("전달받은 단어가 존재하면 true를 반환한다.")
    fun test03() {
        // arrange
        val fileName = "testWord.txt"
        val extractor = WordExtractor.create(fileName)
        val word = Word("devlife")

        // act
        val sut: Boolean = extractor.exists(word)

        // assert
        assertThat(sut).isTrue
    }

    @Test
    @DisplayName("전달받은 단어가 존재하지 않으면 false를 반환한다.")
    fun test04() {
        // arrange
        val fileName = "testWord.txt"
        val extractor = WordExtractor.create(fileName)
        val word = Word("notex")

        // act
        val sut: Boolean = extractor.exists(word)

        // assert
        assertThat(sut).isFalse
    }
}
