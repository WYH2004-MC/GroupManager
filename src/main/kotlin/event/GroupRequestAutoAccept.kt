package top.wyh2004.group.manager.plugin.event

import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.MemberJoinEvent
import net.mamoe.mirai.event.events.MemberJoinRequestEvent
import top.wyh2004.group.manager.plugin.config.GroupManagerConfig
import top.wyh2004.group.manager.plugin.utils.StringUtils

/**
 * @author WYH2004
 * @date 2021/12/29
 **/
class GroupRequestAutoAccept : SimpleListenerHost() {
    @EventHandler
    suspend fun MemberJoinRequestEvent.onEvent(){
        val mode = GroupManagerConfig.groupJoinRequest
        if (GroupManagerConfig.autoAcceptGroupList.contains(groupId)){
            if (mode == 2){
                accept()
            }else if (mode == 3){
                if (StringUtils.containsList(GroupManagerConfig.autoAcceptGroupWordList,message)){
                    accept()
                }
            }
        }
    }
}