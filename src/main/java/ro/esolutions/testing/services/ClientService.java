package ro.esolutions.testing.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.testing.entities.Client;
import ro.esolutions.testing.repositories.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    @NonNull
    ClientRepository clientRepository;

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
