package com.example.practice.dinner.Service;

import com.example.practice.dinner.Dao.RandomDao;
import com.example.practice.dinner.persistance.RandomVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RandomService {
    @Autowired
    RandomDao randomDao;

    public List<HashMap> list() {

        List<HashMap> result = randomDao.list();

        return result;

    }

    public void nameSave(String userName) {

        RandomVo randomVo = new RandomVo();
        randomVo.setUserName(userName);

        // 랜담깁ㅈㅅ 생성

        /* randomVo.setNumber(랜덤값);*/

        randomDao.nameSave(randomVo);
    }


    //seetNum 중복값 생기지 않도록
    // 기존에 채번이 된 값이 있으면 안뽑힌 값이 나올때까지 랜덤 값 생성
    public RandomVo nameInsert(String userName) {

        RandomVo randomVo = new RandomVo(); // 새로운 RandomVo 객체를 생성
        randomVo.setUserName(userName); //setUserName: RandomVo 객체에 userName(사용자이름)을 설정

        RandomVo nameResult = randomDao.nameInsert(randomVo); //nameInsert: RandomDao 객체의 nameInsert 메서드를 호출하여 DB에 이름을 삽입하고 결과를 받음


        // 조건문: nameResult 가 null이 아닌 경우 (DB에 사용자가 있을 경우)
        if (nameResult != null) {
            // 조건문: nameResult의 sheetNum이 0인 경우 (아직 자리가 배정되지 않은 경우)
            if (nameResult.getSheetNum() == 0) {
                // 이미 배정된 자리 조회
                //'RandomDao'의 'listAssignedSeats' 메서드를 호출해서 이미 배정된 자리 목록을 'List'형태로 가져오는데 RandomVo 객체로 이루어져 있음
                List<RandomVo> assignedList = randomDao.listAssignedSeats();
                /* 'set' 인터페이스는 중복을 허용하지 않는 데이터의 집합으로 'Integer' 타입의 데이터를 저장
                * 이미 배정된 자리를 저장할 'HashSet' 객체를 생성하고, 중복된 자리 번호를 허용하지 않으므로 각 자리 번호가 중복되지 않음 */
                Set<Integer> assignedSeats = new HashSet<>();

                /* 확장 for문 > for (타입 변수명: 배열 또는 컬랙션){배열 또는 컬랙션에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀져 변수에 저장됨}
                'vo' 변수를 선언하고, 'assignedList' 배열에 대한 것을 출력하는 확장 for문 이다.
                 */
                for (RandomVo vo : assignedList) { // assignedList의 각 요소에 대해 반복
                    assignedSeats.add(vo.getSheetNum()); // 각 요소의 sheetNum 값을 assignedSeats에 추가
                }

               // 중복되지 않는 자리 배정
                int sheetNumber; // 배정할 자리 번호를 저장할 변수를 선언

                // do while 문을 쓰는 이유 ? 어떤 행동을 최소 1회 수행해야만 반복 여부가 결정되는 경우에 do while 문을 쓰는 것이 적절함
                do {
                    sheetNumber = (int) (Math.random() * 23) + 1; // Math.random(): 0과 1 사이의 랜덤 숫자를 생성 > 이를 23을 곱하고 1을 더하면 1부터 23까지으 숫자를 생성
                } while (assignedSeats.contains(sheetNumber));
                // setSheetNum: 생성한 랜덤 숫자를 nameResult 객체의 sheetNum에 설정(중복되지 않는 자리 번호를 설정)
                nameResult.setSheetNum(sheetNumber);
                // update: RandomDao 객체의 update 메서드를 호출하여 DB에 업데이트
                randomDao.update(nameResult);
            } else {
                // 이미 자리가 배정된 경우 에러 메시지 표시
                final String errMsg = "이미 자리가 배정 되었습니다. 자리 : " + nameResult.getSheetNum();
                nameResult.setErrMsg(errMsg);
            }
            return nameResult; // 업데이트된 nameResult 객체를 반환
        }
        return null; // nameResult가 null 인 경우(디비에 해당 사용자가 없는 경우 randomVo 객체를 반환한다)
    }

    public List<RandomVo> select(RandomVo randomVo) {

        List<RandomVo> result = randomDao.selectTRandom(randomVo); //randomDao 객체의 selectTRandom 메서드를 호출하여 데이터 베이스에서 특정 조건으로 조회한 결과를 가져옴

        return result; // 가져온 결과를 반환
    }
}


