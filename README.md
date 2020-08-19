替换口袋阅首页的Kindle图标为任意应用程序

### 说明：

在未刷机的情况下，口袋阅1的默认桌面如下：


自己安装的程序无法在桌面上显示，而桌面上的kindle又不经常使用。可以改为，点击Kindle进入自己安装的程序，比如：点击Kindle进入koreader。

### 方法：
实质上就是，自己编写一个与Kindle包名相同的程序，启动该程序时，启动你设置的程序。核心代码如下，很简单：

        val packageName = sp.getString("pkg", "")
        if (TextUtils.isEmpty(packageName)) {
            tvTitle.text = "请输入应用包名,如:org.koreader.launcher"
        } else {
            val intent = packageManager.getLaunchIntentForPackage(packageName!!)
            startActivity(intent)
            finish()
        }
可以使用已经编译好的程序：


安装后输入要替换的包名，点击确认即可。然后点击桌面的Kindle图标即可进入设置的app。注意：安装该程序后，无法安装Kindle app。包名冲突。

卸载方法：adb uninstall com.amazon.kindlefc

### 地址：
下载地址：http://img.xfans.me/download/kdy-replace-release.apk

代码地址：https://github.com/xfans/KdyReplace
