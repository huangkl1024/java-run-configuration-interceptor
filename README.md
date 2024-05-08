# Default Jvm Args

![Build](https://github.com/huangkl1024/default-jvm-args-intellij-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)


<!-- Plugin description -->


> 在项目运行前添加默认的 JVM 参数。

## 主要特性

1. 支持全局配置默认的 JVM 参数。
2. 支持为项目配置默认的 JVM 参数。
3. 之前为项目指定模块配置默认的 JVM 参数。

## 安装说明

### 离线安装

1. 打开插件市场，操作路径为 `Settings/Preferences → Plugins` 。
2. 打开 `⚙️ → Install plugin from disk...`，在弹窗的对话框里选择下载好的插件 `jar` 安装。

### 插件市场安装

1. 打开插件市场，操作路径为 `Settings/Preferences → Plugins → Marketplace`。
2. 搜索 `Default Jvm Args` 。
3. 选择搜索的插件并安装。


## 使用说明

1. 打开设置，进入到 Tools 分组，操作路径为 `Settings/Preferences → Tools`。
2. 在 Tools 分组下，有 `Default Jvm Args(Global)` 和 `Default Jvm Args(Project)` 配置项；`Default Jvm Args(Global)` 用于配置全局默认的 JVM 参数； `Default Jvm Args(Project)` 用于配置项目级别默认的 JVM 参数。
3. 根据需要在配置里输入相关的 JVM 参数保存。

<!-- Plugin description end -->

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
