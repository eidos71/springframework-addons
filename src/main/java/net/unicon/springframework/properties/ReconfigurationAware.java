package net.unicon.springframework.properties;

/**
 */
public interface ReconfigurationAware {
    public void beforeReconfiguration() throws Exception;

    ;

    public void afterReconfiguration() throws Exception;

    ;
}
