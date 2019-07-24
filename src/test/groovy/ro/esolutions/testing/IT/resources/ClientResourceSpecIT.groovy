package ro.esolutions.testing.IT.resources

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import ro.esolutions.testing.entities.Client
import ro.esolutions.testing.repositories.ClientRepository
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD
import static ro.esolutions.testing.testData.ClientGenerator.aClient
import static ro.esolutions.testing.testData.ClientGenerator.aClientForIt
import static ro.esolutions.testing.testData.ClientGenerator.aClientModel

@ContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ClientResourceSpecIT extends Specification{

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    ClientRepository clientRepository

    @SqlGroup(
            @Sql(value = '/sql/client.sql', executionPhase = BEFORE_TEST_METHOD)
    )
    def 'find all clients'() {
        given:
        def url = '/client/all'
        def client = aClientForIt()

        when:
        def result = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {})

        then:
        result.getStatusCode() == HttpStatus.OK
        result.getBody() == [client]
    }

    def 'save new client'() {
        given:
        def clientModel = aClientModel(id: -2, type: Client.Type.NEW, name: 'Ben Dover')

        when:
        def result = restTemplate.postForEntity('/client', clientModel, null)

        then:
        clientRepository.findById(-2L).get() == aClient(id: -2, type: Client.Type.NEW, name: 'Ben Dover', isActive: true)
        result.statusCode == HttpStatus.OK
    }

}
