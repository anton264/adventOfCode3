import java.io.File

fun main() {

    val theMap = File(ClassLoader.getSystemResource("input").file)
        .readText().split("\n")

    val first = tobogganRun(theMap, 1)
    val second = tobogganRun(theMap, 3)
    val third = tobogganRun(theMap, 5)
    val fourth = tobogganRun(theMap, 7)
    val fifth = tobogganRun(theMap, 1, true)

    println(first * second * third * fourth * fifth)
}

fun tobogganRun(theMap: List<String>, movesRight: Int, twoMovesDown: Boolean = false): Int {
    var treesEncountered = 0
    val mapWidth = theMap[0].length
    var position = 0
    for ((currentRow, row) in theMap.withIndex()) {
        if (twoMovesDown && currentRow % 2 != 0) continue
        if (position > mapWidth - 1) position -= mapWidth
        if (row[position] == '#') treesEncountered++
        //println(row)
        //println("we are at position $position on row $currentRow trees: $treesEncountered ${row[position]} ")
        position += movesRight
    }
    println(treesEncountered)
    return treesEncountered
}