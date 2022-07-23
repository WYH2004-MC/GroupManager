package top.wyh2004.group.manager.plugin.config

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

/**
 * @author WYH2004
 * @date 2022/7/22
 **/
object HelpConfig: ReadOnlyPluginConfig("HelpConfig") {

    @ValueDescription("帮助信息内容")
    val HelpMessage : String by value("帮助信息实例\n然后这是换行")


}