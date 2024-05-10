package com.urlShortner.demo.dao;

import com.urlShortner.demo.Entity.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<Url,Integer> {

}
