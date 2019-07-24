package ro.esolutions.testing.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.testing.entities.Client;
import ro.esolutions.testing.models.ClientModel;
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

    public void saveOrUpdateClient(final ClientModel clientModel) {
        Client clientToBeSaved = clientRepository.findById(clientModel.getId())
                .map(clientEntity -> {
                    clientEntity.setName(clientModel.getName());
                    clientEntity.setType(clientModel.getType());
                    return clientEntity;
                })
                .orElseGet(() -> Client.builder()
                        .id(clientModel.getId())
                        .name(clientModel.getName())
                        .type(clientModel.getType())
                        .isActive(true)
                        .build()
                );
        clientRepository.save(clientToBeSaved);
    }
}
