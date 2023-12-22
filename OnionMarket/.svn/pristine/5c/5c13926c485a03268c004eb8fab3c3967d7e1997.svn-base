package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService{
	
	private static NoticeServiceImpl service;
	
	private INoticeDao dao;
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service ==null) service = new NoticeServiceImpl();
		return service;
	}
	
	@Override
	public List<NoticeVO> getAllNotice(){
		return dao.getAllNotice();
	}
	
	@Override
	public int insertNotice(NoticeVO notiVo) {
		return dao.insertNotice(notiVo);
	}
	
	@Override
	public NoticeVO getNotice(String tit) {
		return dao.getNotice(tit);
	}

}
