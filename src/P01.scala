/** P01: Find the last element of a list. */
object P01 {
    /** solution using built-in function. */
    def bia_last_el[A](ls: List[A]): A = ls.last

    /** solution using user defined function. */
    def last_el[T](list: List[T]): T = {
        list match {
            case List(head) => head
            case head::tail => last_el(tail)
            case _          => throw new NoSuchElementException
        }
    }

    val biaList = List(1, 'A', 2.45, 3, 5, List(2, 3), -23, 221)

    def main(args: Array[String]) = {
        if (args.length > 1) {
            println("Application argument not valid!\nPlease, provide only one list element!\nQuitting execution...")
            System.exit(1)
        } else if (args.length == 1) {
            val userList = args(0).stripPrefix("(").stripSuffix(")").split(",").map(_.trim).toList
            println(s"Working with the list you have provided: $userList")
            println("The last element of your list is: " + this.last_el(userList))
        } else {
            assert(this.last_el(biaList) == 221)
            println(s"List argument was not provided. Working with the built in example: $biaList")
            println("The last element of the list is: " + this.bia_last_el(biaList))
        }
    }
}
  
