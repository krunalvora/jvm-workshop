import com.twitter.util.{Future, Await}


def asyncTask(a: Int): Future[Int] = {
  Thread.sleep(3000)
  Future(a + a)
}

asyncTask(2) onSuccess(answer => println(answer))

Thread.sleep(2000)

