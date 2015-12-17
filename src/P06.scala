/** P06: Find out whether a list is a palindrome. */
import Helper._
import P05._

object P06 {

  /** solution using built-in function. */
  def bifIsPalindrome[E](list: List[E]): Boolean = list == list.reverse

  /** solution using user defined function. */
  def isPalindrome[E](list: List[E]): Boolean = {
    list == P05.reverse(list, List())
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
      println("The statement: \"The list you have provided is palindrome\" is " + isPalindrome(userList))
    } else {
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString())
      println("The statement: \"The built in example list is palindrome\" is " + bifIsPalindrome(ExampleList))
    }
  }
}
