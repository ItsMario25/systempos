package com.example.systemposApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Client;
import com.example.systemposApp.repository.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Iterable<Client> getAllClients() {
		return repository.findAll();
	}
	
	@Override
	public Client createClient(Client client) throws Exception {
		client = repository.save(client);
		return client;
	}

	@Override
	public Client getClientById(Long id) throws UsernameOrldNotFound {
		return repository.findById(id).orElseThrow(() -> new UsernameOrldNotFound("El Id del cliente no existe."));
	}

	@Override
	public Client updateClient(Client fromclient) throws Exception {
		Client toClient = getClientById(fromclient.getId());
		mapClient(fromclient, toClient);
		return repository.save(toClient);
	}
	
	protected void mapClient(Client from,Client to) {
		to.setDocument(from.getDocument());
		to.setAddress(from.getAddress());
		to.setPhone(from.getPhone());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteClient(Long id) throws UsernameOrldNotFound {
		Client client = getClientById(id);
		repository.delete(client);
	}


}
