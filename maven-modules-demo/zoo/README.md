# maven 多模块(modules)练习项目


## 项目结构
```html
zoo  
  |  
  |— zoo-dao
  |      |
  |      |— src
  |      |— pom (jar)
  |      |
  |
  |— zoo-server
  |      |
  |      |— src
  |      |— pom (jar)
  |      |
  |
  |— zoo-web
  |      |
  |      |— src
  |      |— pom (war)
  |      |
  |
  |— pom.xml (pom)
  |

```

## 项目说明
zoo作为parent项目

依赖关系zoo-web->zoo-server->zoo-dao

其实就是一个mvc项目，各模块分到子项目中。


## 项目编译启动

1）命令行编译运行程序
项目下载之后再zoo根目录下执行下面命令来启动编译启动程序
```
mvn tomcat7:run
```

2）ide(eclipse)中引入项目编译运行
```
zoo(右键)->Run As->Maven build(goals：tomcat7:run)即可
```



访问Url查看效果：http://127.0.0.1:8080/zoo-web/zoo/getZoo


## 参考
<a href="http://www.blogjava.net/fancydeepin/archive/2015/06/27/maven-modules.html">maven 多模块项目</a>


