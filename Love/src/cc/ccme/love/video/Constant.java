package cc.ccme.love.video;

import java.util.ArrayList;
import java.util.LinkedList;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Constant {
	
	private static LinkedList<String> extens=null;
	
	public static class ImageFolderInfo{
		public String path;
		public int pisNum = 0;
		public ArrayList<String> filePathes = new ArrayList<String>();
		public Drawable image;
	}
	
	public static LinkedList<String> getExtens(){
		if(extens == null){
			extens = new LinkedList<String>();
			extens.add("JPEG");
			extens.add("JPG");
			extens.add("PNG");
			extens.add("GIF");
			extens.add("BMP");
		}
		return extens;
	}
	
	public static class gridItemEntity{
		public Drawable image;
		public String path;
		public int index;
		public ImageView imageView;
	}
}
