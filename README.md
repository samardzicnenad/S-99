# S-99
This repo is my attempt to stay active in Scala programming by solving the 99 problems presented on [**S-99: Ninety-Nine Scala Problems**](http://aperiodic.net/phil/scala/s-99/) page.  
My intentions is to enable users to run all of the examples from the command line in two modes:  
- with themselves providing the arguments in the program call
  - a list should be provided as: **"List(**element_1, element_2, ...., element_n**)"**  
  (if a list is an element of a list, for the inner list drop the quotes)
- by running the program with the built-in arguments  
  
To execute a program do:  
```$ scala Pxx.scala [list of arguments]```  
where xx is the problem's number

Note:
  The solutions have been conceptualized to work with a generic type list. However, command line arguments are read as strings, so I have created a [**Helper object**](src/Helper.scala) with a list parser method. The result of the method will be a list of Strings.  
Make sure that the Helper class in on your classpath.  
  
Here's the list of the problems:  
- P01: Find the last element of a list.
  - expects one command line argument - a list
- P02: Find the last but one element of a list.
  - expects one command line argument - a list
- P03: Find the Kth element of a list.
  - expects two command line arguments - a list and an integer
- P04: Find the number of elements of a list.
  - expects one command line argument - a list
- P05: Reverse a list.
  - expects one command line argument - a list
- P06: Find out whether a list is a palindrome.
  - expects one command line argument - a list
  - Notes:
    - Make sure that the P05 class in on your classpath too
    - Double quotes from your list will be stripped
- P07: Flatten a nested list structure.
  - expects one command line argument - a list
