package service;
import util.RequestObject;
import bean.*;
public final class WishAction {
		public static interface OnAddWishSuccessListener {
			public void onAddWishSuccess();
		}

		public static RequestObject<OnAddWishSuccessListener> addWish(Wish wish) {
			RequestObject<OnAddWishSuccessListener> obj = new RequestObject<OnAddWishSuccessListener>();
			obj.setListenerInterfaceClass(OnAddWishSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/addwish" + ".json");
			obj.setObj(wish);
			obj.enque();
			return obj;
		}
		public static interface OnListWishSuccessListener {
			public void onListWishSuccess(WishVo[] result);
		}

		public static RequestObject<OnListWishSuccessListener> listWish(String eventId, long timeStamp) {
			RequestObject<OnListWishSuccessListener> obj = new RequestObject<OnListWishSuccessListener>();
			obj.setListenerInterfaceClass(OnListWishSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/listwish" + ".json");
			obj.addParam("eventid", eventId);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnDeleteWishSuccessListener {
			public void onDeleteWishSuccess();
		}

		public static RequestObject<OnDeleteWishSuccessListener> deleteWish(String id) {
			RequestObject<OnDeleteWishSuccessListener> obj = new RequestObject<OnDeleteWishSuccessListener>();
			obj.setListenerInterfaceClass(OnDeleteWishSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/deletewish" + ".json");
			obj.addParam("id", id);
			obj.enque();
			return obj;
		}
		public static interface OnPraiseWishSuccessListener {
			public void onPraiseWishSuccess();
		}

		public static RequestObject<OnPraiseWishSuccessListener> praiseWish(String wishId) {
			RequestObject<OnPraiseWishSuccessListener> obj = new RequestObject<OnPraiseWishSuccessListener>();
			obj.setListenerInterfaceClass(OnPraiseWishSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/wishpraise" + ".json");
			obj.addParam("id", wishId);
			obj.enque();
			return obj;
		}
}
