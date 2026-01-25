package wordle

// TODO: WordExtractor에서 FileReader 의존 끊기
// TODO: 좀 더 명확한 '단어장' 같은 이름으로 변경하기
/**
 * 전체 단어 리스트를 가지고 있으며,
 * 단어를 추출하는 역할을 합니다.
 */
class WordExtractor(
    private val value: List<String>
) {
    /**
     * 전체 단어 리스트의 사이즈를 가져옵니다.
     */
    fun getSize(): Int {
        return value.size
    }

    /**
     * 특정 인덱스의 단어를 가져옵니다.
     */
    fun get(index: Int): Word {
        if (index < 0 || index >= getSize()) {
            throw IllegalArgumentException("Index out of range: $index")
        }

        return Word(value.get(index))
    }

    /**
     * 특정 단어가 존재하는지 여부를 반환합니다.
     */
    fun exists(word: Word): Boolean {
        return value.contains(word.value)
    }

    companion object {
        /**
         * 파일 이름을 이용하여 단어장을 생성합니다.
         */
        fun create(fileName: String): WordExtractor {
            return WordExtractor(FileReader.read(fileName))
        }
    }
}