import java.time.LocalDateTime

def sout = new StringBuilder(), serr = new StringBuilder()
def proc = './src/test/kotlin/ru/m2/qa/perf/simplegrpcloadtest/build/install/client/bin/hello-world-client'.execute()
proc.consumeProcessOutput(sout, serr)
proc.waitForOrKill(1000)
//println "out> $sout\nerr> $serr"
def dt = LocalDateTime.now()

if(sout) {
    def logFile = new File("src/test/resources/success.txt")
    logFile.append("$dt: success\n")
}
else {
    def logFile2 = new File("src/test/resources/err.txt")
    logFile2.append("$dt: fail\n")
}


