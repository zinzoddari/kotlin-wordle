package wordle.io

import java.io.File

object FileReader {
    fun read(name: String): List<String> {
        val file = readFile(name)
        val list = mutableListOf<String>()
        file.forEachLine {
            list.add(it.trim())
        }
        return list
    }

    private fun readFile(name: String): File {
        val classLoader = javaClass.classLoader
        val resource = classLoader.getResource(name) ?: throw IllegalArgumentException("File does not exist: $name")
        val result = File(resource.file)
        if (!result.exists()) {
            throw IllegalArgumentException("File does not exist: $name")
        }
        return result
    }
}