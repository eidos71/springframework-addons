package net.unicon.springframework.properties;

public interface ReconfigurableBean {
    void reloadConfiguration() throws Exception;
}
