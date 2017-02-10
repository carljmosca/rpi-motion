/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.motion.internal.repository;

import com.moscaville.motion.entity.ImageSource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author moscac
 */
@RepositoryRestResource(collectionResourceRel = "imagesources", path = "imagesources")
public interface ImageSourceRepository extends PagingAndSortingRepository<ImageSource, Integer> {

    @Override
    @RestResource(exported = false)
    public void delete(ImageSource t);
}
