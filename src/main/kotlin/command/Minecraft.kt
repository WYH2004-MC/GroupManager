package top.wyh2004.group.manager.plugin.command

import net.mamoe.mirai.console.command.CommandSenderOnMessage
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.utils.MiraiLogger
import top.wyh2004.group.manager.plugin.PluginMain

/**
 * @author WYH2004
 * @date 2021/12/29
 **/
class Minecraft : CompositeCommand(
    owner = PluginMain,
    primaryName = "minecraft",
    description = "minecraft"
    ) {
    var logger : MiraiLogger = PluginMain.logger

    @SubCommand("create", "创建")
    @Description("")
    suspend fun CommandSenderOnMessage<FriendMessageEvent>.create(name: String) {

    }

}