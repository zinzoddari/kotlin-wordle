package wordle

import wordle.domain.WordBook
import wordle.io.FileReader

// TODO: WordExtractor에서 FileReader 의존 끊기
// TODO: 좀 더 명확한 '단어장' 같은 이름으로 변경하기
/**
 * 전체 단어 리스트를 가지고 있으며,
 * 단어를 추출하는 역할을 합니다.
 */
object WordExtractor {

    fun extract(fileName: String): WordBook {
        return WordBook.from(FileReader.read(fileName))
    }
}
