package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.MemberTwo;
import org.zerock.guestbook.entity.Movie;
import org.zerock.guestbook.entity.Review;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMoviewReviews() {

        //200개의 리뷰를 등록
        IntStream.rangeClosed(1, 200).forEach(i -> {

            //영화 번호
            Long mno = (long) (Math.random() * 100) + 1;

            //리뷰어 번호
            Long mid = ((long) (Math.random() * 100) + 1);
            MemberTwo member = MemberTwo.builder().mid(mid).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int) (Math.random() * 5) + 1)
                    .text("이 영화에 대한 느낌..." + i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }

    @Test
    public void testGetMovieReviews() {

        Movie movie = Movie.builder().mno(92L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {

            System.out.print("l~ \t" + movieReview.getReviewnum());
            System.out.print("l~ \t" + movieReview.getGrade());
            System.out.print("l~ \t" + movieReview.getText());
            System.out.print("l~ \t" + movieReview.getMember().getEmail());
            System.out.println("l~ ---------------------------");
        });
    }

}
