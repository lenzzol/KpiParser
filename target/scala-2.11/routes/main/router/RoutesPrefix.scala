
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/lenzzolalvarez/Documents/code/github/KpiParser/conf/routes
// @DATE:Wed May 17 00:27:50 EDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
