package com.compass.marcosbrito.semana5.services;

import com.compass.marcosbrito.semana5.domain.Post;
import com.compass.marcosbrito.semana5.repository.PostRepository;
import com.compass.marcosbrito.semana5.services.Exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PostService {
    //
    @Autowired
    private PostRepository repo;

    //
    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id); //Habilitei isso
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        /*Cria a camada intermediaraia para o FullSearch
         */
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        /*
        Adicionando + 1 dia. Não entendi o por que ainda.
         */
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}