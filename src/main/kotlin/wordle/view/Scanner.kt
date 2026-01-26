package wordle.view

object Scanner {

    fun input(): String {
        val input = readLine()?.trim() ?: ""

        require(input != "" && input.trim().isNotBlank()) { "입력값을 확인해주세요." }

        return input.lowercase()
    }
}
