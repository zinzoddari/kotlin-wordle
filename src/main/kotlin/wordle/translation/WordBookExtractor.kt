package wordle.translation

import wordle.domain.AnswerWordValidator
import wordle.domain.WordBook
import wordle.io.FileReader

/**
 * 파일로부터 단어장을 추출합니다.
 */
class WordBookExtractor {

    /**
     * [FileReader]를 이용해
     * 파일을 읽어 단어장 객체로 반환합니다.
     *
     * @param fileName 단어장으로 만들기 위한 파일명
     * @return [WordBook] 단어장
     */
    companion object {
        fun extract(fileName: String): WordBook {
            return WordBook.from(AnswerWordValidator(), FileReader.read(fileName))
        }
    }
}

// 파일뿐만 아니라 다른 외부를 통해서 받아올 수도 있지 않을까

// object, companion object 에 대해서...

// WordBook(도메인)를 만드는건 util로 만드는게 맞을지 고민해보기

// getValue()도 제거해보기

//