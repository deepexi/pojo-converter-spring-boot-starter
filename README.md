# pojo-converter-spring-boot-starter

[![Build Status](https://travis-ci.org/deepexi/pojo-converter-spring-boot.svg?branch=master)](https://travis-ci.org/deepexi/pojo-converter-spring-boot) [![codecov](https://codecov.io/gh/deepexi/pojo-converter-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/deepexi/pojo-converter-spring-boot)

项目中用到了各种POJO对象，如VO、DTO、BO；为了方便POJO在不同业务层的转换，
自定义了相应的converter，而使用Converter需要在Spring中进行相应的配置。
配置都是相同的，为避免不必要的重复，从而抽离该部分成为一个独立的starter，方便在Spring Boot中使用.

## 版本信息
支持Spring Boot 2.x的版本

     Spring Boot：2.1.9.RELEASE

## Getting Started
  实现自定义的Converter，然后引入starter坐标后，调用ConverterUtils的方法即可进行转化，具体使用参考[Test Demo](https://github.com/deepexi/pojo-converter-spring-boot/tree/master/pojo-converter-spring-boot-starter-test)
  
  目前还在申请发布至Maven仓库，需要自行安装到本地仓库。
  
### 引入坐标

```xml
<dependency>
    <groupId>com.deepexi</groupId>
    <artifactId>pojo-converter-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
    
### 自定义Converter，自动注册

```java
@Component
public class customerVOConverter implements Converter<from, to> {

    @Override
    public to convert(From from) {
        // customer conver operation
        return to;
    }
}
```

### import ConverterUtils

```java
convert(target, dest);
convertAll(target, dest);
```
      
    
      
