package com.bilgeadam.MovieAppJava5.service;

import com.bilgeadam.MovieAppJava5.repository.IMovieCommentRepository;
import com.bilgeadam.MovieAppJava5.repository.IMovieRepository;
import com.bilgeadam.MovieAppJava5.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final IMovieCommentRepository movieCommentRepository;


  public   List<MovieComment> findAllByMyMovies(Long movieId){
        return movieCommentRepository.findAllByMyMovies(movieId);
    }

    public   List<MovieComment> findAllByMovie_Id(Long movieId){
        return movieCommentRepository.findAllByMovie_Id(movieId);
    }

    public  List<MovieComment> findAllByUser_Id(Long userId){

      return movieCommentRepository.findAllByUser_Id(userId);
    }
    public List<MovieComment> movieCommentBetweenDates(String name, String date1, String date2){
      return movieCommentRepository.movieCommentBetweenDates(name,LocalDate.parse(date1),LocalDate.parse(date2));
    }
}
