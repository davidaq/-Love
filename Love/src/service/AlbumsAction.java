package service;
import util.RequestObject;
import bean.*;
public final class AlbumsAction {
		public static interface OnCreateAlbumsSuccessListener {
			public void onCreateAlbumsSuccess(String result);
		}

		public static RequestObject<OnCreateAlbumsSuccessListener> createAlbums(Gallery gallery) {
			RequestObject<OnCreateAlbumsSuccessListener> obj = new RequestObject<OnCreateAlbumsSuccessListener>();
			obj.setListenerInterfaceClass(OnCreateAlbumsSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/createalbums" + ".json");
			obj.setObj(gallery);
			obj.enque();
			return obj;
		}
		public static interface OnGetAlbumsListByUidSuccessListener {
			public void onGetAlbumsListByUidSuccess(Gallery[] result);
		}

		public static RequestObject<OnGetAlbumsListByUidSuccessListener> getAlbumsListByUid() {
			RequestObject<OnGetAlbumsListByUidSuccessListener> obj = new RequestObject<OnGetAlbumsListByUidSuccessListener>();
			obj.setListenerInterfaceClass(OnGetAlbumsListByUidSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getalbumslistbyuid" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnGetAlbumsListByEventIdSuccessListener {
			public void onGetAlbumsListByEventIdSuccess(Gallery[] result);
		}

		public static RequestObject<OnGetAlbumsListByEventIdSuccessListener> getAlbumsListByEventId(Gallery gallery) {
			RequestObject<OnGetAlbumsListByEventIdSuccessListener> obj = new RequestObject<OnGetAlbumsListByEventIdSuccessListener>();
			obj.setListenerInterfaceClass(OnGetAlbumsListByEventIdSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getalbumslistbyeventid" + ".json");
			obj.setObj(gallery);
			obj.enque();
			return obj;
		}
		public static interface OnDeleteAlbumsByGalleryIdSuccessListener {
			public void onDeleteAlbumsByGalleryIdSuccess();
		}

		public static RequestObject<OnDeleteAlbumsByGalleryIdSuccessListener> deleteAlbumsByGalleryId(Gallery gallery) {
			RequestObject<OnDeleteAlbumsByGalleryIdSuccessListener> obj = new RequestObject<OnDeleteAlbumsByGalleryIdSuccessListener>();
			obj.setListenerInterfaceClass(OnDeleteAlbumsByGalleryIdSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/deletealbumsbygalleryid" + ".json");
			obj.setObj(gallery);
			obj.enque();
			return obj;
		}
		public static interface OnUpdateGallerySuccessListener {
			public void onUpdateGallerySuccess();
		}

		public static RequestObject<OnUpdateGallerySuccessListener> updateGallery(Gallery gallery) {
			RequestObject<OnUpdateGallerySuccessListener> obj = new RequestObject<OnUpdateGallerySuccessListener>();
			obj.setListenerInterfaceClass(OnUpdateGallerySuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/updategallery" + ".json");
			obj.setObj(gallery);
			obj.enque();
			return obj;
		}
		public static interface OnGetGalleryGroupListSuccessListener {
			public void onGetGalleryGroupListSuccess(GalleryGroup[] result);
		}

		public static RequestObject<OnGetGalleryGroupListSuccessListener> getGalleryGroupList() {
			RequestObject<OnGetGalleryGroupListSuccessListener> obj = new RequestObject<OnGetGalleryGroupListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetGalleryGroupListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getgallerygroup" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnGetOthersGallerySuccessListener {
			public void onGetOthersGallerySuccess(GalleryGroup[] result);
		}

		public static RequestObject<OnGetOthersGallerySuccessListener> getOthersGallery(String friendId) {
			RequestObject<OnGetOthersGallerySuccessListener> obj = new RequestObject<OnGetOthersGallerySuccessListener>();
			obj.setListenerInterfaceClass(OnGetOthersGallerySuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getothersgallery" + ".json");
			obj.addParam("friendid", friendId);
			obj.enque();
			return obj;
		}
}
