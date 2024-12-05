package com.compass.marcosbrito.semana5.repository;

import com.compass.marcosbrito.semana5.domain.Post;
import com.compass.marcosbrito.semana5.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    /*
     Usando Query procurar post com um determinado texto
     */

    //.
    /*'title': - Cmapo
     { $regex: ?0, -> Priemrio parametro
     $options: 'i' } -> Iginera as Stirng
    * */
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);


    //Tenho que verificar 3 condioes Ands. Sendo 2 para verificar as datas e 2 para verificar se pertente a um dos campos Post, Title ou Comment
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
