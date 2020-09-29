##Web开发

使用SpringBoot；

1） 创建springboot应用，选中需要使用的模块（web，数据库，redis等等）；

2） SpringBoot默认将场景配置完成（自动配置原理 AutoConfiguration），只需要在配置文件中指定少量配置就可运行起来；

3） 编写业务逻辑代码；

 **自动配置原理**：场景配置了什么？能不能修改？能修改什么？能不能扩展
 
```
xxxAutoConfiguration :帮我们给容器中自动配置组件

xxxProperties:配置类来封装配置文件的内容

```

静态资源映射：
```java

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            if (!this.resourceProperties.isAddMappings()) {
                logger.debug("Default resource handling disabled");
                return;
            }
            Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
            CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
            if (!registry.hasMappingForPattern("/webjars/**")) {
                customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/")
                        .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
            }
            String staticPathPattern = this.mvcProperties.getStaticPathPattern();
            if (!registry.hasMappingForPattern(staticPathPattern)) {
                customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
                        .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
                        .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
            }
        }
```

1) 所有/webjars/**，都去classpath:/META-INF/resources/webjars/找资源
    
    webjars：以jar包的方式引入静态资源。 https://www.webjars.org/
    
    访问地址：http://localhost:8080/webjars/jquery/3.3.1/jquery.js
    
```xml
 <!--引入jquery的webjar 在访问的时候只需要写webjars里面的资源名称就行了-->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.3.1</version>
        </dependency>
```

2） "/**" 访问当前项目的任何资源的时候访问路径：

    "classpath:/META-INF/resources/",

    "classpath:/resources/", 

    "classpath:/static/", 

    "classpath:/public/"
    
    "/":当前项目的根路径
    
3） 欢迎页：静态资源文件夹下面的所有index.html页面；被"/**"映射

4） 图标：/favicon.icon


###3. 模板引擎

Thymeleaf：Springboot推荐，语法简单，功能强大。

####1.引入thymeleaf，maven依赖，布局版本对应

####2.Thymeleaf使用和语法

```java
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {

	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;

	public static final String DEFAULT_PREFIX = "classpath:/templates/";

	public static final String DEFAULT_SUFFIX = ".html";
    //只要把html页面放在类路径的templates里面，就能自动渲染了
```


1. 导入thyemleaf的语法空间

2. thyemleaf的使用方法
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>成功！</h1>
<!--th:text 将原有的div的内容设置为 。。。 -->

<body th:text="${hello}">这是原有内容</body>
</body>
</html>
```
3 语法规则
 
 - th:text ：改变当前元素的文本内容；
 - th:任意属性名 ： 来替换原生属性值 例如： th:id="${id}"
 
 