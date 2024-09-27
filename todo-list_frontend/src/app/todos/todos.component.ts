import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TodoService, TodoItem } from '../todo.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-todos',
  standalone: true,
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css'],
  imports: [FormsModule, NgFor, NgIf],
  providers: [TodoService],
})
export class TodosComponent implements OnInit {
  todos: TodoItem[] = [];
  newTodo: string = '';

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    this.getTodos();
  }

  getTodos(): void {
    this.todoService.getTodos().subscribe((todos) => (this.todos = todos));
  }

  addTodo(): void {
    if (this.newTodo.trim()) {
      const newTodo: TodoItem = {
        id: 0,
        title: this.newTodo,
        completed: false,
      };
      this.todoService.addTodo(newTodo).subscribe((todo) => {
        this.todos.push(todo);
        this.newTodo = '';
      });
    }
  }

  toggleComplete(todo: TodoItem): void {
    todo.completed = !todo.completed;
    this.todoService.updateTodo(todo).subscribe();
  }

  deleteTodo(id: number): void {
    this.todoService.deleteTodo(id).subscribe(() => {
      this.todos = this.todos.filter((todo) => todo.id !== id);
    });
  }
}
