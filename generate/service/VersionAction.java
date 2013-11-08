package service;
import util.RequestObject;
import bean.*;
public final class VersionAction {
		public static interface OnGetCurrentVersionSuccessListener {
			public void onGetCurrentVersionSuccess(AppVersion result);
		}

		public static RequestObject<OnGetCurrentVersionSuccessListener> getCurrentVersion(String os) {
			RequestObject<OnGetCurrentVersionSuccessListener> obj = new RequestObject<OnGetCurrentVersionSuccessListener>();
			obj.setListenerInterfaceClass(OnGetCurrentVersionSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getversion" + ".json");
			obj.addParam("os", os);
			obj.enque();
			return obj;
		}
}
