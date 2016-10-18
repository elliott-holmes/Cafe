# Elliotts Cafe Order - Developed by Elliott Holmes

This project will allow you to generate a runnable JAR file as no environment was specified. 
It would be better developed as a web application to allow more functionality to be implemented (tracking sales etc.)

## Download

You can download this project using standard git into eclipse. This will give you the full application

##Build

To build the project you need to run a Maven Build with additional "Clean Install" goals. This should generate a runnable JAR file.

##Access

Once the JAR file is created, you can just run it through a command line using java -jar <path - to - jar> where hopefully 
the on-screen prompts will indicate what to do next

I have tested the build and run using Eclipse JEE Neon.

Hopefully all should work ok, but if there are any build issues, please let me know via your normal contact channel and i'll get it sorted asap

Happy Cafe'ing

##Futures

An orderId field and a removeMenuItem method were created but have not been implemented as yet. 
This would potentially allow for all orders to be tracked and monitored, and would also allow for 
mistaken order items to be removed without starting a new order, however this was not part of the 
story requirements so I resisted the temptation.
