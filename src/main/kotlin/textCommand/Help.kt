package top.wyh2004.group.manager.plugin.textCommand

import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import top.wyh2004.group.manager.plugin.config.HelpConfig

/**
 * @author WYH2004
 * @date 2023/1/10
 **/
class Help : SimpleListenerHost() {
    @EventHandler
    suspend fun GroupMessageEvent.onEvent() {
        if (message.contentToString() == "#帮助") {
            group.sendMessage(At(sender.id) + "\n" + HelpConfig.HelpMessage)
        }
    }

    @EventHandler
    suspend fun FriendMessageEvent.onEvent() {
        if (message.contentToString() == "#帮助") {
            sender.sendMessage(At(sender.id) + "\n" + HelpConfig.HelpMessage)
        }
    }
}