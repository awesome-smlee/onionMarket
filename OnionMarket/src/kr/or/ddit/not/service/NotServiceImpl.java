package kr.or.ddit.not.service;

import java.util.List;

import kr.or.ddit.not.dao.INotDao;
import kr.or.ddit.not.dao.NotDaoImpl;
import kr.or.ddit.vo.NotVO;

public class NotServiceImpl implements INotService {
	// 1번
	private static NotServiceImpl service;

	private INotDao dao; // DAO객체 변수 선언

	// 생성자 ==> 2번
	private NotServiceImpl() {
		dao = NotDaoImpl.getInstance(); // DAO객체 생성
	}

	// 3번
	public static NotServiceImpl getInstance() {
		if (service == null)
			service = new NotServiceImpl();

		return service;
	}

	@Override
	public List<NotVO> getAllNot() {
		return dao.getAllNot();
	}

	public int getListCount(int notiId) {// 공지사항 카운트
		return dao.getListCount(notiId);
	}

	@Override
	public NotVO getNotNum(String notNum) {
		return dao.getNotNum(notNum);
	}

	@Override
	public List<NotVO> searchNot(String option, String keyword) {
 		return dao.searchNot(option, keyword);
	}

	@Override
	public int updateNot(int noti_id) {
			return dao.updateNot( noti_id);
	}
}
