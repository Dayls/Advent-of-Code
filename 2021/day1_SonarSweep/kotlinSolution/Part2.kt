package day1_SonarSweep.kotlinSolution

fun main() {
    val path = "2021/day1_SonarSweep/input.txt"

    val data = Loader(path).data

    var index = 0

    var curThree = 0
    var prevThree = Int.MAX_VALUE
    val sums= ArrayList<Int>()
    outer@
    for(i in data) {
        curThree = 0
        inner@
        for(j in index..index+2) {
            curThree += data[j]
            if (j == data.size-1) {
                break@inner
            }

        }
        if(curThree > prevThree) {
            sums.add(curThree)
        }
        prevThree = curThree
        index++
    }
}