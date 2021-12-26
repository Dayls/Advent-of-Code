package day1_SonarSweep.kotlinSolution

fun main() {
    val path = "2021/day1_SonarSweep/input.txt"
    val loader = Loader(path)
    val list = loader.data

    var prev = Int.MAX_VALUE
    var cur = 0
    val result = ArrayList<Int>()
    list.forEach {
        cur = it

        if (cur > prev) {
            result.add(cur)
        }
        prev = cur
    }

    print(result.size)

}