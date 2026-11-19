package com.example.cleaner

import android.app.ActivityManager
import android.content.Context
import android.content.pm.ApplicationInfo

// 白名单：不想被清理的应用包名加在这里，例如同花顺 "com.hexin.plat.android"
val KEEP = setOf<String>(
    "com.hexin.plat.android"
)

fun cleanBackground(ctx: Context): Int {
    val am = ctx.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val apps = ctx.packageManager.getInstalledApplications(0).filter {
        (it.flags and ApplicationInfo.FLAG_SYSTEM) == 0 &&
            it.packageName != ctx.packageName && it.packageName !in KEEP
    }
    apps.forEach { am.killBackgroundProcesses(it.packageName) }
    return apps.size
}
