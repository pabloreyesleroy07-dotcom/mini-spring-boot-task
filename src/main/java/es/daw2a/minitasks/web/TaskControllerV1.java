package es.daw2a.minitasks.web;

import es.daw2a.minitasks.domain.SimpleTask;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskControllerV1 {

    private final List<SimpleTask> tasks = new ArrayList<>();
    private long currentId = 1L;

    @GetMapping
    public List<SimpleTask> list() {
        return tasks;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SimpleTask create(@RequestBody SimpleTask task) {
        task.setId(currentId++);
        tasks.add(task);
        return task;
    }
}
