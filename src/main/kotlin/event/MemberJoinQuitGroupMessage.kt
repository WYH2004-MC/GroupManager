package top.wyh2004.group.manager.plugin.event

import net.mamoe.mirai.contact.remarkOrNameCardOrNick
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.MemberJoinEvent
import net.mamoe.mirai.event.events.MemberLeaveEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.Message
import net.mamoe.mirai.message.data.PlainText
import top.wyh2004.group.manager.plugin.config.GroupManagerConfig

/**
 * @author WYH2004
 * @date 2021/12/30
 **/
class MemberJoinQuitGroupMessage : SimpleListenerHost() {
    @EventHandler
    suspend fun MemberJoinEvent.onEvent(){
        if (GroupManagerConfig.groupMessageList.contains(member.group.id)){
            val msg : Message = At(member.id) + PlainText("\n") + PlainText(GroupManagerConfig.groupMemberJoinMessage)
            member.group.sendMessage(msg)
        }
    }

    @EventHandler
    suspend fun MemberLeaveEvent.onEvent(){
        if (GroupManagerConfig.groupMessageList.contains(member.group.id)){
            member.group.sendMessage(member.remarkOrNameCardOrNick + "(${member.id})\n" + GroupManagerConfig.groupMemberLeaveMessage)
        }
    }
}