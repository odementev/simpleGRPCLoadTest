def sout = new StringBuilder(), serr = new StringBuilder()
def proc = './src/test/kotlin/qa/simplegrpcloadtest/build/install/client/bin/hello-world-client'.execute()
proc.consumeProcessOutput(sout, serr)
proc.waitForOrKill(1000)

if(sout == null) {
    throw new IOException()
}



