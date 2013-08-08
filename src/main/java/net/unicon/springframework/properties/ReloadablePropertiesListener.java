package net.unicon.springframework.properties;

public interface ReloadablePropertiesListener {
    void propertiesReloaded(PropertiesReloadedEvent event);
}
