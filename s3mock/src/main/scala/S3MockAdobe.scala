import com.adobe.testing.s3mock.junit5.S3MockExtension
import com.adobe.testing.s3mock.util.HashUtil
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

import software.amazon.awssdk.core.ResponseInputStream
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.http.SdkHttpClient
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.CreateBucketRequest
import software.amazon.awssdk.services.s3.model.GetObjectRequest
import software.amazon.awssdk.services.s3.model.GetObjectResponse
import software.amazon.awssdk.services.s3.model.PutObjectRequest


// @RunWith(classOf[JUnitRunner])
//class S3MockAdobe extends org.scalatest.FunSpec with BeforeAndAfterAll {
//
//  // val s3Mock: S3MockApplication = S3MockApplication.start("--http.port=0")
//  // val httpPort: Int = s3Mock.getHttpPort
//  // println("s3mock http port: " + httpPort)
//
//  // @RegisterExtension val S3_MOCK: S3MockExtension = S3MockExtension.builder.silent.withSecureConnection(false).build
//
//  // val app: S3MockApplication = S3MockApplication.start("--http.port=0")
//
//  @RegisterExtension
//  val S3_MOCK: S3MockExtension = S3MockExtension.builder().silent().withSecureConnection(false).build()
//
//  println(S3_MOCK.getHttpPort)
//  val s3Client: S3Client = S3_MOCK.createS3ClientV2
//
//  describe("S3Mock") {
//    it("Uploaded and downloaded files should have equal hashes") {
//
//      val BUCKET_NAME: String = "mydemotestbucket"
//      val UPLOAD_FILE_NAME: String = "src/test/resources/sampleFile.txt"
//
//      s3Client.createBucket(CreateBucketRequest.builder.bucket(BUCKET_NAME).build)
//
//      val uploadFile: File = new File(UPLOAD_FILE_NAME)
//
//      s3Client.putObject(PutObjectRequest.builder().bucket(BUCKET_NAME).key(uploadFile.getName).build(),
//        RequestBody.fromFile(uploadFile))
//
//      val response: ResponseInputStream[GetObjectResponse] = s3Client.getObject(GetObjectRequest.builder()
//        .bucket(BUCKET_NAME).key(uploadFile.getName).build())
//
//      val uploadFileIs: InputStream = new FileInputStream(uploadFile)
//
//      val uploadHash: String = HashUtil.getDigest(uploadFileIs)
//      val downloadHash: String = HashUtil.getDigest(response)
//
//      uploadFileIs.close()
//      response.close()
//
//      assertEquals(uploadHash, downloadHash)
//    }
//  }
//}

import com.adobe.testing.s3mock.S3MockApplication
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.S3AsyncClient
import software.amazon.awssdk.auth.credentials.{AwsCredentialsProviderChain, DefaultCredentialsProvider, ProfileCredentialsProvider}
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import java.net.URI


object S3MockAdobe extends App {

//  val s3Mock: S3MockApplication = S3MockApplication.start("--http.port=0")
//  val httpPort: Int = s3Mock.getHttpPort
//  println("s3mock http port: " + httpPort)

  val region = Region.US_WEST_2
  val uri = new URI("localhost:9090")
  // val httpClient: SdkHttpClient = new SdkHttpClient()
  val s3 = S3Client.builder().httpClientBuilder().build()
  // val s3 = S3Client.builder().region(region).build()
  // val s3: S3AsyncClient = S3AsyncClient.builder().region(region).build()
  val bucket = "bucket" + System.currentTimeMillis
  println(bucket)

  val createBucketRequest: CreateBucketRequest = CreateBucketRequest
    .builder()
    .bucket(bucket)
    .createBucketConfiguration(CreateBucketConfiguration.builder()
      .locationConstraint(region.id())
      .build())
    .build()

  s3.createBucket(createBucketRequest)




}
