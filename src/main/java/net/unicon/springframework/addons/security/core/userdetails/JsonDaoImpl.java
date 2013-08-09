package net.unicon.springframework.addons.security.core.userdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Misagh Moayyed mmoayyed@unicon.net
 * @since 0.1
 */
public final class JsonDaoImpl implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(JsonDaoImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Map<String, User> usersMap = new HashMap<String, User>();
    private final Resource usersConfigFile;

    public JsonDaoImpl(final Resource users) {
        this.usersConfigFile = users;
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        loadUsers();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return this.usersMap.get(username);
    }

    private void loadUsers() {
        try {
            if (this.usersConfigFile.exists() && this.usersConfigFile.getFile().length() > 0) {
                final Set<SimpleUser> users = this.objectMapper.readValue(this.usersConfigFile.getFile(), new TypeReference<Set<SimpleUser>>() { });
                for (final SimpleUser u : users) {
                    this.usersMap.put(u.getUsername(), new User(u.getUsername(), u.getPassword(), u.getAuthorities()));
                }
                logger.debug("Loaded user definitions from {}", this.usersConfigFile.getFilename());
            } else {
                logger.warn("The resource {} is not found, or is empty.");
            }
        } catch (final IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static class SimpleUser {
        private String username;
        private String password;
        private Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

        public SimpleUser() {}

        public SimpleUser(final String username, final String password, final Set<SimpleGrantedAuthority> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(final String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(final String password) {
            this.password = password;
        }

        public Set<SimpleGrantedAuthority> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(final Set<SimpleGrantedAuthority> authorities) {
            this.authorities = authorities;
        }
    }
}
