package top.wyh2004.group.manager.plugin.event

import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import top.wyh2004.group.manager.plugin.utils.StringUtils
import java.io.File
import kotlin.random.Random

/**
 * @author WYH2004
 * @date 2022/06/10
 **/
class KeyWordImage : SimpleListenerHost() {
    val skipJava = listOf<String>("跳过java基础的bukkit玩家","没学java","跳过java")
    val iDontKnowList = listOf<String>("为什么","怎么做","求助","怎么办")
    val NPE = listOf<String>("nullpointerexception","npe","空指针")

    @EventHandler
    suspend fun GroupMessageEvent.onEvent(){
        val msg:String = message.toString().lowercase()
        if(StringUtils.containsList(skipJava,msg)){
            var ex = File("D:\\QQBot\\Image\\skipJava.jpg").toExternalResource("jpg")
            var img = group.uploadImage(ex)
            ex.close()
            group.sendMessage(img)
            return
        }
        if(StringUtils.containsList(iDontKnowList,msg)){
            val i = (0..2).random()
            lateinit var ex: ExternalResource
            when(i){
                0 -> ex = File("D:\\QQBot\\Image\\iDontKnow.jpg").toExternalResource("jpg")
                1 -> ex = File("D:\\QQBot\\Image\\youCanSearch1.jpg").toExternalResource("jpg")
                2 -> ex = File("D:\\QQBot\\Image\\youCanSearch2.jpg").toExternalResource("jpg")
            }
            var img = group.uploadImage(ex)
            ex.close()
            group.sendMessage(img)
            return
        }
        if(StringUtils.containsList(NPE,msg)){
            var ex = File("D:\\QQBot\\Image\\NPE.jpg").toExternalResource("jpg")
            var img = group.uploadImage(ex)
            ex.close()
            group.sendMessage(img)
            return
        }
    }
}
