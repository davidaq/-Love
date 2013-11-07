package cc.ccme.love.util;

public class ParseUtil {

	public static String parseImageFit(String url)
	{
		System.out.println(url);
		String[] imgArr = url.split("\\.");
		return "http://oss.ccme.cc/" + imgArr[0] +"_fit." + imgArr[1];
	}
	
	public static String parseVideoFit(String url)
	{
		return "http://oss.ccme.cc/"+ url +"_fit.mp4";
	}
}
