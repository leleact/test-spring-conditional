package com.github.leleact.test.spring.condition;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;


@Configuration
public class AutoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoConfiguration.class);

    @org.springframework.context.annotation.Configuration
    @Import({ImportRegister.class})
    @ConditionalOnMissingBean(ConditionalBean.class)
    public static class ShouldNotBeCreatedBean {

        public ShouldNotBeCreatedBean() {
            LOGGER.info("{} created", this.getClass().getName());
        }

        @PostConstruct
        public void afterPropertiesSet() {
            LOGGER.info("SHOULD NOT PRINT");
        }
    }

    public static class ImportRegister implements BeanFactoryAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware {

        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            LOGGER.info("setBeanFactory");
        }

        public void setResourceLoader(ResourceLoader resourceLoader) {
            LOGGER.info("setResourceLoader");

        }

        public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                BeanDefinitionRegistry beanDefinitionRegistry) {
            LOGGER.info("registerBeanDefinitions");
        }
    }

}
