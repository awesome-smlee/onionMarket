package kr.or.ddit.comnews.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import kr.or.ddit.comnews.service.ComNewsServiceImpl;
import kr.or.ddit.comnews.service.IComNewsService;
import kr.or.ddit.vo.ComNewsVO;

@WebServlet("/comnews/comNewsList.do")
public class ComNewsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final static String BASE_URL = "https://www.daejeon.go.kr/drh/MediaList.do";
    final static int TOTAL_PAGES = 5; // 최대 페이지 수

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IComNewsService service = ComNewsServiceImpl.getInstance();
        service.reset();
        for (int pageIndex = 1; pageIndex <= TOTAL_PAGES; pageIndex++) {
            String url = BASE_URL + "?pageIndex=" + pageIndex
                    + "&searchCondition=&searchCondition2=&searchCondition3=&searchCondition4=&searchCondition5=&notiType=NOTI_06&searchKeyword=&menuSeq=2564";
            crawlAndInsert(url, service);
        }

        List<ComNewsVO> newsList = service.getNewsList();
        request.setAttribute("newsList", newsList);
        request.getRequestDispatcher("/WEB-INF/view/comnews/comNewsList.jsp").forward(request, response);
    }

    private void crawlAndInsert(String url, IComNewsService service) throws IOException {
        Document doc = Jsoup.connect(url).get();
        org.jsoup.select.Elements rows = doc.select("tr");
        
        for (Element row : rows) {
            String news_id = row.select("td.num2.t_end").text();
            String gu = row.select("td.org").text();
            String division = row.select("td.division3").text();
            String tit = row.select("td.al_left.subject a").text();
            String ins_dt = row.select("td.date").text();
            String fn = row.select("td.al_left.subject a").attr("onclick");

            if (!news_id.isEmpty()) {
                ComNewsVO newsVo = new ComNewsVO();
                newsVo.setNews_id(Integer.parseInt(news_id));
                newsVo.setGu(gu);
                newsVo.setDivision(division);
                newsVo.setTit(tit);
                newsVo.setIns_dt(ins_dt);
                newsVo.setFn(fn);
                service.comNewsInsert(newsVo);
            }
        }
    }
}
