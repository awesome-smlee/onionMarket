package kr.or.ddit.adm.dao;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeDao {

	public List<NoticeVO> getAllNotice();
	
	public int insertNotice(NoticeVO notiVo);
	
	public NoticeVO getNotice(String tit);
}
