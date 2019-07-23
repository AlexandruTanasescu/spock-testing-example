package ro.esolutions.testing;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientResource {

    @NonNull
    ClientService clientService;

    @GetMapping("/all")
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }


}
