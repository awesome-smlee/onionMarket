package kr.or.ddit.not.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.NotVO;

public class NotDaoImpl implements INotDao {

	// 1번
	private static NotDaoImpl dao;

	// 2번 - 생성자
	private NotDaoImpl() {
	}

	// 3번
	public static NotDaoImpl getInstance() {
		if (dao == null)
			dao = new NotDaoImpl();

		return dao;
	}

	@Override
	public List<NotVO> getAllNot() {
		SqlSession session = MybatisUtil.getSqlSession();
		List<NotVO> notList = null; // 반환값이 저장될 변수

		try {
			notList = session.selectList("not.getAllNot");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return notList;
	}

	public int getListCount(int notiId) {
		SqlSession session = MybatisUtil.getSqlSession();
		int count = 0;
		try {
			count = session.selectOne("not.getListCount", notiId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.commit();
			session.close();
		}
		return count;
	}

	@Override
	public NotVO getNotNum(String notNum) {
SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		
		NotVO getNorNum = null;
		try {
			getNorNum = session.selectOne("not.getNotNum", notNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return getNorNum;
	}
	
	public List<NotVO> searchNot(String option, String keyword){
	    SqlSession session = MybatisUtil.getSqlSession();
	    List<NotVO> notList = null; // 반환값이 저장될 변수

	    try {
	        // 검색 옵션에 따른 쿼리 작성
	        String query = "not.searchNot";
	        if (option.equals("title")) {
	            query = "not.searchByTitle"; // 타이틀에 따른 쿼리 설정
	        } else if (option.equals("contents")) {
	            query = "not.searchByContents"; // 컨텐츠에 따른 쿼리 설정
	        }
	        
	        // 옵션과 키워드를 활용한 검색 쿼리 실행
	        Map<String, String> params = new HashMap<>();
	        params.put("option", option);
	        params.put("keyword", keyword);
	        notList = session.selectList(query, params);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null)
	            session.close();
	    }

	    return notList;
	}

	@Override
	public int updateNot(int noti_id) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    int count = 0;
	    try {
	        count = session.update("not.cntUpNot", noti_id);
	        // 'not.cntUpNot'는 MyBatis 매퍼 XML 파일에서 UPDATE 쿼리를 참조하는 아이디입니다.
	        // 해당 쿼리에는 'UPDATE notice SET vw_cnt = vw_cnt + 1 WHERE noti_id = #{noti_id}'와 같은 형태일 것입니다.
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null)
	            session.commit();
	        session.close();
	    }
	    return count;
	}

}
