# S-99
This repo is my attempt to stay active in Scala programming by solving the 99 problems presented on [**S-99: Ninety-Nine Scala Problems**](http://aperiodic.net/phil/scala/s-99/) page.  
My intentions is to enable users to run all of the examples in two modes:  
- with themselves providing the arguments in the program call
  - a list should be provided as: **"List(**element_1, element_2, ...., element_n**)"**  
  (if a list is an element of a list, for the inner list drop the quotes)
- by running the program with the built-in arguments  
  
Note:
  The solutions have been conceptualized to work with a generic type list. However, command line arguments are read as strings, so I have created a [**Helper object**](src/Helper.scala) with a list parser method. The result of the method will be a list of Strings.  
  
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
