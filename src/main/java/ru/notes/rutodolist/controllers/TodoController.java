package ru.notes.rutodolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.notes.rutodolist.repr.ToDoRepr;
import ru.notes.rutodolist.service.ToDoService;
import ru.notes.rutodolist.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 14.11.2019.
 */
@Controller
public class TodoController {

    private ToDoService toDoService;
    private UserService userService;

    @Autowired
    public TodoController(ToDoService toDoService, UserService userService) {
        this.toDoService = toDoService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(Model model)
    {
     List<ToDoRepr> todos=  toDoService.findToDosByUserId(userService.getCurrentUserId().orElseThrow(()-> new ResourceNotFoundException()));
       model.addAttribute("todo",todos);
        return "index";
    }

    @GetMapping("/todo/{id}")
    public String todoPage(@PathVariable("id") Long id, Model model)
    {
       ToDoRepr toDoRepr= toDoService.findById(id).orElseThrow(()-> new ResourceNotFoundException());
       model.addAttribute("todo",toDoRepr);
        return "todo";
    }
    @GetMapping("/todo/create")
    public String createTodoPage(Model model) {
        model.addAttribute("todo", new ToDoRepr());
        return "todo";
    }

    @PostMapping("/todo/create")
    public String createTodoPost(@ModelAttribute("todo") ToDoRepr toDoRepr) {
        toDoService.save(toDoRepr);
        return "redirect:/";
    }

    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        toDoService.delete(id);
        return "redirect:/";
    }

}
