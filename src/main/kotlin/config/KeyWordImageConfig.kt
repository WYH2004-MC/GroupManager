package top.wyh2004.group.manager.plugin.config

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value
import top.wyh2004.group.manager.plugin.config.GroupManagerConfig.provideDelegate

object KeyWordImageConfig : ReadOnlyPluginConfig("KeyWordImageConfig") {

    @ValueDescription("设置需要启用监听关键词自动发送表情包的QQ群群号")
    val autoSendImageGroupList : List<Long> by value(listOf(123456789,123456789,123456789))

}