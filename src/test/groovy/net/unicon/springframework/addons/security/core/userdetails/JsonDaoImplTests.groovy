package net.unicon.springframework.addons.security.core.userdetails
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import org.springframework.core.io.ClassPathResource
import spock.lang.Specification

/**
 * @author @author <a href="mailto:mmoayyed@unicon.net">Misagh Moayyed</a>
 * @author Unicon , inc.
 */
@RunWith(Sputnik)
class JsonDaoImplTests extends Specification {

    def resource = new ClassPathResource("userDetailsService.json")
    def dao = new JsonDaoImpl(resource)

    def "User definitions must be able to find user1"() {
        when:
        def details = dao.loadUserByUsername("user1")
        then:
        details != null
        and:
        details.getUsername().equals("user1")
        and:
        details.getAuthorities().size() == 2
    }
}
