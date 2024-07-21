package com.hameed.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hameed.todo.entities.Todo;
import com.hameed.todo.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepo;

	public List<Todo> fetchAllTodos(){
		return todoRepo.findAll();
	}
	
	public Todo updateTodoItem(Integer id, Todo todoItem) {
		Optional<Todo> todoOpt = todoRepo.findById(id);
		
		if (todoOpt.isPresent()) {
			Todo item = todoOpt.get();
			item.setIsDone(todoItem.getIsDone());
			item.setTask(todoItem.getTask());
			todoRepo.save(item);
			return item;
		}
		
		return null;
		
	}
	
	public Todo createNewTodoItem() {
		Todo todoItem = new Todo();
		todoItem.setIsDone(false);
		todoItem = todoRepo.save(todoItem);
		todoItem.setTask("Click to edit task name");
		todoRepo.save(todoItem);
		return todoItem;
	}
	
	public void deleteTodoItem(Integer id) {
		todoRepo.deleteById(id);
	}
}
