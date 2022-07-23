package top.wyh2004.group.manager.plugin.command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.RawCommand
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import top.wyh2004.group.manager.plugin.PluginMain
import top.wyh2004.group.manager.plugin.config.HelpConfig

/**
 * @author WYH2004
 * @date 2022/7/22
 **/
object HelpCommand: RawCommand(
    PluginMain,
    primaryName = "帮助",
    usage = "/帮助",
    description = "输出帮助信息"
) {
    override suspend fun CommandSender.onCommand(args: MessageChain) {
        val msg = buildMessageChain {
            +PlainText(HelpConfig.HelpMessage)
        }
        sendMessage(msg)
        return
    }
}