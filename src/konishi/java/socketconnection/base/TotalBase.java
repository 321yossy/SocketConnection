package konishi.java.socketconnection.base;

import java.util.StringTokenizer;


public class TotalBase {
	
	/**
	 * :文字で区切られた文字を分割する
	 * @param str
	 * @return
	 */
	public String[] stringSeparator(String str, int num, String key) {
		
		String[] data = new String[num];

        StringTokenizer st = new StringTokenizer(str , key);

        while (st.hasMoreTokens()) {
            data[data.length - st.countTokens()] = st.nextToken();
        }
        
        return data;
	}
	
	public int[] parseIntArray(String[] str) {
		int[] data = new int[str.length];
		
		for (int i = 0; i < str.length; i++) {
			data[i] = Integer.parseInt(str[i]);
		}
		return data;
	}
	
	
	/**
	 * 呼び出し元スレッドの表示
	 */
	public void stackTrace() {
		try {
			System.out.println("Pass: " + Thread.currentThread().getStackTrace()[2]);
		}catch(Exception e) {
			System.out.println("Please give me acception for \"System.out.println()\". ");
		}
	}
	
	/**
	 * stackTraceのオーバーロード
	 * メッセージを記述できる
	 * @param msg 表示メッセージ
	 */
	public <T> void stackTrace(T msg) {
		try {
			System.out.println("Pass: " + Thread.currentThread().getStackTrace()[2]);
			System.out.println("Message: " + msg);
		}catch(Exception e) {
			System.out.println("Please give me acception for \"System.out.println()\". ");
		}
	}
	
	/**
	 * エラー発生場所の表示とStackTraceをおこないます。
	 * @param e 例外インスタンス
	 */
	public void errorStackTrace(Exception e) {
		try {
			System.out.println("Error: " + Thread.currentThread().getStackTrace()[2]);
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println("Please give me acception for \"System.out.println()\". ");
		}
	}
	
	/**
	 * errorStackTraceのオーバーロード
	 * メッセージを記述できる
	 * @param e 例外インスタンス
	 * @param msg 表示メッセージ
	 */
	public <T> void errorStackTrace(Exception e, T msg) {
		try {
			System.out.println("Error: " + Thread.currentThread().getStackTrace()[2]);
			System.out.println("ErrorMessage: " + msg);
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println("Please give me acception for \"System.out.println()\". ");
		}
	}
}
