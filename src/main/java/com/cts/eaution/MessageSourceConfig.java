package com.cts.eaution;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


/**
 * @author aadi
 * Bean configuration class for locale support in messages
 *
 */
@Configuration
public class MessageSourceConfig {
    /**
     * @return LocalValidatorFactoryBean
     * To configure LocalValidatorFactoryBean for messages
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    /**
     * @return MessageSource
     * Configuring message source
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
        bundle.setBasenames("messages");
        return bundle;
    }
}
