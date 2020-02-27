<h1>Collections Analysis Project</h1>
<h6>by shammakh</h6>

<h4> Introduction </h4>

This project is a functional telephone directory simulation that runs and tests the performance of three different 
collection types (Arrays, ArrayLists and HashMaps) and are my attempt to maximize advantages of each collection and 
workaround the drawbacks.

<h4> Keys </h4>

* ArrayDirectory, ArrayListDirectory and HashMapDirectory are implementations of Directory.
* Entry class is to create Entry objects to insert into the directories.
* Input class handles user input and output class handles output for the user and also saving files.
* Score class is the performance analysis class.
* All classes in the 'test' package are classes for unit tests.

<h4> Usage </h4>

The `main.java` class in the source code contains the main method that runs the program.

The program only supports a command line interface. 

When you run the program, you will be prompted with a csv file input request if you already have a csv file with data 
that needs to be inputted and tested.

If you enter an incorrect path, you will be asked if you wish to continue with an empty directory, and if you choose not
to do so, you will have the option start with default test data (data that comes with the program) or the option to enter
the file path again.

***Note:** The program does not allow duplicates so if you input a file, entries with unique surnames and extensions 
will be selected and any subsequent entries will not be inputted.*

Once your have initialized the program, it will ask you to enter commands in the terminal to carry out operations and you can use the `help` keyword to display help.

This program also has some built-in validation for user input.

You can carry out insertion, deletion, modification and lookup operations.

There is also the `test` command which will use synthetic data to test the performance of different directories and give
a result.
***Note:** This may take few moments to complete.*

After the performance test, you get the option to output the results to a path of your choice in csv format.

Finally, you can use the `save` command to save your current session and use `help` command to find out more interactions with the saved session.

***Note:** Only one session can be saved at a time.*

You can also end the program using the `terminate` command. 


<h4> Developer's Note & Reflection </h4>

    The 'test' package contains unit tests and can be run by executing the 'testArrays' file

The project has minimal validation which may cause it to break if improper input is given. It is also not very optimized
for user experience.

If while running the `test` command, the program randomly crashes and the crash isn't consistently replicable, please 
report the error that was found.

This project was built around the interface `Directory.java` which was provided and change was not allowed within it. It
would've been better if all the methods in the interface had some form of return type for method feedback.
