# Matrix

Synopsis
--------

This program allows the user to input a matrix in row-major order, and then
the program prints the matrix to the screen in a neat and pretty format.
Enter the values of each row with commas in between each element. Enter
one space between each row. Spaces at the very beginning or very end 
of user input will be ignored.

This program will keep asking for user input until the user inputs a matrix
in the correct format. If you manage to break my program or it behaves in an unusual way, please
tell me.

As a challenge, I did not use the split() function to separate the rows or to split the rows into 
their individual elements. So I had to use inner loops to achieve the same result. This lead to
the program being longer that it could have been. 

Please also note that the main reason why this program is so long is because of the extensive 
invalid-input-checking functions, which are used to tell the user specifically why the user input
is invalid. 

Example 1:

Enter Matrix: 1.11,2,33333.4 1,2,3 11.2,33.33,4

1.11 2.33333 4.0
1.00 2.00000 3.0
11.2 33.3300 4.0

Example 2: .1,.22,.3345 1,233.33,444 12.3,44.445,78.9

0.10 0.2200 0.3345
1.00 233.33 444.00
12.3 44.445 78.900

Rules:
1. Do not enter more than one decimal point per number; numbers like ".2" or ".123" are allowed 
2. Two or more spaces may not be next to each other
3. Two or more commas may not be next to each other
4. A comma may not be next to a space
5. All rows must be the same length
6. Only Digits, decimal points, commas, and spaces are allowed in the user input
7. The final character in the user input must be a digit
8. The initial character in the user input must be a decimal point or a digit

Motivation
----------

At first this was supposed to be a java program to write for fun, nothing to complicated. But then I decided to make it more 
challenging by making sure the user input was correct, not using the split() function, and printing
the matrix in an easy-to-read manner. 

Installation
------------

Download the file main.java into an empty directory on your computer.

Commands:

$ javac main.java

$ java main
