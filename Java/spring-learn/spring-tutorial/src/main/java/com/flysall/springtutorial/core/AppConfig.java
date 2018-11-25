package com.flysall.springtutorial.core;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean
    @Lazy
    public TextEditor textEditor() {
        return new TextEditor(spellChecker());
    }

    @Bean
    @Lazy
    public SpellChecker spellChecker() {
        return new SpellChecker();
    }

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    @Scope("prototype")
    @Lazy
    public ConfigLifeCycleDemo configLifeCycleDemo() {
        return new ConfigLifeCycleDemo();
    }
}
