package com.example.practice.oldfiles.jinaBoard.boardservice;

import com.example.practice.oldfiles.jinaBoard.boaddao.BoardDao;
import com.example.practice.oldfiles.jinaBoard.persistance.BoardVO;
import com.example.practice.oldfiles.jinaBoard.persistance.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {


    public List<String> ArrayList;
    @Autowired
    BoardDao boardDao;


    public List<HashMap> list() {

        List<HashMap> result = boardDao.list();

        return result;
    }


    public List<HashMap> list2() {

        List<HashMap> result = boardDao.list2();

        return result;
    }

    public void insert2(String title, String regId) {

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setRegId(regId);

        boardDao.insert2(boardVO);
    }


   public void update2(String id, String title, String modId) {
        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.valueOf(id));
        boardVO.setTitle(title);
        boardVO.setModId(modId);
        boardVO.setModDt(LocalDateTime.now());

        boardDao.update2(boardVO);
    }

    public void delete2(String id) {

        boardDao.delete2(id);
    }

    public void save(TestVO testVo) {

        BoardVO boardVO = new BoardVO(); // title, regID의 경우 t_board와 연결되므로 BoardVO 하나 만들어 줌
        boardVO.setTitle(testVo.getTitle()); // testVO에서 title 정보를 가져와서  boardVO로 넣어준다
        boardVO.setRegId(testVo.getRegId()); // testVO에서 regId 정보를 가져와서 boardVO로 넣어준다

        // 1. 제목부터 저장
        boardDao.saveTboard(boardVO); //insert > boardVO

        // 2. 제목의 ID(PK) 조회
        Long id = boardDao.findMaxId(boardVO); // 제목의 id 를 조회해서

        testVo.setRefId(id); // testVO의 refId에 넣어준다

        // 3. 상세내용 저장
        boardDao.saveTest(testVo);

    }



        /**
         * 1. 부모테이블 insert : t_board.id
         * 2. 방금 등록된 부모테이블의 ID를 가져 옴
         * 3. 자식테이블 insert : test
         * 4. 자식테이블 insert 할 때, ref_id에다가!! 부모테이블에서 가져온 id 를 넣어 줌.
         * 5. tboard.id : 13 == test.ref_id : 13 이렇게 되면 나중에 조회할 때, t_baord.ref_id = test.ref_id 로 조인 가능!!

         * */

    }

