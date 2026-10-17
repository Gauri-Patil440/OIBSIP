# Number Guessing Game

## Project Overview
The Number Guessing Game is a simple Java console-based application developed as Task 1 for the Oasis Infobyte (OIBSIP) Java Development Internship.

The program generates a random number between 1 and 100. The user must guess the number, and the game provides hints until the correct number is guessed.

## Features
- Generates a random number between 1 and 100.
- Accepts user input using the Scanner class.
- Displays "Too low" when the guess is smaller than the secret number.
- Displays "Too high" when the guess is greater than the secret number.
- Counts the total number of attempts.
- Displays a success message when the correct number is guessed.

## Technologies Used
- Java
- Random class
- Scanner class
- Git Bash
- Visual Studio Code

## Project Structure

```text
Task1_Number_Guessing_Game/
├── NumberGuessingGame.java
└── README.md
```

## How to Compile and Run

### Step 1: Open the project directory

```bash
cd ~/OIBSIP/Java_Development/Task1_Number_Guessing_Game
```

### Step 2: Compile the Java program

```bash
javac NumberGuessingGame.java
```

### Step 3: Run the program

```bash
java NumberGuessingGame
```

## Sample Output

```text
Welcome to Number Guessing Game!
Guess a number between 1 and 100.
Enter your guess: 50
Too low! Try again.
Enter your guess: 75
Too high! Try again.
Enter your guess: 63
Congratulations! Correct guess.
Attempts: 3
```

*Note: The sample output is illustrative. The random number and attempts may differ on each run.*

## Internship Details
- Organization: Oasis Infobyte
- Track: Java Development
- Task: Task 1 — Number Guessing Game

## Learning Outcomes
- Understanding Java classes and objects.
- Using the Random and Scanner classes.
- Implementing loops and conditional statements.
- Taking user input and displaying output.
- Compiling and executing a Java program.
