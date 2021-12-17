package com.cuatroa.retotres.repository.crud;

import java.util.List;

import com.cuatroa.retotres.model.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author 
 */
public interface CookwareCrudRepository extends MongoRepository<Cookware, String> {
    
//Reto 5
public List<Cookware> findByPriceLessThanEqual(double precio);
    
//Reto 5
@Query("{'description':{'$regex':'?0','$options':'i'}}")
public List<Cookware> findByDescriptionLike(String description);
}
