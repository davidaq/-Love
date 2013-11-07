package service;
import util.RequestObject;
import bean.*;
public final class FansAction {
		public static interface OnAddFansSuccessListener {
			public void onAddFansSuccess();
		}

		public static RequestObject<OnAddFansSuccessListener> addFans(String fansId) {
			RequestObject<OnAddFansSuccessListener> obj = new RequestObject<OnAddFansSuccessListener>();
			obj.setListenerInterfaceClass(OnAddFansSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/addfans" + ".json");
			obj.addParam("fansid", fansId);
			obj.enque();
			return obj;
		}
		public static interface OnSendPrivateMsgSuccessListener {
			public void onSendPrivateMsgSuccess();
		}

		public static RequestObject<OnSendPrivateMsgSuccessListener> sendPrivateMsg(NotifyMsg notifyMsg) {
			RequestObject<OnSendPrivateMsgSuccessListener> obj = new RequestObject<OnSendPrivateMsgSuccessListener>();
			obj.setListenerInterfaceClass(OnSendPrivateMsgSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/sendprivatemsg" + ".json");
			obj.setObj(notifyMsg);
			obj.enque();
			return obj;
		}
		public static interface OnUpdateNickNameSuccessListener {
			public void onUpdateNickNameSuccess();
		}

		public static RequestObject<OnUpdateNickNameSuccessListener> updateNickName(Friend friend) {
			RequestObject<OnUpdateNickNameSuccessListener> obj = new RequestObject<OnUpdateNickNameSuccessListener>();
			obj.setListenerInterfaceClass(OnUpdateNickNameSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/updatenickname" + ".json");
			obj.setObj(friend);
			obj.enque();
			return obj;
		}
		public static interface OnCancelFansSuccessListener {
			public void onCancelFansSuccess();
		}

		public static RequestObject<OnCancelFansSuccessListener> cancelFans(String fansId) {
			RequestObject<OnCancelFansSuccessListener> obj = new RequestObject<OnCancelFansSuccessListener>();
			obj.setListenerInterfaceClass(OnCancelFansSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/cancelfans" + ".json");
			obj.addParam("fansid", fansId);
			obj.enque();
			return obj;
		}
		public static interface OnAdviceFansSuccessListener {
			public void onAdviceFansSuccess(UserPropertyExt[] result);
		}

		public static RequestObject<OnAdviceFansSuccessListener> adviceFans() {
			RequestObject<OnAdviceFansSuccessListener> obj = new RequestObject<OnAdviceFansSuccessListener>();
			obj.setListenerInterfaceClass(OnAdviceFansSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/advicefans" + ".json");
			obj.enque();
			return obj;
		}
}
