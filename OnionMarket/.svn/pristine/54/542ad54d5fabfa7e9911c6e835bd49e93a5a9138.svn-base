package kr.or.ddit.util;

import java.text.NumberFormat;
import java.util.Locale;

public class AmountUtil {

	 public static String FormatUtil(long amount) {
	        // Locale을 한국으로 설정하여 원화 형식으로 출력
	        Locale koreaLocale = new Locale("ko", "KR");
	        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(koreaLocale);

	        // 숫자를 통화 형식으로 포맷팅하되, 통화 기호를 제거하여 "10,000원" 형식으로 출력
	        String formattedAmount = currencyFormat.format(amount);

	        // 통화 기호를 제거한 뒤 "원" 글자를 추가
	        formattedAmount = formattedAmount.replace(currencyFormat.getCurrency().getSymbol(), "") + "원";

	        return formattedAmount;
    }
}
