# pojo-converter-spring-boot-starter

[![Build Status](https://travis-ci.org/deepexi/pojo-converter-spring-boot-starter.svg?branch=master)](https://travis-ci.org/deepexi/pojo-converter-spring-boot-starter) 
[![codecov](https://codecov.io/gh/deepexi/pojo-converter-spring-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/deepexi/pojo-converter-spring-boot)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.deepexi/payload-spring-boot-starter.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.deepexi%22%20AND%20a:%22payload-spring-boot-starter%22)

项目中用到了各种POJO对象，如VO、DTO、BO；为了方便POJO在不同业务层的转换，
自定义了相应的converter，而使用Converter需要在Spring中进行相应的配置。
配置都是相同的，为避免不必要的重复，从而抽离该部分成为一个独立的starter，方便在Spring Boot中使用.

## 版本信息
支持Spring Boot 2.x的版本

     Spring Boot：2.1.9.RELEASE

## Getting Started
  实现自定义的Converter，然后引入starter坐标后，调用ConverterUtils的方法即可进行转化，具体使用参考[Test Demo](https://github.com/deepexi/pojo-converter-spring-boot-starter/tree/master/src/test)
  
  
### 引入坐标

```xml
<dependency>
    <groupId>com.github.deepexi</groupId>
    <artifactId>pojo-converter-spring-boot-starter</artifactId>
    <version>1.0.0-release</version>
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
      
    
      
