package kr.or.ddit.main.service;

import java.util.List;

import kr.or.ddit.main.dao.IMainDao;
import kr.or.ddit.main.dao.MainDaoImpl;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.ProAndCateVO;

public class MainServiceImpl implements IMainService {

	private IMainDao dao;
	private static MainServiceImpl service;
	private MainServiceImpl() {
		dao = MainDaoImpl.getInstance();
	}
	
	public static MainServiceImpl getInstance() {
		if (service == null) service = new MainServiceImpl();
		return service;
	}
	
	@Override
	public List<ProAndCateVO> getProList(ProAndCateVO proVo) {
		
		List<ProAndCateVO> list = dao.getProList(proVo);
		
		// 물품 첨부파일 조회 및 추가
		for(ProAndCateVO proVo2 : list) {
			
			FileInfoVO fileVo = new FileInfoVO();
			fileVo.setProd_id(proVo2.getProd_id());
			
			// 해당 물품 게시글에 첨부 파일 조회 
			List<FileInfoVO> fileList = dao.getProFileList(fileVo);
			proVo2.setFile_list(fileList);
		}
		
		return list;
	}

	@Override
	public List<ComJoinVO> getComList() {
		return dao.getComList();
	}
	
	@Override
	public List<ProAndCateVO> getProListPop() {
		
		List<ProAndCateVO> list = dao.getProListPop();
		
		// 물품 첨부파일 조회 및 추가
		for(ProAndCateVO proVo : list) {
			
			FileInfoVO fileVo = new FileInfoVO();
			fileVo.setProd_id(proVo.getProd_id());
			
			// 해당 물품 게시글에 첨부 파일 조회 
			List<FileInfoVO> fileList = dao.getProFileList(fileVo);
			proVo.setFile_list(fileList);
		}
		
		return list;
	}
	
	@Override
	public List<ProAndCateVO> getProListNew() {
		
		List<ProAndCateVO> list = dao.getProListNew();
		
		// 물품 첨부파일 조회 및 추가
		for(ProAndCateVO proVo : list) {
			
			FileInfoVO fileVo = new FileInfoVO();
			fileVo.setProd_id(proVo.getProd_id());
			
			// 해당 물품 게시글에 첨부 파일 조회 
			List<FileInfoVO> fileList = dao.getProFileList(fileVo);
			proVo.setFile_list(fileList);
		}
		
		return list;
	}

}
