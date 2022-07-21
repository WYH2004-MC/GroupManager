package top.wyh2004.group.manager.plugin.utils

import kotlinx.coroutines.*
import top.wyh2004.group.manager.plugin.TextCommand.Sortition
import java.util.*

/**
 * @author WYH2004
 * @date 2022/7/21
 **/
class CoroutineUpdateTask {
    private var scope: CoroutineScope? = null

    fun scheduleUpdate(interval: Long){
        cancel()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            while (isActive){
                try {
                    val c = Calendar.getInstance()
                    val hour = c.get(Calendar.HOUR_OF_DAY)
                    val minute = c.get(Calendar.MINUTE)
                    if(hour == 0 && minute == 0){
                        Sortition.clearList()
                    }
                }catch (e: Exception){
                    if (e is CancellationException) throw e
                    e.printStackTrace()
                }
                delay(interval)
            }
        }
        this.scope = scope
    }

    fun cancel(){
        scope?.cancel()
        scope = null
    }
}
