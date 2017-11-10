# smart-framework


## chapter3

### smart-framework

> 没有引入整体框架，而是引入第三方开源项目以搭建轻量级web框架

> annotation 注解

***meta-annotation***

- @Target
```html
表示该注解用于什么地方。如果不明确指出，该注解可以放在任何地方
ElementType.TYPE:用于描述类、接口或enum声明
ElementType.FIELD:用于描述实例变量
ElementType.METHOD
```
- @Retention
```
定义该注解的生命周期。
    
    RetentionPolicy.SOURCE – 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。
    
    RetentionPolicy.CLASS – 在类加载的时候丢弃。在字节码文件的处理中有用。注解默认使用这种方式。
    
    RetentionPolicy.RUNTIME– 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。
```
- @Documented
- @Inherited

> IoC, Inversion of control, 控制反转

> DI, Dependency Injection, 依赖注入

> 小结

- 定义了一系列注解：Controller, Inject, Action.
- 通过一系列Helper类初始化MVC框架
- 通过DispatcherServlet处理所有请求
- 根据请求方法与请求路径调用具体的Action方法

### module - chapter 3

> 依赖于 smart-framework 框架


## chapter4

> AOP, Aspect-Oriented Programming, 面向切面编程

- 概念
  - 相关术语
  - 增强类型
- 方案
  - 写死代码
  - 静态代理 XxxProxy
  - 动态代理 DynamicProxy
    - JDK
    - **CGLib**
  - Spring AOP
  - Spring AspectJ
    - 基于注解(@Aspect)
    - 基于配置(<aop:config>)

## REF

- [huangyong/smart-framework](https://gitee.com/huangyong/smart-framework)
- [huangyong/blog](https://my.oschina.net/huangyong/blog/158380)
