package com.techo.mvvmdesignpatternex.Util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Couroutines {
    fun main(work:suspend (()->Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }
}