package net.unicon.springframework.addons.properties;

public interface ReloadablePropertiesListener {
    void propertiesReloaded(PropertiesReloadedEvent event);
}
