package org.zerock.guestbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.guestbook.entity.Board;
import org.zerock.guestbook.repository.search.SearchBoardRepository;

import java.util.List;

//public interface BoardRepository extends JpaRepository<Board, Long> {

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository {

    @Query("select b, w from Board b left join b.writer w where b.bno =:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    @Query("SELECT b, r FROM Board b LEFT JOIN Reply r ON r.board = b WHERE b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    /**
     * 게시판 목록 조회
     * 
     * @param pageable 페이지 기본 제공 객체
     * @return 보드 객체, 멤버 객체, 댓글 수
     */
    @Query(value = "SELECT b, w, count(r) " +
            " FROM Board b " +
            " LEFT JOIN b.writer w " +
            " LEFT JOIN Reply r ON r.board = b " +
            " GROUP BY b",
            countQuery = "SELECT count(b) FROM Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);


    /**
     * 게시판 단건 글 조회
     * 
     * @param bno 글 번호(pk)
     * @return 보드 객체
     */
    @Query("SELECT b, w, count(r) " +
            " FROM Board b LEFT JOIN b.writer w " +
            " LEFT OUTER JOIN Reply r ON r.board = b" +
            " WHERE b.bno = :bno")
    Object getBoardByBno(@Param("bno") Long bno);


}
