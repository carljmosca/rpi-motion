/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.motion.internal.repository;

import com.moscaville.motion.entity.Image;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author moscac
 */
@RepositoryRestResource(collectionResourceRel = "images", path = "images")
public interface ImageRepository extends PagingAndSortingRepository<Image, Integer> {
    
    
    @Query("select i from Image i where i.imageSource.id = :imageSourceId")
    List<Image> findByImageSource(@Param("imageSourceId") Integer imageSourceId);
    
    //List<Image> findByImageSourceId(@Param("imageSourceId") Integer imageSourceId);
    
    /**
     *
     * @param t
     */
    @Override
    @RestResource(exported = false)
    public void delete(Image t);
}
