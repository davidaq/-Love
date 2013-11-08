package service;
import util.RequestObject;
import bean.*;
public final class InfAction {
		public static interface OnLoginSuccessListener {
			public void onLoginSuccess(UserPropertyVo result);
		}

		public static RequestObject<OnLoginSuccessListener> login(LoginVo loginVo) {
			RequestObject<OnLoginSuccessListener> obj = new RequestObject<OnLoginSuccessListener>();
			obj.setListenerInterfaceClass(OnLoginSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/login" + ".json");
			obj.setObj(loginVo);
			obj.enque();
			return obj;
		}
		public static interface OnLogoutSuccessListener {
			public void onLogoutSuccess();
		}

		public static RequestObject<OnLogoutSuccessListener> logout() {
			RequestObject<OnLogoutSuccessListener> obj = new RequestObject<OnLogoutSuccessListener>();
			obj.setListenerInterfaceClass(OnLogoutSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/logout" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnModifyPasswordSuccessListener {
			public void onModifyPasswordSuccess();
		}

		public static RequestObject<OnModifyPasswordSuccessListener> modifyPassword(String newPassword) {
			RequestObject<OnModifyPasswordSuccessListener> obj = new RequestObject<OnModifyPasswordSuccessListener>();
			obj.setListenerInterfaceClass(OnModifyPasswordSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/modifypassword" + ".json");
			obj.addParam("newpassword", newPassword);
			obj.enque();
			return obj;
		}
		public static interface OnSendRandomCodeSuccessListener {
			public void onSendRandomCodeSuccess();
		}

		public static RequestObject<OnSendRandomCodeSuccessListener> sendRandomCode(String mobile) {
			RequestObject<OnSendRandomCodeSuccessListener> obj = new RequestObject<OnSendRandomCodeSuccessListener>();
			obj.setListenerInterfaceClass(OnSendRandomCodeSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/randomcode" + ".json");
			obj.addParam("mobile", mobile);
			obj.enque();
			return obj;
		}
		public static interface OnGetUserInfoSuccessListener {
			public void onGetUserInfoSuccess(UserPropertyVo result);
		}

		public static RequestObject<OnGetUserInfoSuccessListener> getUserInfo() {
			RequestObject<OnGetUserInfoSuccessListener> obj = new RequestObject<OnGetUserInfoSuccessListener>();
			obj.setListenerInterfaceClass(OnGetUserInfoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getuserinfo" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnGetOtherUserInfoSuccessListener {
			public void onGetOtherUserInfoSuccess(UserPropertyVo result);
		}

		public static RequestObject<OnGetOtherUserInfoSuccessListener> getOtherUserInfo(String userId) {
			RequestObject<OnGetOtherUserInfoSuccessListener> obj = new RequestObject<OnGetOtherUserInfoSuccessListener>();
			obj.setListenerInterfaceClass(OnGetOtherUserInfoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getotheruserinfo" + ".json");
			obj.addParam("id", userId);
			obj.enque();
			return obj;
		}
		public static interface OnGetUserHeaderPicSuccessListener {
			public void onGetUserHeaderPicSuccess(String result);
		}

		public static RequestObject<OnGetUserHeaderPicSuccessListener> getUserHeaderPic(String userId) {
			RequestObject<OnGetUserHeaderPicSuccessListener> obj = new RequestObject<OnGetUserHeaderPicSuccessListener>();
			obj.setListenerInterfaceClass(OnGetUserHeaderPicSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getuserheader" + ".json");
			obj.addParam("id", userId);
			obj.enque();
			return obj;
		}
		public static interface OnCheckUserIdExistsSuccessListener {
			public void onCheckUserIdExistsSuccess(String result);
		}

		public static RequestObject<OnCheckUserIdExistsSuccessListener> checkUserIdExists(String userId) {
			RequestObject<OnCheckUserIdExistsSuccessListener> obj = new RequestObject<OnCheckUserIdExistsSuccessListener>();
			obj.setListenerInterfaceClass(OnCheckUserIdExistsSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/checkuseridexists" + ".json");
			obj.addParam("mobile", userId);
			obj.enque();
			return obj;
		}
		public static interface OnModifyUserInfoSuccessListener {
			public void onModifyUserInfoSuccess();
		}

		public static RequestObject<OnModifyUserInfoSuccessListener> modifyUserInfo(UserProperty userProperty) {
			RequestObject<OnModifyUserInfoSuccessListener> obj = new RequestObject<OnModifyUserInfoSuccessListener>();
			obj.setListenerInterfaceClass(OnModifyUserInfoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/modifyuserinfo" + ".json");
			obj.setObj(userProperty);
			obj.enque();
			return obj;
		}
		public static interface OnUploadSuccessListener {
			public void onUploadSuccess(String result);
		}

		public static RequestObject<OnUploadSuccessListener> upload(UploadVo uploadVo) {
			RequestObject<OnUploadSuccessListener> obj = new RequestObject<OnUploadSuccessListener>();
			obj.setListenerInterfaceClass(OnUploadSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/upload" + ".json");
			obj.setObj(uploadVo);
			obj.enque();
			return obj;
		}
		public static interface OnSyncConfigInfoSuccessListener {
			public void onSyncConfigInfoSuccess(ConfigVo result);
		}

		public static RequestObject<OnSyncConfigInfoSuccessListener> syncConfigInfo() {
			RequestObject<OnSyncConfigInfoSuccessListener> obj = new RequestObject<OnSyncConfigInfoSuccessListener>();
			obj.setListenerInterfaceClass(OnSyncConfigInfoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/syncconfiginfo" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnCheckDataPrivilegeSuccessListener {
			public void onCheckDataPrivilegeSuccess(boolean result);
		}

		public static RequestObject<OnCheckDataPrivilegeSuccessListener> checkDataPrivilege(String dataId, Integer dataType) {
			RequestObject<OnCheckDataPrivilegeSuccessListener> obj = new RequestObject<OnCheckDataPrivilegeSuccessListener>();
			obj.setListenerInterfaceClass(OnCheckDataPrivilegeSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/checkdataprivilege" + ".json");
			obj.addParam("dataid", dataId);
			obj.addParam("datatype", dataType);
			obj.enque();
			return obj;
		}
}
