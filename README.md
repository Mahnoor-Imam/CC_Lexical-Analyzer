# CC Lexical Analyzer

The attached project is the first step of simple compiler construction, that generates tokens after lexical analysis of a simple custom language.

## About .cc Language

A new yet simple custom made language is taken as an example which uses constructs from some of the most popular languages in use today. The task is to develop a lexical analyzer for this language.  
A brief description of the main features of this language is as follow:

1. **Data types:** int, char
2. **Keywords:**  
    • **Decision statement:** if, elif, else  
    • **Looping statement:** while  
    • **Standart input statement:** input  
    • **Standard output statement:** print (print and remain on same line), println (print and move to next line)  
3. **Arithmetic operators:** + - * /
4. **Relational operators:** < <= > >= == ~=
5. **Comments:**  
    • **Single line comment:** // comment  
    • **Multi  line comment:** /* comment */
6. **Identifier:** a letter followed by any number of letters, digits or the underscore symbol
7. **Numeric constants:** only integers
8. **Literal constants:** only a single letter enclosed in single quotes
9. **Strings:** sequence of characters and white spaces enclosed in double quotes
10. **Parenthesis, Braces, Square Brackets**
11. **Assignment Operator:** =
12. **Input Operators:** ->
13. **Semi-Colon, Colon, Comma**

### Sample Code

``` 
int: num;
char: my_char;
// lets assign variable my_char a value
my_char = 'd';
print("my char contains: ");
println(my_char);
/*
The program here onwards is an iterative algorithm
for fibonacci numbers
*/
println("enter a number");
input -> num;
int: a = 0, b=1, c=0;
println("The fibonacci seq is: ");
println(a);
println(b);
while c <= num:
{
int: temp = a+b;
a = b;
b = temp;
println(temp);
c++;
}
```

## Getting Started

The Lexer will take a text file containing source code ```sample_code.cc``` as input, read it line by line, and will generate a text file ```tokens.txt``` that contains token-lexeme pairs encountered in the given .cc file. The program requires file path with (.cc) as file extention to be given as argument to main. The Lexer also prints appropriate and helpful errors when incorrect programs are provided to it.
It writes the tokens in ```tokens.txt``` and formats the output by printing a line of code followed by its tokens for better readability on the console as well as in another file ```readable_tokens.txt```. It implements the following DFA:<br><br>

<img width="1000" alt="DFA_complete_2" src="https://user-images.githubusercontent.com/60784823/138566919-74cc135e-dc2e-4515-98c7-762b10734525.PNG">

The following are some test cases and sample output of the code:

#### Wrong Input

sample_code.cc  | Output
-------------   | -------------
while c <= num:<br>{<br>int: temp = a+b;<br>a = b;<br>b = temp;<br>println("temp);<br>c++;<br>}    | String not enclosed properly at line 6<br>6    println("temp);<br>Check your code file and try again!

#### Correct Input

sample_code.cc  | Output
-------------   | -------------
while c <= num:<br>{<br>int: temp = a+b;<br>a = b;<br>b = temp;<br>println(temp);<br>c++;<br>}  | Execution successful! Check the generated tokens in tokens.txt

#### Output of Program

sample_code.cc  | tokens.txt | Console
-------------   | ------------- | -------------
// small fibonacci example<br>println("The fibonacci seq is: ");<br>println(a);<br>println(b);<br>while c <= num:<br>{<br>int: temp = a+b;<br>a = b;<br>b = temp;<br>println(temp);<br>c++;<br>}  | (S_COMMENT,// small fibonacci example)<br>(PRINTLN,^)<br>('(',^)<br>(STR,"The fibonacci seq is: ")<br>(')',^)<br>(';',^)<br>(PRINTLN,^)<br>('(',^)<br>(ID,a)<br>(')',^)<br>(';',^)<br>(PRINTLN,^)<br>('(',^)<br>(ID,b)<br>(')',^)<br>(';',^)<br>(WHILE,^)<br>(ID,c)<br>(REL_OP,LE)<br>(ID,num)<br>(':',^)<br>('{',^)<br>(INT,^)<br>(':',^)<br>(ID,temp)<br>('=',^)<br>(ID,a)<br>('+',^)<br>(ID,b)<br>(';',^)<br>(ID,a)<br>('=',^)<br>(ID,b)<br>(';',^)<br>(ID,b)<br>('=',^)<br>(ID,temp)<br>(';',^)<br>(PRINTLN,^)<br>('(',^)<br>(ID,temp)<br>(')',^)<br>(';',^)<br>(ID,c)<br>('+',^)<br>('+',^)<br>(';',^)<br>('}',^) | 1	// small fibonacci example<br>     (S_COMMENT,// small fibonacci example)<br>2	println("The fibonacci seq is: ");<br>     (PRINTLN,^)<br>('(',^)<br>	(STR,"The fibonacci seq is: ")<br>	(')',^)<br>	(';',^)<br>3	println(a);<br>	(PRINTLN,^)<br>	('(',^)<br>	(ID,a)<br>	(')',^)<br>	(';',^)<br>4	println(b);<br>	(PRINTLN,^)<br>	('(',^)<br>	(ID,b)<br>	(')',^)<br>	(';',^)<br>5	while c <= num:<br>	(WHILE,^)<br>	(ID,c)<br>	(REL_OP,LE)<br>	(ID,num)<br>	(':',^)<br>6	{<br>	('{',^)<br>7	int: temp = a+b;<br>	(INT,^)<br>	(':',^)<br>	(ID,temp)<br>	('=',^)<br>	(ID,a)<br>	('+',^)<br>	(ID,b)<br>	(';',^)<br>8	a = b;<br>	(ID,a)<br>('=',^)<br>(ID,b)<br>(';',^)<br>9	b = temp;<br>(ID,b)<br>('=',^)<br>(ID,temp)<br>(';',^)<br>10	println(temp);<br>(PRINTLN,^)<br>('(',^)<br>(ID,temp)<br>(')',^)<br>(';',^)<br>11	c++;<br>(ID,c)<br>('+',^)<br>('+',^)<br>(';',^)<br>12	}<br>('}',^)<br><br>Execution successful! Check the generated tokens in tokens.txt

### Before you Start

This program is made and tested in **java version 14 2020-03-17**. So, you should have **Java JDK 14** installed on your system.

## How to Build and Run

In src folder, enter the following command to compile the code. A binary called Lexer.class will be produced.  
```javac lexer/Lexer.java```

To run this file, enter the following in src folder:  
```java lexer.Lexer sample_code.cc```




