package wordle.io

object Scanner {

    fun input(): String {
        val input = readlnOrNull()?.trim() ?: ""
        // TODO: 예외 메세지 통일 필요
        if (input == "") {
            throw IllegalArgumentException("입력값을 확인해주세요.")
        }
        return input.lowercase()
    }
}