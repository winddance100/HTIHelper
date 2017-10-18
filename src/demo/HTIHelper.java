package demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTIHelper {
	private static final int STATUS_TITLE = 1;
	private static final int STATUS_INFO = 2;
	private static final int STATUS_ANSWER = 3;
	private static List<List<List<Element>>> allEleTitles = new ArrayList();
	private static List<List<List<Element>>> allEleAnswers = new ArrayList();
	private static List<List<String>> allTitles = new ArrayList();
	private static List<List<String>> allAnswers = new ArrayList();
	private static List<String> allHtmlPath = new ArrayList();
	private static List<List<String>> allSQL = new ArrayList();
	//数学
	private static final String SUBJECT_ID_SHUXUE = "15";
	//物理
	private static final String SUBJECT_ID_WULI = "16";
	//化学
	private static final String SUBJECT_ID_HUAXUE = "17";
	//是否调试
	private static final boolean DEBUG = true;
	//学科id
	private static final String SUBJECT_ID = SUBJECT_ID_HUAXUE;
	//目录
	private static final String dirPath = "C:\\Users\\39390\\Desktop\\shuxue\\八年级数学总\\0413121";
	//结果目录
	private static final String resultPath = "C:\\Users\\39390\\Desktop\\hti\\result\\demo";

	//创建目标目录
	public static void one() {
		Path dir = Paths.get(resultPath);
		try {
			Files.createDirectories(dir);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	//获取所有htm路径
	public static void two(String path) {
		File root = new File(path);
		File[] files = root.listFiles();
		for (File file : files) {
			//图片目录
			if (file.getName().contains(".files")) {
				
			}
			//htm
			else if (file.getName().contains(".htm")) {
				allHtmlPath.add(file.getAbsolutePath());
			}
			//子目录
			else if (file.isDirectory()) {
				two(file.getAbsolutePath());
			}
		}
	}

	//获取所有的p标签
	public static void three() {
		for (int i = 0; i < allHtmlPath.size(); i++) {
			String path = allHtmlPath.get(i);
			List<List<Element>> eleTitles = new ArrayList();
			List<List<Element>> eleAnswers = new ArrayList();
			System.out.println("总共" + allHtmlPath.size() + "个文档，当前处理第" + (i+1) + "个文档:" + path + "。。。");
			File file = new File(path);
			Document doc = null;
			try {
				doc = Jsoup.parse(file, "gb2312");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Parse html error! file:" + path);
				e.printStackTrace();
				System.exit(0);
			}
			Element body = doc.body();
			String code = CodeHelper.getCode(path);
			int size1 = body.select(":containsOwn(++++)").size() + 1;
			int size2 = body.select(":containsOwn($$" + code + "$$)").size();
			if (size1 != size2) {
				System.out.println("当前文档:" + path + "的++++和$$" + code + "$$个数不同，exit。。。");
				System.exit(0);
			}
			Elements ps = body.getElementsByTag("p");
			//每一题
			List<Element> title = new ArrayList();
			List<Element> answer = new ArrayList();
			int status = STATUS_TITLE;
			int m = 0;
			for (int j = 0; j < ps.size(); j++) {
				System.out.println("当前处理文档:" + path + "的第" + (m+1) + "题的第" + (j+1) + "个段落。。。");
				Element p = ps.get(j);
				boolean flag = false;
				Document docp = null;
				docp = Jsoup.parseBodyFragment("<p class=MsoNormal style='margin-bottom:0cm;margin-bottom:.0001pt;line-height:normal'>/p>");
				Elements spans = p.getElementsByTag("span");
				for (int k = 0; k < spans.size(); k++) {
				//for (Element span : spans) {
					Element span = spans.get(k);
					String endTag = span.text();
					//title结束
					if (status == STATUS_TITLE) {
						if (endTag.contains("**")) {
							status = STATUS_INFO;
							flag = true;
							break;
						} /*else {
							docp.append(span.outerHtml());
						}*/
					} else if (endTag.contains("**") && status == STATUS_INFO) {
						status = STATUS_ANSWER;
						if (span.getElementsByTag("br").isEmpty()) {
							flag = true;
						} else {
							span.remove();
							flag = false;
						}
						break;
					} else if (status == STATUS_ANSWER) { //answer结束
						if (endTag.equals("++++")) {
							status = STATUS_TITLE;
							m++;
							if (docp != null && !(docp.children().isEmpty())) {
								docp.select(":containsOwn(++++)").remove();
								String phtml = docp.body().html();
								if (phtml == null || phtml.length() < 8) {
									System.out.println("answer p is empty!!!!!!!!!!!!!!!!!!!!!!!!");
									System.exit(0);
								}
								answer.add(docp);
								docp = null;
							}
							eleTitles.add(title);
							eleAnswers.add(answer);
							title = new ArrayList();
							answer = new ArrayList();
							if (span.getElementsByTag("br").isEmpty() && span.parent().getElementsByTag("br").isEmpty()/* && spans.size() == 1*/) {
								flag = true;
							} else {
								span.remove();
								flag = false;
							}
							break;
						} else {
							docp.append(span.outerHtml());
							flag = false;
						}
					}
				}
				if (flag == true) {
					continue;
				}
				//title可能有多个p标签
				if (status == STATUS_TITLE) {
					String phtml = p.outerHtml();
					if (phtml == null || phtml.length() < 8) {
						System.out.println("title p is empty!!!!!!!!!!!!!!!!!!!!!!!!");
						System.exit(0);
					}
					title.add(p);
				} else if (status == STATUS_INFO) {
					
				} else if (status == STATUS_ANSWER) { //answer可能有多个p标签
					String phtml = p.outerHtml();
					if (phtml == null || phtml.length() < 8) {
						System.out.println("answer p is empty!!!!!!!!!!!!!!!!!!!!!!!!");
						System.exit(0);
					}
					answer.add(p);
				} else {
					System.out.println("flag error!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
			//question为空
			if (title == null || title.isEmpty()) {
				System.out.println("ele question is empty!!!!!!!!!!!!!!!!!!!!");
				System.exit(0);
			}
			//reply为空
			if (answer == null || answer.isEmpty()) {
				System.out.println("ele reply is empty!!!!!!!!!!!!!!!!!!!!");
				System.exit(0);
			}
			//最后一题要加上，因为没有++++标志
			eleTitles.add(title);
			eleAnswers.add(answer);
			//每一个文档
			allEleTitles.add(eleTitles);
			allEleAnswers.add(eleAnswers);
		}
	}
	
	//把所有的p标签转化成字符串
	public static void four() {
		if (allEleTitles.size() != allHtmlPath.size() || allEleAnswers.size() != allHtmlPath.size()) {
			System.out.println("allEleTitles allEleAnswers allHtmlPath size is not eqouls!!!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
		for (int i = 0; i < allEleTitles.size(); i++) {
			List<String> strTitles = new ArrayList();
			List<String> strAnswers = new ArrayList();
			System.out.println("总共" + allHtmlPath.size() + "个文档，当前处理第" + (i+1) + "个文档:" + allHtmlPath.get(i) + "。。。");
			List<List<Element>> eleTitles = allEleTitles.get(i);
			List<List<Element>> eleAnswers = allEleAnswers.get(i);
			for (int j = 0; j < eleTitles.size(); j++) {
				System.out.println("当前处理文档:" + allHtmlPath.get(i) + "的第" + (j+1) + "题。。。");
				String question = "";
				for (Element e : eleTitles.get(j)) {
					question += e.outerHtml();
				}
				String reply = "";
				for (Element e : eleAnswers.get(j)) {
					reply += e.outerHtml();
				}
				//question为空
				if (question == null || question.isEmpty()) {
					System.out.println("str question is empty!!!!!!!!!!!!!!!!!!!!");
					System.exit(0);
				}
				//reply为空
				if (reply == null || reply.isEmpty()) {
					System.out.println("str reply is empty!!!!!!!!!!!!!!!!!!!!");
					System.exit(0);
				}
				strTitles.add(question);
				strAnswers.add(reply);
			}
			allTitles.add(strTitles);
			allAnswers.add(strAnswers);
		}
	}
	
	//图片名替换、上传图片
	public static void five() {
		if (allHtmlPath.size() != allTitles.size() || allHtmlPath.size() != allAnswers.size()) {
			System.out.println("allPath allTitles allAnswers size is error!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
		for (int i = 0; i < allTitles.size(); i++) {
			long time = System.currentTimeMillis();
			List<String> strSQLs = new ArrayList();
			List<String> title = allTitles.get(i);
			for (int j = 0; j < title.size(); j++) {
				String question = title.get(j);
				Document docQuestion = Jsoup.parseBodyFragment(question);
				Elements imgQuestion = docQuestion.getElementsByTag("img");
				//title
				for (Element e : imgQuestion) {
					String imgPath = e.attr("src");
					int pos1 = imgPath.lastIndexOf('/');
					int pos2 = imgPath.lastIndexOf('.');
					String imgName = imgPath.substring(pos1 + 1, pos2);
					String prefix = "";
					if (SUBJECT_ID.equals(SUBJECT_ID_SHUXUE)) {
						prefix = "csg2_hti_shu_";
					} else if (SUBJECT_ID.equals(SUBJECT_ID_WULI)) {
						prefix = "csg2_hti_wu_";
					} else if (SUBJECT_ID.equals(SUBJECT_ID_HUAXUE)) {
						prefix = "csg2_hti_hua_";
					}
					String newPicName = prefix + imgName + "_" + time + ".png";
					e.attr("src", newPicName);
					if (DEBUG == false) {
	                	QiniuHelper.upload(new File(allHtmlPath.get(i)).getParent() + File.separator + imgPath, newPicName);
	                }
				}
				title.set(j, docQuestion.body().html().replace("\"", "'"));
			}
			List<String> answer = allAnswers.get(i);
			for (int j = 0; j < answer.size(); j++) {
				String reply = answer.get(j);
				Document docReply = Jsoup.parseBodyFragment(reply);
				Elements imgReply = docReply.getElementsByTag("img");
				//answers
				for (Element e : imgReply) {
					String imgPath = e.attr("src");
					int pos1 = imgPath.lastIndexOf('/');
					int pos2 = imgPath.lastIndexOf('.');
					String imgName = imgPath.substring(pos1 + 1, pos2);
					String prefix = "";
					if (SUBJECT_ID.equals(SUBJECT_ID_SHUXUE)) {
						prefix = "csg2_hti_shu_";
					} else if (SUBJECT_ID.equals(SUBJECT_ID_WULI)) {
						prefix = "csg2_hti_wu_";
					} else if (SUBJECT_ID.equals(SUBJECT_ID_HUAXUE)) {
						prefix = "csg2_hti_hua_";
					}
					String newPicName = prefix + imgName + "_" + time + ".png";
	                e.attr("src", newPicName);
	                if (DEBUG == false) {
	                	QiniuHelper.upload(new File(allHtmlPath.get(i)).getParent() + File.separator + imgPath, newPicName);
	                }
				}
				answer.set(j, docReply.body().html().replace("\"", "'"));
			}			
			
		}
	}
	
	//生成sql
	public static void six() {
		if (allHtmlPath.size() != allTitles.size() || allHtmlPath.size() != allAnswers.size()) {
			System.out.println("allPath allTitles allAnswers size is error!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
		for (int i = 0; i < allTitles.size(); i++) {
			long time = System.currentTimeMillis();
			List<String> strSQL = new ArrayList();
			List<String> title = allTitles.get(i);
			List<String> answer = allAnswers.get(i);
			String path = allHtmlPath.get(i);
			String code = CodeHelper.getCode(path);
			String courseId = CodeHelper.getCourseId(code);
			if (courseId == null || courseId.isEmpty()) {
				System.out.println("code to course error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.exit(0);
			}
			//数学
			for (int j = 0; j < title.size(); j++) {
				String question = title.get(j);
				String reply = answer.get(j);
		        String sql = "insert into hti(code,title,answer,ctime,state,permision_id,subject_id,course_id)values" +
		                "('"+code+"',\"" + question + "\",\"" + reply + "\",'" + time + "','0','3','" + SUBJECT_ID + "','"+courseId+"');\n";
		        strSQL.add(sql);
			};
			allSQL.add(strSQL);
		}
	}
	
	//sql写文件
	public static void seven() {
		if (allHtmlPath.size() != allSQL.size()) {
			System.out.println("allPath allSQL size error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
		for (int i = 0; i < allHtmlPath.size(); i++) {
			String path = allHtmlPath.get(i);
			int pos1 = path.lastIndexOf(File.separator);
			int pos2 = path.lastIndexOf(".");
			String name = path.substring(pos1 + 1, pos2);
			StringBuilder fileSQL = new StringBuilder();
			for(String sql : allSQL.get(i)) {
				fileSQL.append(sql);
			}
			File file = new File(resultPath + File.separator + name + ".sql");
			if (file.exists()) {
	            file.delete();
	        }
	        try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("create sql file error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
				System.exit(0);
			}
	        
	        OutputStream out = null;
	        BufferedWriter bw = null;
	        try {
	            out = new FileOutputStream(file, true);
	            bw = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
	            bw.write(fileSQL.toString());
	        }catch (FileNotFoundException e) {
	            System.out.println("write sql file error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	            e.printStackTrace();
	            System.exit(0);
	        }catch (IOException e) {
	        	System.out.println("write sql file error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	        	e.printStackTrace();
	            System.exit(0);
	        }finally {
	            try {
	                bw.close();
	                out.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		one();
		two(dirPath);
		three();
		four();
		five();
		six();
		seven();
		System.out.println("done!");
	}

}
