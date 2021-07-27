package com.example.android.kotlincoroutines.main

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.ArrayDeque
import java.util.Deque
import kotlin.math.max

class Main {
    companion object {
        @ExperimentalStdlibApi
        @JvmStatic
        fun main(args: Array<String>) {
            val target = 9
            val map = HashMap<Int, Int>()
            val test: IntArray = intArrayOf(1, 2)
            test.forEachIndexed { i, v ->
                if(map.containsKey(target - v)) {
                    return intArrayOf(map.get(target-v), i)
                } else {
                    map[v] = i
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { i, v ->
        if(map.containsKey(target -v )) {
            return intArrayOf(map[target - v]!!, i)
        } else {
            map[v] = i
        }
    }
    return intArrayOf()
}

// intervals(i)[start, end]
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith { i1, i2 -> i1[0].compareTo(i2[0]) }
    val merge = ArrayList<IntArray>()

    for (i in intervals) {
        if (merge.isEmpty() || merge.last()[1] < i[0]) {
            merge.add(i)
        } else {
            merge.last()[1] = max(i[1], merge.last()[1])
        }
    }
    return merge.toTypedArray()
}

// (())
// ))
// ())
fun minRemoveToMakeValid(s: String): String {
    val stack: Deque<Int> = ArrayDeque()
    val indexesToRemove = HashSet<Int>()
    val chars = s.toCharArray()
    for (i in chars.indices) {
        if (chars[i] == '(') {
            stack.push(i)
        }
        if (chars[i] == ')') {
            if (stack.isEmpty()) {
                indexesToRemove.add(i)
            } else {
                stack.pop()
            }
        }
    }

    val builder = StringBuilder()
    for (i in chars.indices) {
        if (!indexesToRemove.contains(i)) {
            builder.append(chars[i])
        }
    }

    return builder.toString()
}