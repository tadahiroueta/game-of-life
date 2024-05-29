# Game of Life
***A plain, Java simulation of Conway's Game of Life***

[Built With](#built-with) · [Features](#features) · [Installation](#installation) · [Usage](#usage)

## Built With

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=oracle&logoColor=white)

## Features

### Faithful to Conway's algorithm

- Born with 3 neighbours
- Live with 2 or 3
- Die otherwise

<br>
<img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/game.gif" alt="game" width="50%" />
<br>

### Model-View-Controller

The code is divided among
- ```LifeModel.java``` and ```LifeCell.java```
- ```LifeView.java```
- ```Life.java```

### Pre-made patterns/communities

Accessible with ```.lif``` files

<br>
<div>
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/blinker.gif" alt="blinker" width="20%" /> 
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/penta.gif" alt="penta" width="20%" /> 
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/tumbler.gif" alt="tumbler" width="20%" /> 
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/glgun13.gif" alt="glgun13" width="33%" /> 
</div>
<br>

### Change colours

A random number generator asserts random colour to GUI

<br>
<img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/colours.gif" alt="colours" width="50%" />
<br>

## Installation
<!-- Find more language syntax identifiers for code blocks here, https://github.com/jincheng9/markdown_supported_languages -->
1. Install specific programming language compiler.

    *Just a little note without non-crucial infomation*.
2. Clone repository
    ```sh
    git clone https://github.com/tadahiroueta/repository.git
    ```
3. Install dependencies
    ```sh
    npm install
    ```

## Usage
1. First
    ```sh
    node index
    ```
  
  ![image](https://t3.ftcdn.net/jpg/02/48/42/64/360_F_248426448_NVKLywWqArG2ADUxDq6QprtIzsF82dMF.jpg)
