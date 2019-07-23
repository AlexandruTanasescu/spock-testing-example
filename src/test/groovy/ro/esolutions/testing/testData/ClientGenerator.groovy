package ro.esolutions.testing.testData

import ro.esolutions.testing.entities.Client

class ClientGenerator {

    static Client aClient(Map overrides = [:]) {
        Map defaultValues = [
                id      : 1,
                name    : 'Alex',
                isActive: true,
                type    : Client.Type.LOYAL
        ]
        defaultValues << overrides
        new Client(defaultValues)
    }

    static Client aClientForIt(Map overrides = [:]) {
        Map defaultValues = [
                id      : 1,
                name    : 'clientName',
                isActive: true,
                type    : Client.Type.LOYAL
        ]
        defaultValues << overrides
        new Client(defaultValues)
    }
}
