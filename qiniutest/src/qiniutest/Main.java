package qiniutest;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class Main {
	public static void main(String[] args) {
		UploadManager uploadManager = new UploadManager();
		Auth auth = Auth.create("0TR-SRUN6p2IQAg6L0EkyjyW-66m0Kc6wVNgJksq", "IN3e7y5ZyVNWq1resVwvbD90-fyCSq9WbFdhiX79");
		String token = auth.uploadToken("zhangshangzu");
		try {
			Response r = uploadManager.put("hello world".getBytes(), "hello.txt", token);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
