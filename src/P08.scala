/** P08: Eliminate consecutive duplicates of list elements. */
import Helper._

object P08 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)
  
  /** solution using user defined function. */
  def eliminateDuplicates[E](list: List[E]): List[E] = {
    list match {
      case Nil              => Nil
      case List(head)       => List(head)
      case head::neck::tail => {
          if (head == neck) eliminateDuplicates(neck::tail)
          else              List(head):::eliminateDuplicates(neck::tail)
      }
      case _                => throw CustomException("Whoooops! Something went wrong!")
    }
  }

  val ExampleList = List(1, 'A', 2.45, 3, 3, 3, 3, 3, 3, 5, 5, List(2, 3), -23, 221, List(2, 3), List(2, 3))

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
      println("Your list with duplicates eliminated makes: " + eliminateDuplicates(userList))
    } else {
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString())
      println("The list with duplicates eliminated makes: " + eliminateDuplicates(ExampleList))
    }
  }
}
