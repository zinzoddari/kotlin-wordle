package wordle

import java.io.File

object FileReader {
    fun read(name: String): List<String> {
        require(name.isNotBlank()) { "파일명을 입력해주세요." }

        return readFile(name).readLines()
            .map { it.trim() }
            .toList()
    }

    private fun readFile(name: String): File {
        val classLoader = javaClass.classLoader
        val resource = requireNotNull(classLoader.getResource(name)) {
            NOT_EXIST_MESSAGE
        }

        return exists(File(resource.file))
    }

    private fun exists(file: File): File {
        require(file.exists()) {
            NOT_EXIST_MESSAGE
        }

        return file
    }

    const val NOT_EXIST_MESSAGE = "파일이 존재하지 않습니다."
}
