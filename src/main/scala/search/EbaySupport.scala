package search

trait EbaySupport {

  import java.util.Base64

  /**
    * Calculates BASE64 credentials for accessing eBay API endpoints.
    *
    * {{{
    * >>> val username    = "username"
    * >>> val password    = "password"
    * >>> val credentials = "dXNlcm5hbWU6cGFzc3dvcmQ="
    * >>> val o = new Object with EbaySupport
    * >>> credentials == o.makeCredentials(username, password)
    * true
    * }}}
    */
  def makeCredentials(username: String, password: String): String =
    Base64.getEncoder.encodeToString(s"${username}:${password}".getBytes)


  /**
    * Returns an HTTP body for retrieving client_credentials from eBay API endpoint.
    *
    * {{{
    * >>> val name     = "myapp"
    * >>> val expected = "grant_type=client_credentials&redirect_uri=myapp&scope=https://api.ebay.com/oauth/api_scope"
    * >>> val o        = new Object with EbaySupport
    * >>> expected == o.makeOAuthBody(name)
    * true
    * }}}
    */
  def makeOAuthBody(name: String): String =
    s"grant_type=client_credentials&redirect_uri=${name}&scope=https://api.ebay.com/oauth/api_scope"


  /**
    * Returns an HTTP header for retrieving client_credentials from eBay API endpoint.
    *
    * {{{
    * >>> val host        = "api.sandbox.ebay.com"
    * >>> val path        = "/identity/v1/oauth2/token"
    * >>> val username    = "username"
    * >>> val password    = "password"
    * >>> val application = "myapp"
    * >>> val o           = new Object with EbaySupport
    * >>> val credentials = o.makeCredentials(username, password)
    * >>> val agent       = "curl/7.52.1"
    * >>> val body        = o.makeOAuthBody(application)
    * >>> val expected    = "POST /identity/v1/oauth2/token HTTP/1.1\r\nHost: api.sandbox.ebay.com\r\nUser-Agent: curl/7.52.1\r\nContent-Type: application/x-www-form-urlencoded\r\nAuthorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=\r\nContent-Length: 91\r\n\r\n"
    * >>> val actual      = o.makeOAuthHeader(host, path, credentials, agent, body)
    * >>> expected == actual
    * true
    * }}}
    */
  def makeOAuthHeader(host: String, path: String, credentials: String, agent: String, body: String): String =
    s"""POST ${path} HTTP/1.1\r
       |Host: ${host}\r
       |User-Agent: ${agent}\r
       |Content-Type: application/x-www-form-urlencoded\r
       |Authorization: Basic ${credentials}\r
       |Content-Length: ${body.length}\r
       |\r
       |""".stripMargin

}

