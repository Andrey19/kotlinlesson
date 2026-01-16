
    fun main(args: Array<String>) {
        val input = readln().split(" ").map{ it.toInt()}
        val n = input[0].toInt()
        val m = input[1].toInt()
        val dp = Array<IntArray>(n) { IntArray(m) }
        dp[0][0] = 1
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (i + 1 < n && j + 2 < m) dp[i + 1][j + 2] += dp[i][j]
                if (i + 2 < n && j + 1 < m) dp[i + 2][j + 1] += dp[i][j]
            }
        }
        println(dp[n - 1][m - 1])
    }


