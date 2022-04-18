package com.renxh

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

public class Frist implements Plugin<Project> {

    @Override
    void apply(Project project) {

        //注册Transform
        AppExtension appExtension = project.getExtensions().findByType(AppExtension.class)
        appExtension.registerTransform(new MyTransform(project))

//        appExtension.registerTransform(new AsmTransform(project))


        //添加扩展
        project.extensions.add('myex',TextEx)

        project.task("cusplugin"){
            doLast{
                println("cusplugin任务执行11112")

                TextEx extension = project.myex
                //3.输出插件扩展属性
                println ">>>>>> name: ${extension.name} age:${extension.age}"
            }
        }

    }
}