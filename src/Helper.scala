object Helper {

  /** parse the input list as a string and return a list of strings*/
  def parseList[E](strList: String,
                   inString: Boolean,
                   inSubList: Boolean,
                   subListLevel: Integer,
                   buffer: String,
                   finalList: List[String]): List[String] = {
    /** the parsing ended - return result */
    if (strList.isEmpty && buffer.isEmpty) {
      return finalList
    }
    /** append the last element from the buffer to list */
    if (strList.isEmpty) {
      return parseList("",
                       false,
                       inSubList,
                       subListLevel,
                       "",
                       List.concat(finalList, List(buffer.trim)))
    }
    /** while in quotes ("string mode"), just read */
    if (inString) {
      if (strList(0).toString == "'") {
        /** exit the "string mode" */
        return parseList(strList.substring(1),
                         false,
                         inSubList,
                         subListLevel,
                         buffer + strList(0).toString,
                         finalList)
      } else {
        /** just read */
        return parseList(strList.substring(1),
                         true,
                         inSubList,
                         subListLevel,
                         buffer + strList(0).toString,
                         finalList)
      }
    } else {
      if (strList(0).toString == "'") {
        /** enter the "string mode" */
        return parseList(strList.substring(1),
                         true,
                         inSubList,
                         subListLevel,
                         buffer + strList(0).toString,
                         finalList)
      } else {
        if (strList.startsWith("List(")) {
          /** enter the sublist */
          return parseList(strList.substring(5),
                           false,
                           true,
                           subListLevel + 1,
                           buffer + "List(",
                           finalList)
        } else {
          if (strList(0).toString == ")") {
            /** exit the sublist */
            return parseList(strList.substring(1),
                             false,
                             false,
                             subListLevel - 1,
                             buffer + strList(0).toString,
                             finalList)
          } else if (strList(0).toString == ","){
            if (subListLevel == 0) {
              /** complete an element of the list */
              return parseList(strList.substring(1),
                               false,
                               inSubList,
                               subListLevel,
                               "",
                               List.concat(finalList, List(buffer.trim)))
            } else {
              /** an element of the sublist - disregard" */
              return parseList(strList.substring(1),
                               false,
                               inSubList,
                               subListLevel,
                               buffer + strList(0).toString,
                               finalList)
            }
          } else {
            /** read outside of the "string mode" */
            return parseList(strList.substring(1),
                             false,
                             inSubList,
                             subListLevel,
                             buffer + strList(0).toString,
                             finalList)
          }
        }
      }
    }
  }

}
