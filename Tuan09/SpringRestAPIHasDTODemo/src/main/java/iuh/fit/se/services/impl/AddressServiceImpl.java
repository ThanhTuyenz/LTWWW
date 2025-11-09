package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Address;
import iuh.fit.se.repositories.AddressRepository;
import iuh.fit.se.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
    private AddressRepository addressRepository;
    
	@Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }
}
