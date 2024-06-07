package com.example.RTMicroServiceJava.controller;

import com.example.RTMicroServiceJava.entity.Cliente;
import com.example.RTMicroServiceJava.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente createCliente( @RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if (cliente.isPresent()) {
            Cliente clienteToUpdate = cliente.get();
            clienteToUpdate.setNombre(clienteDetails.getNombre());
            clienteToUpdate.setGenero(clienteDetails.getGenero());
            clienteToUpdate.setEdad(clienteDetails.getEdad());
            clienteToUpdate.setIdentificacion(clienteDetails.getIdentificacion());
            clienteToUpdate.setDireccion(clienteDetails.getDireccion());
            clienteToUpdate.setTelefono(clienteDetails.getTelefono());
            clienteToUpdate.setContraseña(clienteDetails.getContraseña());
            clienteToUpdate.setEstado(clienteDetails.getEstado());
            clienteService.saveCliente(clienteToUpdate);
            return ResponseEntity.ok("Cliente actualizado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok("Cliente eliminado con éxito");
    }


}
