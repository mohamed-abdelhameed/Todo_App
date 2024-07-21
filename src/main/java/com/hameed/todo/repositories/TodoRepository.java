package com.hameed.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hameed.todo.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
