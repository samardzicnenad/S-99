/** P02: Find the last but one element of a list. */
object P02 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)

  /** solution using built-in function. */
  def bifNextToLast[E](list: List[E]): E = {
    list match {
      case Nil         => throw new CustomException("Empty list! Not allowed!")
      case head :: Nil => throw new CustomException("List has only one element! Not allowed!")
      case _           => list.init.last
    }
  }

  /** solution using user defined function. */
  def nextToLast[E](list: List[E]): E = {
    list match {
      case Nil              => throw new CustomException("Empty list! Not allowed!")
      case head :: Nil      => throw new CustomException("List has only one element! Not allowed!")
      case head :: _ :: Nil => head
      case _::tail          => nextToLast(tail)
      case _                => throw new CustomException("Whoooops! Something went wrong!")
    }
  }

  val ExampleList = List(1, 'A', 2.45, 3, 5, List(2, 3), -23, 221)

  def main(args: Array[String]) = {
    if (args.length > 1) {
      println("Application argument not valid!\nPlease, provide only one list element!\nQuitting execution...")
      System.exit(1)
    } else if (args.length == 1) {
      val userList = args(0).stripPrefix("(").stripSuffix(")").split(",").map(_.trim).toList
      println("Working with the list you have provided: " + userList.toString().stripPrefix("List"))
      println("The next to the last element of your list is: " + this.nextToLast(userList))
    } else {
      try {
        assert(this.bifNextToLast(ExampleList) == -23)
      } catch {
        case _: AssertionError => throw new CustomException("Built in assertion failed!")
      }
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString().stripPrefix("List"))
      println("The next to the last element of the list is: " + this.bifNextToLast(ExampleList))
    }
  }
}