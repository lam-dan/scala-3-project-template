// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
  test("example test that fails") {
    val obtained = 42
    val expected = 43
    assertEquals(obtained, expected)
  }
  def matchNumbers(numbers: List[Int]): Unit =
    numbers match
      case first :: second :: next => println("2 or more elements")
      case first :: Nil => println("1 element")
      case Nil => println("empty")

  test("show off code completion") {
    val numbers = List(1,2,3,4,5)
    val (even, odd) = numbers.partition(_ % 2 == 0)
    assertEquals(even.size, 2)
    assertEquals(odd.size, 3)

    matchNumbers(numbers)

  }
}












