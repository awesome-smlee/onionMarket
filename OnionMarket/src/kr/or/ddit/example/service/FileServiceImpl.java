package kr.or.ddit.example.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import kr.or.ddit.example.dao.FileDaoImpl;
import kr.or.ddit.example.dao.IFileDao;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.vo.FileInfoVO;

public class FileServiceImpl implements IFileService {

	private IFileDao dao;
	private static FileServiceImpl service;
	private FileServiceImpl() {
		dao = FileDaoImpl.getInstance();
	}
	public static FileServiceImpl getInstance() {
		if (service == null) service = new FileServiceImpl();
		return service;
	}
	@Override
	public List<FileInfoVO> getFileList(Map param) {
		return dao.getFileList(param);
	}
	@Override
	public int insertFile(HttpServletRequest req) throws IOException, ServletException {
		// 업로드 디렉토리 경로
		String uploadPath = FileUtil.getFileDirRootPath(req.getServletContext());
		
		// 요청에서 파일 가져오기
		Collection<Part> files = req.getParts();
		
		int cnt = 0;
		for(Part file : files) {
			// 파일 정보 추출 
			FileInfoVO vo = FileUtil.getFileInfo(file);
			// 파일 업로드
			FileUtil.uploadFile(file, uploadPath, vo.getStored_nm());
			// 파일 데이터 추가
			cnt += dao.insertFile(vo);
		}
		
		return cnt;
	}
	
	

//	@Override
//	public Map getProPage(Map param) {
//		List<ProAndCateVO> list = dao.getProList(param);
//		int cnt = dao.getProCnt(param);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("page", param.get("page"));
//		map.put("rowsize", param.get("rowsize"));
//		map.put("rowcnt", cnt);
//		map.put("list", list);
//		
//		return map;
//	}
//
//	@Override
//	public List<ProCateVO> getProCateList() {
//		return dao.getProCateList();
//	}
//	
//	@Override
//	public ProAndCateVO getProDetail(String prodId) {
//		return dao.getProDetail(prodId);
//	}
//	
//	@Override
//	public int insertPro(ProAndCateVO proVo) {
//		
//		LocationVO vo = dao.getLocation(proVo);
//		int cnt = 0;
//		
//		if(vo == null) {
//			dao.insertLocation(proVo);
//		} else {
//			proVo.setPro_loc_id(vo.getLoc_id());
//		}
//		
//		cnt = dao.insertPro(proVo);
//		
//		return cnt;
//	}
//	
//	@Override
//	public int updateProStatus(ProAndCateVO proVo) {
//		return dao.updateProStatus(proVo);
//	}
	
}
