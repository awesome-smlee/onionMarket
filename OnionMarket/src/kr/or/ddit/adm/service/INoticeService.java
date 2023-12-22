package kr.or.ddit.adm.service;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {

	public List<NoticeVO> getAllNotice();
	
	public int insertNotice(NoticeVO notiVo);
	
	public NoticeVO getNotice(String tit);
}
