package com.lssjzmn.core.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class ExtendedPropertyPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {
    private Properties props;

    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactory, Properties props)
            throws BeansException {
        super.processProperties(beanFactory, props);
        this.props = props;
    }

    public Object getProperty(String key) {
        return props.get(key);
    }
}