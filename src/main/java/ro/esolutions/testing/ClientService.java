package ro.esolutions.testing;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
