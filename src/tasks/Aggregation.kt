package tasks

import contributors.User

/*
 In the initial list each user is present several times, once for each
 repository he or she contributed to.
 Merge duplications: each user should be present only once in the resulting list
 with the total value of contributions for all the repositories.
 Users should be sorted in a descending order by their contributions.

 The corresponding test can be found in test/tasks/AggregationKtTest.kt.
 You can use 'Navigate | Test' menu action (note the shortcut) to navigate to the test.
*/
fun List<User>.aggregate(): List<User> = solution1()

private fun List<User>.solution1(): List<User> {
    val map = mutableMapOf<String, Int>()
    this.forEach {
        map[it.login] = map.getOrDefault(it.login, 0) + it.contributions
    }
    val ans = mutableListOf<User>()
    for ((login, contribution) in map) {
        ans.add(User(login, contribution))
    }
    return ans.sortedByDescending { it.contributions }
}