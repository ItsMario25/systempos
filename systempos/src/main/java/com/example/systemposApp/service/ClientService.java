package com.example.systemposApp.service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.entity.Client;

public interface ClientService {

	public Iterable<Client> getAllClients();
	
	public Client createClient(Client client)throws Exception;
	
	public Client getClientById(Long id) throws Exception;
	
	public Client updateClient(Client client) throws Exception;
	
	public void deleteClient(Long id) throws UsernameOrldNotFound;
	
}
