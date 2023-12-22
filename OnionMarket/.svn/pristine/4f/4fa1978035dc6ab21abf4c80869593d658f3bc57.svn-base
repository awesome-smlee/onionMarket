package kr.or.ddit.adm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {

private static NoticeDaoImpl dao;
	
	private NoticeDaoImpl() {}
	
	public static NoticeDaoImpl getInstance() {
		if(dao==null) dao = new NoticeDaoImpl();
		return dao;
	}
	
	@Override
	public List<NoticeVO> getAllNotice() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<NoticeVO> noticeList = null;
		
		try {
			noticeList = session.selectList("notice.getAllNotice");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return noticeList;
	}
	@Override
	public int insertNotice(NoticeVO notiVo) {
		SqlSession session = MybatisUtil.getSqlSession();
	
		int cnt = 0;
		
		try {
			cnt = session.insert("notice.insertNotice",notiVo);
			if(cnt>0) session.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
	
		return cnt;
	}
	
	@Override
	public NoticeVO getNotice(String tit) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		NoticeVO titNoticeVo = null;
		try {
			titNoticeVo = session.selectOne("notice.getNotice",tit);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return titNoticeVo;
	}

}
