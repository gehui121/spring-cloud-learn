package com.mayikt;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyCommandLineRunner
 * @Description 项目监听，在项目启动时执行一次，之后每次修改后监听修改内容
 *             分布式阿波罗分布配置中心监听方法，这个监听开启线程会一直长连接，不建议开启多个，
 * @Author gehui
 * @Date 2019/1/24 20:41
 * @Version 1.0
 **/
@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @ApolloConfig
    private Config config;

    @Override
    public void run(String... args) throws Exception {
        log.info("监听项目开始。。。。。。。。。。。");
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent configChangeEvent) {
                for (String key : configChangeEvent.changedKeys()) {
                    ConfigChange change = configChangeEvent.getChange(key);
                    log.info(String.format(
                            "Found change - key: %s, old6Value: %s, newValue: %s, changeType: %s",
                            change.getPropertyName(), change.getOldValue(),
                            change.getNewValue(), change.getChangeType()));
                }
            }
        });
    }
}
