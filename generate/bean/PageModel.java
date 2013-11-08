package bean;
import java.util.List;
public class PageModel {
	public int count;//记录总数
	public int offset;//第几页
	public int pageSize=10;//每页容量
	public int pageCount;//总页数
	public int pageNo;
	public List<?> data;//数据
	public List<?> getData() {
		return data;
	}
}
