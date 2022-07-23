package top.wyh2004.group.manager.plugin.utils

import kotlinx.coroutines.*
import top.wyh2004.group.manager.plugin.PluginMain
import top.wyh2004.group.manager.plugin.TextCommand.Sortition
import java.util.*

/**
 * @author WYH2004
 * @date 2022/7/21
 **/
class CoroutineUpdateTask {

    fun scheduleUpdate(interval: Long){
        PluginMain.launch(Dispatchers.IO) {
            while (isActive){
                try {
                    val c = Calendar.getInstance()
                    val hour = c.get(Calendar.HOUR_OF_DAY)
                    val minute = c.get(Calendar.MINUTE)
                    if(hour == 0 && minute == 0){
                        Sortition.clearList()
                        Sortition.resetMap.clear()
                    }
                }catch (e: Exception){
                    if (e is CancellationException) throw e
                    e.printStackTrace()
                }
                delay(interval)
            }
        }
    }

}
