package ro.esolutions.testing.resources;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.esolutions.testing.entities.Client;
import ro.esolutions.testing.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientResource {

    @NonNull
    ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> findAllClients(){
        return ResponseEntity.ok(clientService.findAllClients());
    }


}
