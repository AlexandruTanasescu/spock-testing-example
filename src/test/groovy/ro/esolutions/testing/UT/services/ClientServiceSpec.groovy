package ro.esolutions.testing.UT.services

import ro.esolutions.testing.repositories.ClientRepository
import ro.esolutions.testing.services.ClientService
import spock.lang.Specification
import spock.lang.Subject

import static ro.esolutions.testing.testData.ClientGenerator.aClient

class ClientServiceSpec extends Specification {

    def clientRepository = Mock(ClientRepository)

    @Subject
    def clientService = new ClientService(clientRepository)

    def 'find all clients'(){
        given:
        def aClientList = [aClient()]

        when:
        def result = clientService.findAllClients()

        then:
        1 * clientRepository.findAll() >> aClientList
        0 * _

        and:
        result == aClientList
    }

}
