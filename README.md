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
<img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/game.gif" alt="game" width="376rem" />
<br>

### Model-View-Controller Design

The code is divided among
- ```LifeModel.java``` and ```LifeCell.java``` (Model)
- ```LifeView.java``` (View)
- ```Life.java``` (Controller)

### Pre-built patterns/communities

Accessible with ```.lif``` files

<br>
<div>
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/blinker.gif" alt="blinker" width="150rem" /> 
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/penta.gif" alt="penta" width="150rem" /> 
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/tumbler.gif" alt="tumbler" width="150rem" /> 
  <img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/glgun13.gif" alt="glgun13" width="150rem" /> 
</div>
<br>

### Change colours

A random number generator asserts random colour to GUI

<br>
<img src="https://github.com/tadahiroueta/game-of-life/blob/master/samples/colours.gif" alt="colours" width="376rem" />
<br>

## Installation

1. Install a JDK
    > I recommend [Red Hat's](https://developers.redhat.com/products/openjdk/download?source=sso)

2. Clone repository
    ```sh
    git clone https://github.com/tadahiroueta/game-of-life.git
    ```

## Usage

### Random game

1. Run ```Life.java```

### Pre-built games
  
1. Add ```"data/<community>.lif"``` inside ```Life()``` in ```Life.java``` line 118

    ```java
    ...
    public static void main(String[] args) throws IOException
    {
      Life conway = new Life("data/blinker.lif"); //parameterize to start w/ a particular file
    ...
    ```

    > Pre-built games include
    > - blinker
    > - glgun13
    > - penta
    > - tumbler

2. Run ```Life.java```
