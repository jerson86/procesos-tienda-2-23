package com.procesos.tienda.service;

import com.procesos.tienda.model.Address;
import com.procesos.tienda.model.User;
import com.procesos.tienda.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;

    public Address createAddress(Address address, Long idUser){
        User user = userService.getUserById(idUser);
        if(user == null){
            throw new RuntimeException("User not found");
        }
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address updateStatusAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            throw new RuntimeException("address not found");
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }

    public Address getByIdAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            throw new RuntimeException("address not found");
        }
        return address.get();
    }

    public List<Address> findAllAddress(){
        return (List<Address>) addressRepository.findAll();
    }
}
