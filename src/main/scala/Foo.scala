import scala.concurrent.Future

object Foo {
    import scala.concurrent.ExecutionContext.Implicits.global
    def addAsync: Future[Int] = Future { 1 + 1 }
}
