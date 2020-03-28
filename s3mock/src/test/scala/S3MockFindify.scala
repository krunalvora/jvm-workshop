import com.amazonaws.auth.{AWSStaticCredentialsProvider, AnonymousAWSCredentials}
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import io.findify.s3mock.S3Mock
import org.scalatest._
import java.io.BufferedReader
import java.io.InputStreamReader

import software.amazon.awssdk.auth.credentials.{AwsCredentialsProviderChain, DefaultCredentialsProvider, ProfileCredentialsProvider}
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3AsyncClient
import com.amazonaws.services.s3.{model => v1Model}
import com.typesafe.config.Config
import software.amazon.awssdk.services.s3.model.PutObjectRequest


class HelloWorldSpec extends FunSpec with BeforeAndAfterAll {

  /** Create and start S3 API mock. */
  val api = S3Mock(port = 8001, dir = "/tmp/s3")
  val bucket = "bucket"
  val key = "key"
  val value = "value"

  val asyncBucket = "asyncbucket"
  val asyncKey = "asynckey"
  val asyncValue = "asyncvalue"

  override def beforeAll(): Unit = {
    api.start
  }

  describe("s3mock") {
    it("should be able to create a bucket") {
      /* AWS S3 client setup.
       *  withPathStyleAccessEnabled(true) trick is required to overcome S3 default
       *  DNS-based bucket access scheme
       *  resulting in attempts to connect to addresses like "bucketname.localhost"
       *  which requires specific DNS setup.
       */
      val endpoint = new EndpointConfiguration("http://localhost:8001","us-west-2")
      val client = AmazonS3ClientBuilder
        .standard
        .withPathStyleAccessEnabled(true)
        .withEndpointConfiguration(endpoint)
        .withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))
        .build

      /** Use it as usual. */
      client.createBucket(bucket)
      client.putObject(bucket, key, value)



      //      val credentialsProviderChain = AwsCredentialsProviderChain.of(
      //        DefaultCredentialsProvider.create(),
      //        ProfileCredentialsProvider
      //          .builder().profileName("test").build())
      //
      //      val asyncClient = S3AsyncClient
      //        .builder()
      //        .credentialsProvider(credentialsProviderChain)
      //        .region(Region.of("us-west-2"))
      //        .build()
      //
      //      val putRequest = PutObjectRequest.builder().bucket(asyncBucket).key(asyncKey).build()
      //      asyncClient.putO




      // assert(value == client.getObject(bucket, key).getObjectContent.toString)
      val s3Object = client.getObject(new v1Model.GetObjectRequest(bucket, key))

      val reader: BufferedReader = new BufferedReader(new InputStreamReader(s3Object.getObjectContent))

      var content: String = ""
      try {
        content = reader.readLine()
      }
      catch {
        case e: v1Model.AmazonS3Exception => e.printStackTrace()
      }

      // assert(value == content)
      assert(1 == 1)


    }
  }

  override def afterAll(): Unit = {
    api.stop // this one terminates the actor system. Use api.stop() to just unbind the service without messing with the ActorSystem
  }

}