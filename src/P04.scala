/** P04 (*) Find the number of elements of a list. */
import Helper._

object P04 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)

  /** solution using built-in function. */
  def bifLength[E](list: List[E]): Int = list.length

  /** solution using user defined function. */
  def length[E](list: List[E], acc: Int): Int = {
    list match {
      case List()     => 0
      case List(head) => acc + 1
      case head::tail => length(tail, acc + 1)
      case _          => throw CustomException("Whoooops! Something went wrong!")
    }
  }

  val ExampleList = List(1, 'A', 2.45, 3, 5, List(2, 3), -23, 221)

  def main(args: Array[String]) = {
    if (args.length > 1) {
      println("Application argument not valid!\nPlease, provide only one list element!\nQuitting execution...")
      System.exit(1)
    } else if (args.length == 1) {
      if (!(args(0).startsWith("List(") && args(0).endsWith(")"))) {
        println("Application argument not valid!\nYour list must start with \"List(\" and end with \")\"!\nQuitting execution...")
        System.exit(1)
      }
      val userList = parseList(args(0).stripPrefix("List(").stripSuffix(")"), false, false, 0, "", Nil)
      println("Working with the list you have provided: " + userList.toString())
      println("The length of your list is: " + length(userList, 0))
    } else {
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString())
      println("The length of the list is: " + bifLength(ExampleList))
    }
  }
}
