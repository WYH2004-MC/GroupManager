# GroupManager

> [Mirai 官方项目仓库](https://github.com/mamoe/mirai)

## 简介
基于 [mirai-console](https://github.com/mamoe/mirai-console) 框架开发的群管理插件, 使用 Kotlin + Gradle 开发.

## 功能
- 进群自动欢迎
- 退群自动欢送
- 加群自动审核
- 显示自定义帮助信息
- 寄寄子抽签

## 下载＆使用
1. [releases](https://github.com/VIPWYH2004/GroupManager/releases) 下载并放到 `plugin` 文件夹中
2. 启动你的Mirai
3. 根据你的需求配置插件的配置文件(路径`/config/GroupManager/`)
4. 重启Mirai或者使用`/groupmanager reload`指令重载配置文件
5. 完成

## 插件权限
```
top.wyh2004.group-manager.command.GroupManager    #GroupManager主指令权限
```

## 指令
```
/groupmanager info      #显示插件信息
/groupmanager reload    #重载插件配置文件
/groupmanager sortiton  #重置抽签记录

/帮助                   #显示帮助信息
```



