import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def sout = new StringBuilder(), serr = new StringBuilder()
def proc = './src/test/kotlin/qa/simplegrpcloadtest/build/install/client/bin/hello-world-client'.execute()
proc.consumeProcessOutput(sout, serr)
proc.waitForOrKill(1000)

def dt = LocalDateTime.now()
def formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
dt = dt.format(formatter)
if(sout) {
    def logFile = new File("src/test/resources/success.txt")
    logFile.append("$dt,success\n")
}
else {
    def logFile2 = new File("src/test/resources/err.txt")
    logFile2.append("$dt,fail\n")
    throw new IOException()
}


