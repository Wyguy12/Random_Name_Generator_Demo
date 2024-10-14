Random Name Generator App

Project Overview
This project implements a Random Name Generator App that randomly combines first names and last names from text files, sorts them by first name and last name, and displays the results. 
Additionally, the app allows combining names by their first name for grouped output.


NameGeneratorApp Class
This class contains the logic for generating random names, sorting them, and combining them by first name. 
It reads the names from two text files: First-Names.txt and Last-Names.txt.

The class implements the following key methods:
fileLoadFirstNames(): Loads first names from the file into an ArrayList.
fileLoadLastNames(): Loads last names from the file into an ArrayList.
generateRandomNames(): Combines 20 random first and last names to generate full names.
sortNamesByFirstName(): Sorts the generated names alphabetically by first name.
sortNamesByLastName(): Sorts the generated names alphabetically by last name.
combineNamesByFirstName(): Groups names by their first name and displays the full names grouped together.


First-Names.txt and Last-Names.txt
These text files contain a list of first names and last names, respectively. 
The program reads these files to randomly generate full names.