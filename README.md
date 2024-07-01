# 🎲 FRP Dice Roller App

**Developer:** Begüm Ayten

## 📄 Description

The FRP Dice Roller App is a mobile application developed using Jetpack Compose. It allows users to simulate the rolling of various polyhedral dice commonly used in tabletop Fantasy Role-Playing (FRP) games, such as D4, D6, D8, D10, D12, and D20.

## ✨ Features

- **Dice Selection:** Users can select one or more dice to roll.
- **Roll Results:** The app displays the results for each selected die.
- **User Interface:** Intuitive and visually appealing UI created with Jetpack Compose.

## 🛠️ Key Development Processes
- **Character Design**: Modeled in Blender with detailed UV mapping and rigging.
- **Environment Creation**: Crafted using Unity's terrain tools, height maps, and dynamic lighting.
- **Interaction Mechanics**: Implemented using C# scripts to enable player interactions with rune stones.
  
## ⚙️ Installation

- Clone the repository:
   ```sh
   git clone https://github.com/begumayten/FRPDiceRoller.git
   
- Open the project in Android Studio.
- Build and run the app on an emulator or physical device.

## 🚀 Usage
- Open the app.
- Select the dice you want to roll.
- Press the "Roll" button.
- View the results for each selected die.

## 🧩 Code Overview
- **MainActivity:** Sets up the main activity and content.
- **FRPDiceRollerApp:** Contains the main composable function for the app.
- **DiceSelector:** Allows users to select dice.
- **DiceCheckbox:** Represents each dice option with an image and checkbox.
- **rollDice:** Function to simulate the rolling of selected dice.
