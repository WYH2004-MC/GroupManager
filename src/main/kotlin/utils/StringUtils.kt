package top.wyh2004.group.manager.plugin.utils

/**
 * @author WYH2004
 * @date 2021/12/29
 **/
class StringUtils {
    companion object{
        fun containsList(stringList : List<String>, string: String):Boolean{
            val it: Iterator<*> = stringList.iterator()
            while (it.hasNext()) {
                if (string.contains(it.next().toString())){
                    return true
                }
            }
            return false
        }
    }
}