package qa.simplegrpcloadtest.utils

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object ResourceUtils {
    @Throws(IOException::class)
    fun getResource(path: String?): String {
        val classLoader = ResourceUtils::class.java.classLoader
        val inputStream = classLoader.getResourceAsStream(path)
        return readFromInputStream(inputStream)
    }

    @Throws(IOException::class)
    private fun readFromInputStream(inputStream: InputStream): String {
        val resultStringBuilder = StringBuilder()
        BufferedReader(InputStreamReader(inputStream)).use { br ->
            var line: String?
            while (br.readLine().also { line = it } != null) {
                resultStringBuilder.append(line).append("\n")
            }
        }
        return resultStringBuilder.toString()
    }
}