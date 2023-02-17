package com.bilgeadam.MovieAppJava5.repository;

import com.bilgeadam.MovieAppJava5.repository.entity.Movie;
import com.bilgeadam.MovieAppJava5.repository.entity.MovieComment;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {


    @Query("select  m from MovieComment  as m where m.movie.id=?1")
    List<MovieComment> findAllByMyMovies(Long movieId);
    List<MovieComment> findAllByMovie_Id(Long movieId);
    List<MovieComment> findAllByMovie_Name(String name);
    List<MovieComment> findAllByMovie(Movie movie);

    List<MovieComment> findAllByUser_Id(Long userId);

    @Query(value = "select * from movie_comment inner join movie on movie_comment.movie_id = movie.id where movie.name=?1 and  movie_comment.date between ?2 and ?3 ",nativeQuery = true)
    List<MovieComment> movieCommentBetweenDates(String name, LocalDate date1, LocalDate date2);

    //List<MovieComment>findAllByDateBetweenAndUser_Id(LocalDate start,LocalDate end,Long id);

    @Query(value = "select * from movie_comment inner join tbl_user on movie_comment.user_id = tbl_user.id where tbl_user.id = ?1",nativeQuery = true)
    List<MovieComment> moviecomments(Long id);

    @Query(value = "select * from movie_comment inner join tbl_user on movie_comment.user_id = tbl_user.id where tbl_user.id=?1 and  movie_comment.date between ?2 and ?3 ",nativeQuery = true)
    List<MovieComment> usercommentsbetween(Long id, LocalDate date1, LocalDate date2);

    //List<MovieComment> findAllByMovie_NameAndDateBetween(String name, LocalDate date1, LocalDate date2);

    List<MovieComment> findAllByContentContainingIgnoreCase(String value);


    @Query("select m from MovieComment  m where length(m.content)>?1 ")
    List<MovieComment> findByLength(Integer length);

}
