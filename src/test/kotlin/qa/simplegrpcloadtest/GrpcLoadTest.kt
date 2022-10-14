package qa.simplegrpcloadtest

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import qa.simplegrpcloadtest.utils.ResourceUtils.getResource
import us.abstracta.jmeter.javadsl.JmeterDsl.*
import java.io.IOException
import java.time.Duration

class GrpcLoadTest {
    @Test
    @Throws(IOException::class)
    fun testPerformance() {
        val stats = testPlan(
            rpsThreadGroup()
                .rampTo(10.0, Duration.ofMinutes(20))
                .children(
                    jsr223Sampler(getResource("shell.groovy"))
                )
        ).run()
        Assertions.assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5))
    }
}