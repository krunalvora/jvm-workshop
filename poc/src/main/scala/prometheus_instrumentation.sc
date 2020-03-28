import io.prometheus.client.Summary
import io.prometheus.client.exporter.HTTPServer
import com.twitter.util.{Future, Await}


val server: HTTPServer = new HTTPServer(9991)


val latencySecsSummary: Summary = Summary.build()
  .name("latency_seconds")
  .help("Latency seconds duration")
  .labelNames("name")
  .register()


def testSummary(): Unit = {
  try {
    while (true) {
      val timer: Summary.Timer = latencySecsSummary.labels("krunal").startTimer()
      Thread.sleep(5000)
      timer.observeDuration()
    }
  }
  finally {
    server.stop()
  }
}

var asyncTimer: Summary.Timer = _

def asyncTask(name: String): Future[String] = {
  asyncTimer = latencySecsSummary.labels(name).startTimer()
  if (name == "name1") {
    Thread.sleep(5000)
  } else {
    Thread.sleep(3000)
  }
  Future(name)
}

def testSummaryWithFutures(): Unit = {
  while (true) {
    val output1 = asyncTask("name1")
    output1 onSuccess (answer => asyncTimer.observeDuration())
    val output2 = asyncTask("name2")
    output2 onSuccess (answer => asyncTimer.observeDuration())
  }
}

// testSummary()
testSummaryWithFutures()


