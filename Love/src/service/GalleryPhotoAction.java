package service;
import util.RequestObject;
import bean.*;
public final class GalleryPhotoAction {
		public static interface OnGetPhotoByGalleryIdSuccessListener {
			public void onGetPhotoByGalleryIdSuccess(GalleryPhoto[] result);
		}

		public static RequestObject<OnGetPhotoByGalleryIdSuccessListener> getPhotoByGalleryId(GalleryPhoto galpho) {
			RequestObject<OnGetPhotoByGalleryIdSuccessListener> obj = new RequestObject<OnGetPhotoByGalleryIdSuccessListener>();
			obj.setListenerInterfaceClass(OnGetPhotoByGalleryIdSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getphotobygalleryid" + ".json");
			obj.setObj(galpho);
			obj.enque();
			return obj;
		}
		public static interface OnUploadGalleryPhotoSuccessListener {
			public void onUploadGalleryPhotoSuccess();
		}

		public static RequestObject<OnUploadGalleryPhotoSuccessListener> uploadGalleryPhoto(String galleryId, String fileNames, String photoName) {
			RequestObject<OnUploadGalleryPhotoSuccessListener> obj = new RequestObject<OnUploadGalleryPhotoSuccessListener>();
			obj.setListenerInterfaceClass(OnUploadGalleryPhotoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/uploadgalleryphoto" + ".json");
			obj.addParam("gid", galleryId);
			obj.addParam("filenames", fileNames);
			obj.addParam("photoname", photoName);
			obj.enque();
			return obj;
		}
		public static interface OnDeleteMultiPhotoSuccessListener {
			public void onDeleteMultiPhotoSuccess();
		}

		public static RequestObject<OnDeleteMultiPhotoSuccessListener> deleteMultiPhoto(String galleryId, String fileIds) {
			RequestObject<OnDeleteMultiPhotoSuccessListener> obj = new RequestObject<OnDeleteMultiPhotoSuccessListener>();
			obj.setListenerInterfaceClass(OnDeleteMultiPhotoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/deletemultiphoto" + ".json");
			obj.addParam("galleryId", galleryId);
			obj.addParam("fileIds", fileIds);
			obj.enque();
			return obj;
		}
		public static interface OnMultiPhotoMigrateSuccessListener {
			public void onMultiPhotoMigrateSuccess();
		}

		public static RequestObject<OnMultiPhotoMigrateSuccessListener> multiPhotoMigrate(String fromGalleryId, String fileIds, String toGallery) {
			RequestObject<OnMultiPhotoMigrateSuccessListener> obj = new RequestObject<OnMultiPhotoMigrateSuccessListener>();
			obj.setListenerInterfaceClass(OnMultiPhotoMigrateSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/multiphotomigrate" + ".json");
			obj.addParam("fromGalleryId", fromGalleryId);
			obj.addParam("fileIds", fileIds);
			obj.addParam("toGallery", toGallery);
			obj.enque();
			return obj;
		}
		public static interface OnGetSingleGalleryPhotoSuccessListener {
			public void onGetSingleGalleryPhotoSuccess(GalleryPhotoUserInfo result);
		}

		public static RequestObject<OnGetSingleGalleryPhotoSuccessListener> getSingleGalleryPhoto(String galleryId, String fileId) {
			RequestObject<OnGetSingleGalleryPhotoSuccessListener> obj = new RequestObject<OnGetSingleGalleryPhotoSuccessListener>();
			obj.setListenerInterfaceClass(OnGetSingleGalleryPhotoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getsinglegalleryphoto" + ".json");
			obj.addParam("galleryId", galleryId);
			obj.addParam("fileId", fileId);
			obj.enque();
			return obj;
		}
		public static interface OnGetPhotoListByGalleryIdSuccessListener {
			public void onGetPhotoListByGalleryIdSuccess(GalleryPhoto[] result);
		}

		public static RequestObject<OnGetPhotoListByGalleryIdSuccessListener> getPhotoListByGalleryId(String galleryId, Integer fileType, long timeStamp) {
			RequestObject<OnGetPhotoListByGalleryIdSuccessListener> obj = new RequestObject<OnGetPhotoListByGalleryIdSuccessListener>();
			obj.setListenerInterfaceClass(OnGetPhotoListByGalleryIdSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getgalleryphotolist" + ".json");
			obj.addParam("gid", galleryId);
			obj.addParam("filetype", fileType);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnGetPhotoInfoSuccessListener {
			public void onGetPhotoInfoSuccess(GalleryPhotoUserInfo result);
		}

		public static RequestObject<OnGetPhotoInfoSuccessListener> getPhotoInfo(String galleryId, String fileId) {
			RequestObject<OnGetPhotoInfoSuccessListener> obj = new RequestObject<OnGetPhotoInfoSuccessListener>();
			obj.setListenerInterfaceClass(OnGetPhotoInfoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getfileinfo" + ".json");
			obj.addParam("gid", galleryId);
			obj.addParam("fid", fileId);
			obj.enque();
			return obj;
		}
		public static interface OnDeleteVideoSuccessListener {
			public void onDeleteVideoSuccess();
		}

		public static RequestObject<OnDeleteVideoSuccessListener> deleteVideo(String fileId) {
			RequestObject<OnDeleteVideoSuccessListener> obj = new RequestObject<OnDeleteVideoSuccessListener>();
			obj.setListenerInterfaceClass(OnDeleteVideoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/deletevideo" + ".json");
			obj.addParam("fileid", fileId);
			obj.enque();
			return obj;
		}
}
