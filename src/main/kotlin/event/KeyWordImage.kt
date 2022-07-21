package top.wyh2004.group.manager.plugin.event

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.SimpleListenerHost
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import top.wyh2004.group.manager.plugin.PluginMain
import top.wyh2004.group.manager.plugin.config.KeyWordImageConfig
import top.wyh2004.group.manager.plugin.utils.StringUtils

/**
 * @author WYH2004
 * @date 2022/06/10
 **/
class KeyWordImage : SimpleListenerHost() {
    private val skipJava = listOf<String>("跳过java基础的bukkit玩家","没学java","跳过java", "未学java")
    private val iDontKnowList = listOf<String>("为什么","是什么","怎么做","求助","怎么办","怎么弄","怎么实现","咋弄","咋办","为啥","请问","怎么写")
    private val NPE = listOf<String>("nullpointerexception","npe","null","空指针")

    @EventHandler
    suspend fun GroupMessageEvent.onEvent(){
        if (KeyWordImageConfig.autoSendImageGroupList.contains(group.id)){
            val msg:String = message.toString().lowercase()
            if(StringUtils.containsList(skipJava,msg)){
                val ex = PluginMain::class.java.getResourceAsStream("/img/skipJava.jpg")!!.toExternalResource()
                val img = group.uploadImage(ex)
                withContext(Dispatchers.IO) {
                    ex.close()
                }
                group.sendMessage(img)
                return
            }
            if(StringUtils.containsList(iDontKnowList,msg)){
                val imgList = listOf<String>(
                    "/img/iDontKnow.jpg",
                    "/img/youCanSearch1.jpg",
                    "/img/youCanSearch2.jpg",
                    "/img/giveMeMoney.jpg",
                    "/img/fixBrain.jpg"
                )
                val ex = PluginMain::class.java.getResourceAsStream(imgList.random())!!.toExternalResource()
                val img = group.uploadImage(ex)
                withContext(Dispatchers.IO) {
                    ex.close()
                }
                group.sendMessage(img)
                return
            }
            if(StringUtils.containsList(NPE,msg)){
                val ex = PluginMain::class.java.getResourceAsStream("/img/NPE.jpg")!!.toExternalResource()
                val img = group.uploadImage(ex)
                withContext(Dispatchers.IO) {
                    ex.close()
                }
                group.sendMessage(img)
                return
            }
        }
    }
}
