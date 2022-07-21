package top.wyh2004.group.manager.plugin.TextCommand

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import top.wyh2004.group.manager.plugin.PluginMain

/**
 * @author WYH2004
 * @date 2022/7/21
 **/
class Sortition() : SimpleListenerHost() {

    @EventHandler
    suspend fun GroupMessageEvent.onEvent(){
        if (message.toString().contains("#抽签")){
            if (!qqSortitionList.contains(sender.id)){
                val imgList = listOf<String>(
                    "/img/sortition/--.jpg",
                    "/img/sortition/-.jpg",
                    "/img/sortition/-+.jpg",
                    "/img/sortition/+.jpg",
                    "/img/sortition/++.jpg"
                )
                val ex = PluginMain::class.java.getResourceAsStream(imgList.random())!!.toExternalResource()
                val img = group.uploadImage(ex)
                withContext(Dispatchers.IO) {
                    ex.close()
                }
                val msg = buildMessageChain {
                    +At(sender.id)
                    +PlainText("\n")
                    +img
                }
                group.sendMessage(msg)
                qqSortitionList.add(sender.id)
                return
            }else{
                group.sendMessage(At(sender.id) + PlainText("\n") + "你今天已经抽过签了!")
                return
            }
        }
    }

    companion object {
        var qqSortitionList : MutableList<Long> = mutableListOf()
        fun clearList() {
            qqSortitionList.clear()
        }
    }
}