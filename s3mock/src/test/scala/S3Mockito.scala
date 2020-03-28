import java.io.{BufferedReader, InputStreamReader}

import org.scalatest.FunSpec
import org.scalatestplus.mockito.MockitoSugar
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.{AmazonS3Exception, GetObjectRequest, PutObjectResult}
import org.mockito.Mockito._

class S3Mockito extends FunSpec with MockitoSugar {
  val s3Client = mock[AmazonS3]

  val maxFileSize: Int = 100

  describe("Mockito S3") {
    it("should create a bucket and put an object in there") {

      val bucket = "bucket1"
      val key = "key1"
      val value = "value1"

      when(s3Client.putObject("bucket", "key", "value")).thenReturn(new PutObjectResult)
      // s3Client.createBucket("bucket")
      val putObject = s3Client.putObject("bucket", "key", "value")

      println(putObject)

      val result = s3Client.getObject("bucket", "key")
      // println(result.getExpirationTimeRuleId)
      println(result + "***")

      // verify(s3Client).putObject("bucket", "key", "value")
    }
  }

}
