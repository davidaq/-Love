package service;
import util.RequestObject;
import bean.*;
public final class ContactNewAction {
		public static interface OnCheckMobileIsUserSuccessListener {
			public void onCheckMobileIsUserSuccess(UserProperty[] result);
		}

		public static RequestObject<OnCheckMobileIsUserSuccessListener> checkMobileIsUser(String[] mobiles) {
			RequestObject<OnCheckMobileIsUserSuccessListener> obj = new RequestObject<OnCheckMobileIsUserSuccessListener>();
			obj.setListenerInterfaceClass(OnCheckMobileIsUserSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/checkmobileisuser" + ".json");
			obj.addParam("mobiles", mobiles);
			obj.enque();
			return obj;
		}
}
