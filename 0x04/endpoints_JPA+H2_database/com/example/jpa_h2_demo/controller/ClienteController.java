package com.example.jpa_h2_demo.controller;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();

        if (clientes.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        return clienteRepository.findById(idClient)
                .map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Cliente clienteAntigo = clienteRepository.findById(id).orElseThrow();

        if (clienteAntigo.getId() != null) {
            clienteRepository.save(cliente);
        }
    }
}
