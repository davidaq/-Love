package service;
import util.RequestObject;
import bean.*;
public final class BlackListAction {
		public static interface OnAddBlackListSuccessListener {
			public void onAddBlackListSuccess();
		}

		public static RequestObject<OnAddBlackListSuccessListener> addBlackList(String blackUser) {
			RequestObject<OnAddBlackListSuccessListener> obj = new RequestObject<OnAddBlackListSuccessListener>();
			obj.setListenerInterfaceClass(OnAddBlackListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/addblacklist" + ".json");
			obj.addParam("blackuser", blackUser);
			obj.enque();
			return obj;
		}
		public static interface OnListBlackListSuccessListener {
			public void onListBlackListSuccess(BlackListExt[] result);
		}

		public static RequestObject<OnListBlackListSuccessListener> listBlackList() {
			RequestObject<OnListBlackListSuccessListener> obj = new RequestObject<OnListBlackListSuccessListener>();
			obj.setListenerInterfaceClass(OnListBlackListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/listblacklist" + ".json");
			obj.enque();
			return obj;
		}
}
