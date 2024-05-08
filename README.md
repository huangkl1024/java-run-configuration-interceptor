# Default Jvm Args

![Build](https://github.com/huangkl1024/default-jvm-args-intellij-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)


<!-- Plugin description -->


> Add default JVM parameters before running the Java project.

## Main features

1. Supports configuring default JVM parameters globally.
2. Supports configuring default JVM parameters for a project.
3. Configure the default JVM parameters for a specific module of a project.


## Installation instructions


### Offline Installation


1. Open the Plugin Marketplace at `Settings/Preferences → Plugins`. 

2. Open `⚙️ → Install plugin from disk.... `, in the pop-up dialog box, select the downloaded plugin `jar` to install.


### Plugin Marketplace Installation


1. Open the Plugin Marketplace at `Settings/Preferences → Plugins → Marketplace`. 

2. Search for `Default Jvm Args`. 

3. Select the searched plugin and install it.


## Instructions for use


1. Open Settings and go to the Tools group at `Settings/Preferences → Tools`. 

2. Under the Tools group, there are `Default Jvm Args(Global)` and `Default Jvm Args(Project)` configurations. 
   1. `Default Jvm Args(Global)` is used to configure the global default JVM parameters.
   2. `Default Jvm Args(Project) Default JVM Args(Project) ` is used to configure the default JVM parameters at the project level. 

3. Enter the relevant JVM parameters in the configuration as required and save them.

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
2. 在 Tools 分组下，有 `Default Jvm Args(Global)` 和 `Default Jvm Args(Project)` 配置项。
   1. `Default Jvm Args(Global)` 用于配置全局默认的 JVM 参数。
   2. `Default Jvm Args(Project)` 用于配置项目级别默认的 JVM 参数。
3. 根据需要在配置里输入相关的 JVM 参数保存。

<!-- Plugin description end -->

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
