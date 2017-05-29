package search

import com.twitter.finagle.http.Status._
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest


class HelloWorldFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new SearchServer)

  test("Server GET") {
    server.httpGet(
      path = "/hi?name=Bob",
      andExpect = Ok,
      withBody = "Hello Bob")
  }

  test("Server POST") {
    server.httpPost(
      path = "/hi",
      postBody =
        """
          {
            "id": 10,
            "name" : "Sally"
          }
        """,
      andExpect = Ok,
      withBody = "Hello Sally with id 10")
  }
}
