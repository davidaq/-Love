package cc.ccme.love.util;

import java.util.Comparator;

import cc.ccme.love.contact.UserInfo;


public class PinyinComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		 String str1 = PinyinUtils.getPingYin(((UserInfo) o1).getPy());
	     String str2 = PinyinUtils.getPingYin(((UserInfo) o2).getPy());
	     return str1.compareTo(str2);
	}

}
