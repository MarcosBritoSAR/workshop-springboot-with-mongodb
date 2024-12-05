package com.compass.marcosbrito.semana5.services;

import com.compass.marcosbrito.semana5.domain.User;
import com.compass.marcosbrito.semana5.dto.UserDTO;
import com.compass.marcosbrito.semana5.repository.UserRepository;
import com.compass.marcosbrito.semana5.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj); // mongo ja tem certinho o meodo de insert
    }

    public void delete(String id) {
        findById(id); //fasz uma busca primeiro, se não encontrar, ele lança um id
        repo.deleteById(id);
    }

    public User update(User obj) {  //Relizando o update
        User newObj = findById(obj.getId()); //Busca o objeto original
        updateData(newObj, obj);// Faz a atualizacao do objeto
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {//Recebe um dto e o converte para USer
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
