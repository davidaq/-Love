package cc.ccme.love.video;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class CommonFile implements Serializable,Parcelable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private String name;
	private long date;
	private long size;
	
	public CommonFile()
	{}
	
	private CommonFile(Parcel parcel)
	{
		url = parcel.readString();
		name = parcel.readString();
		date = parcel.readLong();
		size = parcel.readLong();
	}
	
	public static final Parcelable.Creator<CommonFile> CREATOR = new Parcelable.Creator<CommonFile>() {  
		  
        @Override  
        public CommonFile createFromParcel(Parcel source) {  
            return new CommonFile(source);  
        }  
  
        @Override  
        public CommonFile[] newArray(int size) {  
            return new CommonFile[size];  
        }  
    };  

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	@Override
	public int describeContents() {

		return 0;
	}
	@Override  
    public void writeToParcel(Parcel parcel, int flag) {  
        parcel.writeString(name);  
        parcel.writeLong(date);  
        parcel.writeLong(size); 
        parcel.writeString(url);  
    }

}
