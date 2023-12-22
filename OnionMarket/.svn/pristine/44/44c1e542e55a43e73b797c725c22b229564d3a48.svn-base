package kr.or.ddit.pro.service;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import kr.or.ddit.pro.dao.IProDao;
import kr.or.ddit.pro.dao.ProDaoImpl;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.LocVO;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.ProCateVO;
import kr.or.ddit.vo.WishVO;

public class ProServiceImpl implements IProService {

	private IProDao dao;
	private static ProServiceImpl service;
	private ProServiceImpl() {
		dao = ProDaoImpl.getInstance();
	}
	public static ProServiceImpl getInstance() {
		if (service == null) service = new ProServiceImpl();
		return service;
	}

	@Override
	public Map getProPage(Map param) {
		// 물품 목록 조회
		List<ProAndCateVO> list = dao.getProList(param);
		
		// 물품 첨부파일 조회 및 추가
		for(ProAndCateVO proVo : list) {
			
			FileInfoVO fileVo = new FileInfoVO();
			fileVo.setProd_id(proVo.getProd_id());
			
			// 해당 물품 게시글에 첨부 파일 조회 
			List<FileInfoVO> fileList = dao.getProFileList(fileVo);
			proVo.setFile_list(fileList);
		}
		
		// 물품 총 갯수 조회
		int cnt = dao.getProCnt(param);
		
		// 페이지네이션 맵 초기화
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", param.get("page"));
		map.put("rowsize", param.get("rowsize"));
		map.put("rowcnt", cnt);
		map.put("list", list);
		
		return map;
	}

	@Override
	public List<ProCateVO> getProCateList() {
		return dao.getProCateList();
	}
	
	@Override
	public ProAndCateVO getProDetail(ProAndCateVO proVo) {
		ProAndCateVO result = dao.getProDetail(proVo);
		
		// 첨부파일 조회
		FileInfoVO fileVo = new FileInfoVO();
		fileVo.setProd_id(proVo.getProd_id());
		List<FileInfoVO> fileList = dao.getProFileList(fileVo);
		
		// 첨부파일 담기
		result.setFile_list(fileList);
		
		return result;
	}
	
	@Override
	public int insertPro(ProAndCateVO proVo, HttpServletRequest req) throws IOException, ServletException {
		
		// 위치정보 조회
		LocVO locVo = dao.getLocation(proVo);
		int cnt = 0;
		
		// 등록된 위치 정보 아 닐 경우
		if(locVo == null) {
			// 위치 정보 데이터 추가 
			dao.insertLocation(proVo);
		} 
		else {
			// 판매글 위치정보 id 추가
			proVo.setPro_loc_id(locVo.getLoc_id());
		}
		// 판매글 추가 
		cnt = dao.insertPro(proVo);
		
		// 첨부파일 저장
		if(cnt > 0) {
			// 업로드 디렉토리 경로
			String uploadPath = FileUtil.getFileDirRootPath(req.getServletContext());
			
			Collection<Part> files = req.getParts();
			for(Part file : files) {
				if(file.getSubmittedFileName() != null) {
					// 파일 정보 추출 
					FileInfoVO fileVo = FileUtil.getFileInfo(file);
					// 파일 데이터 추가
					int fileCnt = dao.insertFile(fileVo);
					
					if(fileCnt > 0) {
						// 파일 vo 물품 id 추가
						fileVo.setProd_id(proVo.getProd_id());
						// 물품 파일 데이터 추가
						int fileProCnt = dao.insertProFile(fileVo);
						
						if(fileProCnt > 0) {
							// 파일 업로드
							FileUtil.uploadFile(file, uploadPath, fileVo.getStored_nm());
						}
					}
				}
			}
		}
		
		return cnt;
	}
	
	
	
	@Override
	public int updatePro(ProAndCateVO proVo, HttpServletRequest req) throws IOException, ServletException {
		
		// 기존 첨부파일 조회
		FileInfoVO prefileVo = new FileInfoVO();
		prefileVo.setProd_id(proVo.getProd_id());
		List<FileInfoVO> fileList = dao.getProFileList(prefileVo);
		
		String path = FileUtil.getFileDirRootPath(req.getServletContext());
		
		// 기존 첨부파일 처리 
		for(FileInfoVO file : fileList) {
			// 기존 첨부파일 데이터 삭제 
			int fileCnt = dao.deleteFile(file);
			if(fileCnt > 0) {
				// 기존 첨부파일 삭제
				boolean isDelete = FileUtil.deleteFile(path, file.getStored_nm());
			}
		}
		
		
		// 위치정보 조회
		LocVO locVo = dao.getLocation(proVo);
		int cnt = 0;
		
		// 등록된 위치 정보 아 닐 경우
		if(locVo == null) {
			// 위치 정보 데이터 추가 
			dao.insertLocation(proVo);
		} 
		else {
			// 판매글 위치정보 id 추가
			proVo.setPro_loc_id(locVo.getLoc_id());
		}
		
		// 판매글 추가 
		cnt = dao.updatePro(proVo);
		
		// 첨부파일 저장
		if(cnt > 0) {
			// 업로드 디렉토리 경로
			String uploadPath = FileUtil.getFileDirRootPath(req.getServletContext());
			
			Collection<Part> files = req.getParts();
			for(Part file : files) {
				if(file.getSubmittedFileName() != null) {
					// 파일 정보 추출 
					FileInfoVO fileVo = FileUtil.getFileInfo(file);
					// 파일 데이터 추가
					int fileCnt = dao.insertFile(fileVo);
					
					if(fileCnt > 0) {
						// 파일 vo 물품 id 추가
						fileVo.setProd_id(proVo.getProd_id());
						// 물품 파일 데이터 추가
						int fileProCnt = dao.insertProFile(fileVo);
						
						if(fileProCnt > 0) {
							// 파일 업로드
							FileUtil.uploadFile(file, uploadPath, fileVo.getStored_nm());
						}
					}
				}
			}
		}
		
		return cnt;
	}
	
	@Override
	public int updateProStatus(ProAndCateVO proVo) {
		return dao.updateProStatus(proVo);
	}
	
	@Override
	public int insertLike(WishVO wsVo) {
		return dao.insertLike(wsVo);
	}
	
	@Override
	public int deleteLike(WishVO wsVo) {
		return dao.deleteLike(wsVo);
	}
	
	@Override
	public List<FileInfoVO> getProFileList(FileInfoVO fileVo) {
		return dao.getProFileList(fileVo);
	}
	
	@Override
	public int deletePro(ProAndCateVO proVo, HttpServletRequest req) {
		
		// 첨부파일 조회
		FileInfoVO fileVo = new FileInfoVO();
		fileVo.setProd_id(proVo.getProd_id());
		List<FileInfoVO> fileList = dao.getProFileList(fileVo);
		
		
		// 물품 삭제 
		int cnt = dao.deletePro(proVo);
		if(cnt > 0) {
			
			String path = FileUtil.getFileDirRootPath(req.getServletContext());
			
			// 첨부파일
			for(FileInfoVO file : fileList) {
				// 첨부파일 데이터 삭제 
				int fileCnt = dao.deleteFile(file);
				if(fileCnt > 0) {
					// 첨부파일 삭제
					boolean isDelete = FileUtil.deleteFile(path, file.getStored_nm());
				}
			}
		}
		return cnt;
	}
	
	@Override
	public int updateViewCnt(ProAndCateVO proVo) {
		return dao.updateViewCnt(proVo);
	}
	
}
