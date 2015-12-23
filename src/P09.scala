/** P09: Pack consecutive duplicates of list elements into sublists. */
import Helper._

object P09 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)
  
  /** solution using user defined function. */
  def packDuplicates[E](list: List[E], currEl: E, acc: List[E], firstPass: Boolean): List[List[E]] = {
    list match {
      case Nil              => Nil
      case List(head)       => {
          if (head == currEl) List(head::acc)
          else List(acc):::List(List(head))
      }
      case head::tail => {
          if (head == currEl) packDuplicates(tail, currEl, head::acc, false)
          else if (!firstPass) {
              List(acc):::packDuplicates(tail, head, List(head), false)
          } else {
              packDuplicates(tail, head, List(head), false)
          }
      }
      case _                => throw CustomException("Whoooops! Something went wrong!")
    }
  }

  val ExampleList = List(1, 'A', 2.45, 3, 3, 3, 3, 3, 3, 5, 5, List(), List(), List(), List(2, 3), -23, 221, List(2, 3), List(2, 3), 4, 4)

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
      println("Your list with packed duplicates makes: " + packDuplicates(userList, Nil, Nil, true))
    } else {
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString())
      println("The list with packed duplicates makes: " + packDuplicates(ExampleList, Nil, Nil, true))
    }
  }
}
