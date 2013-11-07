package service;
import util.RequestObject;
import bean.*;
public final class ContactActionInf {
		public static interface OnUploadSuccessListener {
			public void onUploadSuccess();
		}

		public static RequestObject<OnUploadSuccessListener> upload(Contact[] contacts) {
			RequestObject<OnUploadSuccessListener> obj = new RequestObject<OnUploadSuccessListener>();
			obj.setListenerInterfaceClass(OnUploadSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "upload" + ".json");
			obj.addParam("contacts", contacts);
			obj.enque();
			return obj;
		}
		public static interface OnDownloadSuccessListener {
			public void onDownloadSuccess(Contact[] result);
		}

		public static RequestObject<OnDownloadSuccessListener> download() {
			RequestObject<OnDownloadSuccessListener> obj = new RequestObject<OnDownloadSuccessListener>();
			obj.setListenerInterfaceClass(OnDownloadSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "download" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnAddContactSuccessListener {
			public void onAddContactSuccess();
		}

		public static RequestObject<OnAddContactSuccessListener> addContact(Contact contact) {
			RequestObject<OnAddContactSuccessListener> obj = new RequestObject<OnAddContactSuccessListener>();
			obj.setListenerInterfaceClass(OnAddContactSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "add-contact" + ".json");
			obj.setObj(contact);
			obj.enque();
			return obj;
		}
		public static interface OnAddGroupSuccessListener {
			public void onAddGroupSuccess();
		}

		public static RequestObject<OnAddGroupSuccessListener> addGroup(String name) {
			RequestObject<OnAddGroupSuccessListener> obj = new RequestObject<OnAddGroupSuccessListener>();
			obj.setListenerInterfaceClass(OnAddGroupSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "add-group" + ".json");
			obj.addParam("name", name);
			obj.enque();
			return obj;
		}
		public static interface OnRemoveGroupSuccessListener {
			public void onRemoveGroupSuccess();
		}

		public static RequestObject<OnRemoveGroupSuccessListener> removeGroup(String name) {
			RequestObject<OnRemoveGroupSuccessListener> obj = new RequestObject<OnRemoveGroupSuccessListener>();
			obj.setListenerInterfaceClass(OnRemoveGroupSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "remove-group" + ".json");
			obj.addParam("name", name);
			obj.enque();
			return obj;
		}
		public static interface OnAddToGroupSuccessListener {
			public void onAddToGroupSuccess();
		}

		public static RequestObject<OnAddToGroupSuccessListener> addToGroup(String group, String contacts) {
			RequestObject<OnAddToGroupSuccessListener> obj = new RequestObject<OnAddToGroupSuccessListener>();
			obj.setListenerInterfaceClass(OnAddToGroupSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "add-to-group" + ".json");
			obj.addParam("group", group);
			obj.addParam("contacts", contacts);
			obj.enque();
			return obj;
		}
		public static interface OnRenameGroupSuccessListener {
			public void onRenameGroupSuccess();
		}

		public static RequestObject<OnRenameGroupSuccessListener> renameGroup(String oldName, String newName) {
			RequestObject<OnRenameGroupSuccessListener> obj = new RequestObject<OnRenameGroupSuccessListener>();
			obj.setListenerInterfaceClass(OnRenameGroupSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "rename-group" + ".json");
			obj.addParam("old", oldName);
			obj.addParam("new", newName);
			obj.enque();
			return obj;
		}
}
