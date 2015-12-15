/** P03: Find the Kth element of a list. */
import Helper._

object P03 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)

  /** solution using built-in function. */
  def bifKthEl[E](list: List[E], k: Int): E = list.takeRight(list.length - k + 1).head

  /** solution using user defined function. */
  def KthEl[E](list: List[E], k: Int, acc: E): E = {
    k match {
      case 0 => acc
      case _ => { list match {
                  case List()     => throw CustomException("Index is greater than the list length! Not allowed!")
                  case head::tail => KthEl(tail, k-1, head)
                }
      }
    }
  }

  val ExampleList = List(1, 'A', 2.45, 3, 5, List(2, 3), -23, 221)
  val ExampleIndex = 6

  def main(args: Array[String]) = {
    if (args.length != 2) {
      if (args.length != 0) {
        println("Application arguments not valid!\nPlease, provide exactly two arguments: a list and an index!\nQuitting execution...")
        System.exit(1)
      } else {
        println("Arguments were not provided. Working with the built in example:\nList: " + ExampleList.toString().stripPrefix("List") + "; Index: " + ExampleIndex + ";")
        println("The Kth element (K=" + ExampleIndex + ") of the list is: " + bifKthEl(ExampleList, ExampleIndex))
      }
    } else {
      if (!(args(0).startsWith("List(") && args(0).endsWith(")"))) {
        println("Application list argument not valid!\nYour list must start with \"List(\" and end with \")\"!\nQuitting execution...")
        System.exit(1)
      }
      try {
        val dummy = args(1).toInt
      } catch {
          case _: Throwable => {
            println("Index must be an integer!\nQuitting execution...")
            System.exit(1)
          }
      }
      val userIndex = args(1).toInt
      if (userIndex < 1) {
        println("Index must be an integer greater than 0!\nQuitting execution...")
        System.exit(1)
      }
      val userList = parseList(args(0).stripPrefix("List(").stripSuffix(")"), false, false, 0, "", Nil)
      if (userIndex > userList.length) {
        println("Index is greater than the list length! Not allowed!\nQuitting execution...")
        System.exit(1)
      }
      println("Working with the list you have provided: " + userList.toString().stripPrefix("List"))
      println("The Kth element (K=" + userIndex + ") of your list is: " + KthEl(userList, userIndex, Nil))
    }
  }
}
