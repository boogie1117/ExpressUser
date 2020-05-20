package verify;

import java.util.HashMap;
import java.util.Random;

import com.zhenzi.sms.ZhenziSmsClient;

public class SendVarifyCode {

//	@Test
//	public void a() {
//		SendVarifyCode sendVarifyCode = new SendVarifyCode();
//		sendVarifyCode.send();
//	}

	public String send(String telCode) {
		String apiUrl = "https://sms_developer.zhenzikj.com";
		String appId = "104997";
		String appSecret = "OGQ0OWZlYzEtZjMzNS00MmY4LTk5ZmItNzM0NTE1NTJmYzJi";
		ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
		HashMap<String, String> params = new HashMap<>();
		String code = getVerifyCode();
		System.out.println(code);
		params.put("message", "卓越快递，最好的快递软件,您的验证码为: " + code);
		params.put("number", telCode);
		System.out.println(telCode);
		try {
			String result = client.send(params);
			System.out.println(result);
			return code;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("还是失败了");
			return "失败啦";
		}

	}

	private static String getVerifyCode() {
		String ch = "1234567890";
		String result = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(ch.length());
			char c = ch.charAt(index);
			result += c;
		}
		return result;

	}

}
