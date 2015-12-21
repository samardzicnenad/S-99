/** P07: Flatten a nested list structure. */
import Helper._

object P07 {

  /** defined the custom exception case class */
  case class CustomException(msg: String) extends Exception(msg)

  /** A solution using built-in function isn't possible since it's not known if 
      List[E] is a traversable collection, which is what flatten expects */
  
  /** transform ExampleList to a list of Strings */
  def transform[E](list: List[E]): List[String] = parseList(list.mkString(", "),
                                                            false,
                                                            false,
                                                            0,
                                                            "",
                                                            Nil)

  /** solution using user defined function. */
  def flattenList(list: List[String], acc: List[String]): List[String] = {
    list match {
      case Nil        => acc
      case List(head) => {
          if (head.startsWith("List(")) {
            flattenList(parseList(List(head).mkString(", ").stripPrefix("List(").stripSuffix(")"),
                                  false,
                                  false,
                                  0,
                                  "",
                                  Nil),
                        Nil)              
            } else {
                List(head)
            }
        }
      case head::tail => flattenList(List(head), List()):::flattenList(tail, List())
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
      println("Your list flattened makes: " + flattenList(userList, Nil))
    } else {
      println("List argument was not provided. Working with the built in example: " + ExampleList.toString())
      println("The list flattened makes: " + flattenList(transform(ExampleList), Nil))
    }
  }
}
