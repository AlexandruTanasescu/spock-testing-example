package ro.esolutions.testing.IT

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import ro.esolutions.testing.Client
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static ro.esolutions.testing.Client.Type.LOYAL

@ContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ClientResourceSpecIT extends Specification{

    @Autowired
    TestRestTemplate restTemplate

    def 'find all clients'() {
        given:
        def url = '/client/all'
        def client = new Client(1, 'Alex', true, LOYAL)

        when:
        def result = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {})

        then:
        result.getStatusCode() == HttpStatus.OK
        result.getBody() == [client]
    }

}
