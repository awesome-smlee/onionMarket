package kr.or.ddit.my.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.vo.UsersVO;

/**
 * Servlet implementation class FindUser2
 */
@WebServlet("/my/findUser2.do")
public class FindUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String str = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IUsersMyService service = UsersMyServiceImpl.getInstance();
		
		//비밀번호 찾을 때 이름, 아이디
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		
		HttpSession idvalue = request.getSession();
		
		UsersVO vo = new UsersVO();
		vo.setUser_nm(userName);
    	vo.setUser_id(userId);
    	List<UsersVO> list = service.getOneUsers(userId);
    	
	    System.out.println(list);
	    System.out.println("doGet아이디 " + userName);
    	System.out.println("이메일~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
    	String userEmail = "";
				
		  //임시비번 담을 곳
//    	String str = "";
    	
		//존재하는 사용자면
		if(list!=null && !list.isEmpty()) {
			 for(UsersVO user: list) { 
					userEmail = user.getEmail();
					  System.out.println(userEmail); 
					  idvalue.setAttribute("id", user);
			
			 }if(vo != null) {
				
				final String userMail = "2017album@naver.com"; // SMTP 인증을 위한 메일 계정
				// 실제 사용중인 계정 비밀번호(발신자용
				final String userPassWord = "test1234"; // SMTP 인증을 위한 비밀번호

				// 수신자용 이메일 계정(회원가입시 입력받은 이메일)
				// DB에 저장되어있는 이메일 받아와서 사용
				final String to = userEmail; // 수신자 이메일 주소 입력
				
				// 회원가입시 이메일과 함께 입력한 사용자 이름 입력 or DB에서 받아와서 입력
				final String fromName = "양파마켓팀"; // 발신자 이름 입력
				
				// 수신받았을때의 이메일 제목
				final String subject = "양파마켓 비밀번호 변경 인증 코드입니다"; // 이메일 제목 입력
				
				// 임시 비밀번호를 발급받기 위한 랜덤번호(0~9,A~Z 까지 추가하고 싶은 문자는 아래의 형식처럼 추가가능)
				char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
						'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
				
				// 임시비빌번호가 저장될 변수
//				String str = "";
				
				// 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
				int idx = 0;
				for (int i = 0; i < 5; i++) {
					idx = (int) (charSet.length * Math.random());
					str += charSet[idx];
				}
				
				// 이메일 발신시 보낼 메세지( str : 임시비밀번호)
				final String body = "양파마켓 인증번호는 [ "+str+" ] 입니다"; // 이메일 내용 입력
				
				
				// 호스트주소 , 포트 번호 는 첨부한 이미지 참고 
				final String host = "smtp.naver.com"; // 이메일 SMTP 호스트 주소
				final int port = 587; // SMTP 포트 번호

				// SMTP 서버 설정을 위해 Properties 객체 생성
				Properties props = new Properties();
				props.put("mail.smtp.port", port); // SMTP 포트 설정
				props.put("mail.smtp.auth", "true"); // SMTP 인증 활성화

				Session session = Session.getDefaultInstance(props); // 시스템 기본 세션을 가져옴
				MimeMessage msg = new MimeMessage(session); // MIME 형식의 이메일 메시지 생성

				Transport transport = null;
				
				try {
					msg.setFrom(new InternetAddress(userMail, fromName)); // 발신자 설정
					msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 수신자 설정
					msg.setSubject(subject); // 이메일 제목 설정
					msg.setText(body); // 이메일 내용 설정
					
					transport = session.getTransport(); // 전송 객체 생성
					System.out.println("전송 중...");
					transport.connect(host, userMail, userPassWord); // 호스트 및 인증 정보로 연결
					transport.sendMessage(msg, msg.getAllRecipients()); // 이메일 전송
					System.out.println("메일 전송 완료 !!"); // 이메일 전송 성공 시 출력
				} catch (Exception ex) {
					ex.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
					System.out.println("메일 전송 실패 . .");
				}
				
				System.out.println(body);
//				request.setAttribute("list", list);
				//변경창 보내는거
				
				
				 
			}
		}else {
			System.out.println("회원정보가 없어요");
		}

//		response.sendRedirect(request.getContextPath()+"/WEB-INF/view/my/findUser.jsp");
		
		request.getRequestDispatcher("/WEB-INF/view/my/findUser.jsp").forward(request, response);
		//response.sendRedirect("/WEB-INF/view/my/findUser.jsp");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인증번호
		String code = request.getParameter("code");
		
		
		if(str.equals(code)) {
			System.out.println("성공");
			request.getRequestDispatcher("/WEB-INF/view/my/changePw.jsp").forward(request, response);
		
		
		}else {
			System.out.println("실패");
			//여기서 아무 페이지로 이동하지않고 alert창띄우게 어캐함?

			request.getRequestDispatcher("/WEB-INF/view/my/findUser.jsp").forward(request, response);
		
		}
		
		
	}
}
