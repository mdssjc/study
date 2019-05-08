package com.github.mdssjc.repositories;

import com.github.mdssjc.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
