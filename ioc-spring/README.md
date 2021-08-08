## Ioc, DI (2)

* ApplicationContextProvider.java
``` java
package me.sungbin.iocspring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}

```

* Base64Encoder.java
``` java
package me.sungbin.iocspring;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder")
public class Base64Encoder implements IEncoder {

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}

```

* Encoder.java
``` java
package me.sungbin.iocspring;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder( IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public void setiEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}

```

* IEncoder.java
``` java
package me.sungbin.iocspring;

@FunctionalInterface
public interface IEncoder {
    String encode(String message);
}
```

* UrlEncoder.java
``` java
package me.sungbin.iocspring;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class UrlEncoder implements IEncoder {

    public String encode(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

* IocSpringApplication.java
``` java
package me.sungbin.iocspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocSpringApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);


        Encoder encoder = context.getBean("urlEncode", Encoder.class);

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);
        System.out.println(result);
    }
}

@Configuration
class AppConfig {

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}

```
