package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {

	public List<NoticeVO> getAllNotice();
	
	public int insertNotice(NoticeVO notiVo);
	
	public NoticeVO getNotice(String tit);
}
