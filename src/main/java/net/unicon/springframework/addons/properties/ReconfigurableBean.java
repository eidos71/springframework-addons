package net.unicon.springframework.addons.properties;

public interface ReconfigurableBean {
    void reloadConfiguration() throws Exception;
}
