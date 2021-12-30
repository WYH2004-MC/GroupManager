package top.wyh2004.group.manager.plugin.config

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value
import java.util.*


/**
 * @author WYH2004
 * @date 2021/12/29
 **/
object GroupManagerConfig: ReadOnlyPluginConfig("GroupManagerConfig"){

    @ValueDescription("新成员加群审核\n 1 : 不做任何操作\n 2 : 自动同意\n 3 : 自动审核(包含关键字自动同意)")
    val groupJoinRequest : Int by value(1)

    @ValueDescription("设置需要启用加群自动同意/审核的QQ群号")
    val autoAcceptGroupList : List<Long> by value(listOf(123456789,123456789,123456789))

    @ValueDescription("加群自动审核的关键字列表")
    val autoAcceptGroupWordList : List<String> by value(listOf("关键字1","关键字2"))

    @ValueDescription("需要启用自动欢迎/欢送的QQ群号")
    val groupMessageList : List<Long> by value(listOf(123456789,123456789,123456789))

    @ValueDescription("新成员加群欢迎语\n如不需要请填写 '' 两个单引号")
    val groupMemberJoinMessage: String by value("欢迎( •̀ ω •́ )✧")

    @ValueDescription("新成员退群欢送语\n如不需要请填写 '' 两个单引号")
    val groupMemberLeaveMessage: String by value("886( •̀ ω •́ )✧")
}
