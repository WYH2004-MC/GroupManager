package top.wyh2004.group.manager.plugin

import kotlinx.coroutines.cancel
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.registerTo
import net.mamoe.mirai.utils.info
import top.wyh2004.group.manager.plugin.textCommand.Sortition
import top.wyh2004.group.manager.plugin.command.GroupManagerCommand
import top.wyh2004.group.manager.plugin.command.Minecraft
import top.wyh2004.group.manager.plugin.config.GroupManagerConfig
import top.wyh2004.group.manager.plugin.config.HelpConfig
import top.wyh2004.group.manager.plugin.config.KeyWordImageConfig
import top.wyh2004.group.manager.plugin.event.GroupRequestAutoAccept
import top.wyh2004.group.manager.plugin.event.KeyWordImage
import top.wyh2004.group.manager.plugin.event.MemberJoinQuitGroupMessage
import top.wyh2004.group.manager.plugin.textCommand.Help

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "top.wyh2004.group-manager",
        name = "GroupManager",
        version = "0.1.9"
    ) {
        author("WYH2004")
    }
) {

    override fun onEnable() {
        logger.info { "GroupManager 已启动! --- Author:WYH2004" }
        //配置文件目录 "${dataFolder.absolutePath}/"

        regListener()
        regCommand()
        regTextCommand()
        regConfig()
        regTimer()

    }

    override fun onDisable() {
        logger.info("GroupManager 已卸载!")
        this.cancel()
    }

    private fun regCommand() {
        GroupManagerCommand.register()
        CommandManager.registerCommand(Minecraft(),true)
    }

    private fun regTextCommand(){
        Sortition().registerTo(GlobalEventChannel)
        Help().registerTo(GlobalEventChannel)
    }

    private fun regConfig(){
        GroupManagerConfig.reload()
        KeyWordImageConfig.reload()
        HelpConfig.reload()
    }

    private fun regListener(){
        GroupRequestAutoAccept().registerTo(GlobalEventChannel)
        MemberJoinQuitGroupMessage().registerTo(GlobalEventChannel)
        KeyWordImage().registerTo(GlobalEventChannel)
    }

    private fun regTimer(){
        Sortition.timer(30000)
    }

    fun reloadConfig(){
        regConfig()
    }
}
