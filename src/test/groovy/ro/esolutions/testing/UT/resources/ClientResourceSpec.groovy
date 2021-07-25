package ro.esolutions.testing.UT.resources

import org.springframework.http.ResponseEntity
import ro.esolutions.testing.resources.ClientResource
import ro.esolutions.testing.services.ClientService
import spock.lang.Specification
import spock.lang.Subject

import static ro.esolutions.testing.testData.ClientGenerator.aClient

class ClientResourceSpec extends Specification{

    def clientService = Mock(ClientService)

    @Subject
    def clientResource = new ClientResource(clientService)

    def 'find all clients'(){
        given:
        def aClientList = [aClient()]

        when:
        def result = clientResource.findAllClients()

        then:
        1 * clientService.findAllClients() >> aClientList
        0 * _

        and:
        result == ResponseEntity.ok(aClientList)
    }

}
