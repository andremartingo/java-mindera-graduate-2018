<p align="center">
  <img width="150" src="https://vignette.wikia.nocookie.net/logopedia/images/6/6a/Java-logo.jpg/revision/latest?cb=20150321072347" />
</p>

## Challenge:

    Using any programming language, create a program that is capable of identifying all the groups of adjacent cells in a grid.

    The grid consists of a 2-dimensional array of 0 (zeroes) and 1 (ones). The output of the program should consist of a sequence of multi-dimensional arrays each containing the list of points that make up a group of adjacent cells.

    Rules:
    Cells are considered adjacent if they both contain a 1 (one) and are next to each other horizontally or vertically (not diagonally).
    Groups containing a single cell should not be considered
    The order of points or groups outputted by the program is not relevant

    Example
    For a grid input of:
    [[0,0,0,1,0,0,1,1],
    [0,0,1,1,1,0,1,1],
    [0,0,0,0,0,0,1,0],
    [0,0,0,1,0,0,1,1],
    [0,0,0,1,0,0,1,1]]

    Expected output:
    [ [0,3], [1,2], [1,3], [1,4] ]
    [ [0,6], [0,7], [1,6], [1,7], [2,6], [3,6], [3,7], [4,6], [4,7] ]
    [ [3, 3], [4,3] ]

## Instalation

```bash
git clone https://github.com/andremartingo/java-mindera-graduate-2018.git
cd java-mindera-graduate-2018
mvn package
```

## Run Tests

```bash
mvn test
```

## Usage

```bash
java -jar target/mindera_graduate_2018-1.0-SNAPSHOT.jar [path to matrix.json]
```

### Example:

```bash
java -jar target/mindera_graduate_2018-1.0-SNAPSHOT.jar ~/Desktop/matrix.json
```
