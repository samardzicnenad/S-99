/** P01: Find the last element of a list. */
import Helper._

object P01 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)

  /** solution using built-in function. */
  def bifLastEl[E](list: List[E]): E = {
    list match {
      case Nil => throw CustomException("Empty list! Not allowed!")
      case _   => list.last
    }
  }

  /** solution using user defined function. */
  def lastEl[E](list: List[E]): E = {
    list match {
      case Nil        => throw CustomException("Empty list! Not allowed!")
      case List(head) => head
      case head::tail => lastEl(tail)
      case _          => throw CustomException("Whoooops! Something went wrong!")
    }
  }

  val ExampleList = List(1, 'A', 2.45, 3, 5, List(2, 3), -23, 221)

  def main(args: Array[String]) = {
    if (args.length > 1) {
      println("Application arguments not valid!\nPlease, provide only one list element!\nQuitting execution...")
      System.exit(1)
    } else if (args.length == 1) {
      if (!(args(0).startsWith("List(") && args(0).endsWith(")"))) {
        println("Application argument not valid!\nYour list must start with \"List(\" and end with \")\"!\nQuitting execution...")
        System.exit(1)
      }
      val userList = parseList(args(0).stripPrefix("List(").stripSuffix(")"), false, false, 0, "", Nil)
      println("Working with the list you have provided: " + userList.toString())
      println("The last element of your list is: " + lastEl(userList))
    } else {
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString())
      println("The last element of the list is: " + bifLastEl(ExampleList))
    }
  }
}
