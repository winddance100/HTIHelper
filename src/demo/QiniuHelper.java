package demo;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuHelper {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static final String ACCESS_KEY = "oBjU5TuH3png3h-f8iJTM6Evu_gve8kK3Zc0bo-B";
    private static final String SECRET_KEY = "WHlmN3QGRulj6IVfrcrMjQjRfyiFinS4530uCG6D";
    //要上传的空间
    private static final String bucketname = "jian";
	
    //上传文件
    public static void upload(String file, String name) {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //创建上传对象
        UploadManager uploadManager = new UploadManager();
        try {
            //调用put方法上传
            uploadManager.put(file, name, auth.uploadToken(bucketname));
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println("upload file to qiniu wrongly. file:" + name + " error:" + r.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    //删除文件
    public static void delete(String name) {
    	//密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth);
        //要测试的空间和key，并且这个key在你空间中存在
        try {
        	//调用delete方法删除文件
			bucketManager.delete(bucketname, name);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			//捕获异常信息
			Response r = e.response;
			System.out.println("delete file to qiniu wrongly. file:" + name + " error:" + r.toString());
			e.printStackTrace();
			System.exit(0);
		}
    }
    
}
