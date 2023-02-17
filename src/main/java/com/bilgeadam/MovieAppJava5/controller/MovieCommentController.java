package com.bilgeadam.MovieAppJava5.controller;

import com.bilgeadam.MovieAppJava5.repository.entity.MovieComment;
import com.bilgeadam.MovieAppJava5.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;


    @GetMapping("/findallbymovie")
    public ResponseEntity< List<MovieComment>> findAllByMyMovies(Long movieId){
        return ResponseEntity.ok( movieCommentService.findAllByMyMovies(movieId));
    }
    @GetMapping("/findallbymovie2")
    public  ResponseEntity< List<MovieComment>> findAllByMovie_Id(Long movieId){
        return ResponseEntity.ok(movieCommentService.findAllByMovie_Id(movieId));
    }
    @GetMapping("/findallbyuser")
    public  ResponseEntity< List<MovieComment>> findAllByUser_Id(Long userId){
        return ResponseEntity.ok(movieCommentService.findAllByUser_Id(userId));
    }

    @GetMapping("/moviecommentbetweendates")
    public ResponseEntity<List<MovieComment>> movieCommentBetweenDates(String name, String date1, String date2){
        return ResponseEntity.ok(movieCommentService.movieCommentBetweenDates(name,date1,date2));
    }

    @GetMapping("/moviecomments")
    public ResponseEntity<List<MovieComment>> movieComments(Long id){
        return ResponseEntity.ok(movieCommentService.movieComments(id));
    }
    @GetMapping("/usercomments")
    public ResponseEntity<List<MovieComment>> usercommentsbetween(Long id, String date1, String date2){
        return ResponseEntity.ok(movieCommentService.usercommentsbetween(id,date1,date2));
    }
    @GetMapping("/cokguzel")
    public ResponseEntity<List<MovieComment>> findAllByContentContainingIgnoreCase(String value){
        return ResponseEntity.ok(movieCommentService.findAllByContentContainingIgnoreCase(value));
    }
    @GetMapping("/findbylength")
    public ResponseEntity<List<MovieComment>> findByLength(Integer length){
        return ResponseEntity.ok(movieCommentService.findByLength(length));
    }
}
