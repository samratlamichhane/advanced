package com.restapi.practice.controller;


import com.restapi.practice.model.Blog;
import com.restapi.practice.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class BlogController {

    Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public List<Blog> index() {
        logger.info("This log is in index method");
        List<Blog> result=blogService.index();
        logger.info("this is after blogservice method initiation");
        return result;
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id) {
        return blogService.show(id);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        return blogService.search(body);
    }

    @PostMapping("/blog")
    public void create(@RequestBody Blog body) {
        blogService.create(body);
    }

    @PutMapping("/blog")
    public Blog update(@RequestBody Blog body) {
        return blogService.update(body);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id) {
        return blogService.delete(id);
    }

    @PutMapping("/blog/{id}")
    public Blog change(@PathParam("id") String id, @RequestBody Blog blog) {
        return blogService.change(id, blog);
    }


}