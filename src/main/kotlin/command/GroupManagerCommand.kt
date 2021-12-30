package top.wyh2004.group.manager.plugin.command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.permission.PermissionService.Companion.hasPermission
import net.mamoe.mirai.utils.MiraiLogger
import top.wyh2004.group.manager.plugin.PluginMain

/**
 * @author WYH2004
 * @date 2021/12/29
 **/
object GroupManagerCommand : CompositeCommand(
    owner = PluginMain,
    primaryName = "GroupManager",
    description = "GroupManager"
    ){
    var logger : MiraiLogger = PluginMain.logger

    @SubCommand("reload","重载")
    suspend fun CommandSender.reload() {
        try {
            PluginMain.reloadConfig()
            sendMessage("已重载GroupManager配置文件!")
        } catch (ex: Exception) {
            logger.error(ex)
        }
    }

    @SubCommand("info","信息")
    suspend fun CommandSender.info() {
        val pluginInfo =
            "=== GroupManager ===\n" +
            "作者: WYH2004\n" +
            "项目地址:\n" +
            "https://github.com/VIPWYH2004/GroupManager"
        sendMessage(pluginInfo)
    }
}

