package com.mediation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * 微服务启动入口
 * {@link EnableFeignClients#basePackages()}默认扫描当前类所属包及子包，需要主动声明所需引入的外部服务包路径
 * eg.通过指明org.jeecg来依赖{@link org.jeecg.common.system.api.ISysBaseAPI}
 * {@link SpringBootApplication#scanBasePackages()}默认扫描当前类所属包及子包，显式声明包路径以同时注入其他服务的包
 * eg.通过指明org.jeecg以达到启动时注入{@link org.jeecg.config.shiro.ShiroConfig}等其他服务的Bean
 *
 * 扩展：
 * SpringBoot服务启动时要扫描到带有{@link Configuration}注解的类，所以在启动入口就要指定配置类的包路径
 * 另外一种可行的方式是，在提供基础服务的包中添加配置文件指定配置类，通过starter引入第三方依赖时正是通过这种方式实现的，通常在META-INF/spring.factories中进行指定
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}的值
 */
@EnableFeignClients(basePackages = {"org.jeecg"})
@SpringBootApplication(scanBasePackages = {"com.mediation", "org.jeecg"})
public class MediationPlatformCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediationPlatformCloudApplication.class, args);
    }
}
