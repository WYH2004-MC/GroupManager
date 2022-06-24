package top.wyh2004.group.manager.plugin.event

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import top.wyh2004.group.manager.plugin.PluginMain
import top.wyh2004.group.manager.plugin.config.KeyWordImageConfig
import top.wyh2004.group.manager.plugin.utils.StringUtils
import java.io.File

/**
 * @author WYH2004
 * @date 2022/06/10
 **/
class KeyWordImage : SimpleListenerHost() {
    val skipJava = listOf<String>("跳过java基础的bukkit玩家","没学java","跳过java", "未学java")
    val iDontKnowList = listOf<String>("为什么","是什么","怎么做","求助","怎么办","怎么弄","怎么实现","咋弄","咋办","为啥","请问","怎么写")
    val NPE = listOf<String>("nullpointerexception","npe","null","空指针")

    @EventHandler
    suspend fun GroupMessageEvent.onEvent(){
        if (KeyWordImageConfig.autoSendImageGroupList.contains(group.id)){
            val msg:String = message.toString().lowercase()
            if(StringUtils.containsList(skipJava,msg)){
                var ex = PluginMain::class.java.getResourceAsStream("/img/skipJava.jpg")!!.toExternalResource("jpg")
                var img = group.uploadImage(ex)
                ex.close()
                group.sendMessage(img)
                return
            }
            if(StringUtils.containsList(iDontKnowList,msg)){
                val i = (0..2).random()
                lateinit var ex: ExternalResource
                when(i){
                    0 -> ex = PluginMain::class.java.getResourceAsStream("/img/iDontKnow.jpg")!!.toExternalResource("jpg")
                    1 -> ex = PluginMain::class.java.getResourceAsStream("/img/youCanSearch1.jpg")!!.toExternalResource("jpg")
                    2 -> ex = PluginMain::class.java.getResourceAsStream("/img/youCanSearch2.jpg")!!.toExternalResource("jpg")
                }
                var img = group.uploadImage(ex)
                ex.close()
                group.sendMessage(img)
                return
            }
            if(StringUtils.containsList(NPE,msg)){
                var ex = PluginMain::class.java.getResourceAsStream("/img/NPE.jpg")!!.toExternalResource("jpg")
                var img = group.uploadImage(ex)
                ex.close()
                group.sendMessage(img)
                return
            }
        }
    }
}
