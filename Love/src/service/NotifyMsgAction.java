package service;
import util.RequestObject;
import bean.*;
public final class NotifyMsgAction {
		public static interface OnListNotifyMsgSuccessListener {
			public void onListNotifyMsgSuccess(PageModel result);
		}

		public static RequestObject<OnListNotifyMsgSuccessListener> listNotifyMsg(String sendUser, Integer msgCategory, Integer msgType, Integer isRead, Long timeStamp) {
			RequestObject<OnListNotifyMsgSuccessListener> obj = new RequestObject<OnListNotifyMsgSuccessListener>();
			obj.setListenerInterfaceClass(OnListNotifyMsgSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/notifylist" + ".json");
			obj.addParam("senduser", sendUser);
			obj.addParam("msgcategory", msgCategory);
			obj.addParam("msgtype", msgType);
			obj.addParam("isread", isRead);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnListNotifyMsgAscSuccessListener {
			public void onListNotifyMsgAscSuccess(PageModel result);
		}

		public static RequestObject<OnListNotifyMsgAscSuccessListener> listNotifyMsgAsc(String sendUser, Integer msgCategory, Integer msgType, Integer isRead, Long timeStamp) {
			RequestObject<OnListNotifyMsgAscSuccessListener> obj = new RequestObject<OnListNotifyMsgAscSuccessListener>();
			obj.setListenerInterfaceClass(OnListNotifyMsgAscSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/notifylistasc" + ".json");
			obj.addParam("senduser", sendUser);
			obj.addParam("msgcategory", msgCategory);
			obj.addParam("msgtype", msgType);
			obj.addParam("isread", isRead);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnAddNotifyMsgSuccessListener {
			public void onAddNotifyMsgSuccess(NotifyMsg result);
		}

		public static RequestObject<OnAddNotifyMsgSuccessListener> addNotifyMsg(NotifyMsg notifyMsg) {
			RequestObject<OnAddNotifyMsgSuccessListener> obj = new RequestObject<OnAddNotifyMsgSuccessListener>();
			obj.setListenerInterfaceClass(OnAddNotifyMsgSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/addnotifymsg" + ".json");
			obj.setObj(notifyMsg);
			obj.enque();
			return obj;
		}
		public static interface OnGetNotifyMsgSuccessListener {
			public void onGetNotifyMsgSuccess(NotifyMsg result);
		}

		public static RequestObject<OnGetNotifyMsgSuccessListener> getNotifyMsg(String msgId) {
			RequestObject<OnGetNotifyMsgSuccessListener> obj = new RequestObject<OnGetNotifyMsgSuccessListener>();
			obj.setListenerInterfaceClass(OnGetNotifyMsgSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getnotifymsg" + ".json");
			obj.addParam("id", msgId);
			obj.enque();
			return obj;
		}
		public static interface OnModifyNotifyReadStateByIdSuccessListener {
			public void onModifyNotifyReadStateByIdSuccess();
		}

		public static RequestObject<OnModifyNotifyReadStateByIdSuccessListener> modifyNotifyReadStateById(String msgId) {
			RequestObject<OnModifyNotifyReadStateByIdSuccessListener> obj = new RequestObject<OnModifyNotifyReadStateByIdSuccessListener>();
			obj.setListenerInterfaceClass(OnModifyNotifyReadStateByIdSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/modifynotifyreadstatebyid" + ".json");
			obj.addParam("id", msgId);
			obj.enque();
			return obj;
		}
		public static interface OnModifyNotifyReadStateSuccessListener {
			public void onModifyNotifyReadStateSuccess();
		}

		public static RequestObject<OnModifyNotifyReadStateSuccessListener> modifyNotifyReadState(String sendUserId, long timeStamp) {
			RequestObject<OnModifyNotifyReadStateSuccessListener> obj = new RequestObject<OnModifyNotifyReadStateSuccessListener>();
			obj.setListenerInterfaceClass(OnModifyNotifyReadStateSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/modifynotifyreadstate" + ".json");
			obj.addParam("senduser", sendUserId);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
}
