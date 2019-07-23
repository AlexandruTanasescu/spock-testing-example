package ro.esolutions.testing.resources

import org.springframework.http.ResponseEntity
import ro.esolutions.testing.ClientResource
import ro.esolutions.testing.ClientService
import spock.lang.Specification
import spock.lang.Subject

class ClientResourceSpec extends Specification{

    def clientService = Mock(ClientService)

    @Subject
    def clientResource = new ClientResource(clientService)

    def 'find all clients'(){
        when:
        def result = clientResource.findAllClients()

        then:
        1 * clientService.findAllClients() >> []
        0 * _

        and:
        result == ResponseEntity.ok([])
    }

}
