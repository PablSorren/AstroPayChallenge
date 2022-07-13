package com.dominio.astropay.repositories;

import com.dominio.astropay.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {


  public List<Post> findAllByTitleContaining(String word);
}
