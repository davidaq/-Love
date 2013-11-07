package service;
import util.RequestObject;
import bean.*;
public final class ReviewAction {
		public static interface OnAddReviewSuccessListener {
			public void onAddReviewSuccess();
		}

		public static RequestObject<OnAddReviewSuccessListener> addReview(ReviewVo reviewVo, int reviewType) {
			RequestObject<OnAddReviewSuccessListener> obj = new RequestObject<OnAddReviewSuccessListener>();
			obj.setListenerInterfaceClass(OnAddReviewSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/addreview" + ".json");
			obj.setObj(reviewVo);
			obj.addParam("reviewtype", reviewType);
			obj.enque();
			return obj;
		}
		public static interface OnDeleteReviewSuccessListener {
			public void onDeleteReviewSuccess();
		}

		public static RequestObject<OnDeleteReviewSuccessListener> deleteReview(String reviewId) {
			RequestObject<OnDeleteReviewSuccessListener> obj = new RequestObject<OnDeleteReviewSuccessListener>();
			obj.setListenerInterfaceClass(OnDeleteReviewSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/deletereview" + ".json");
			obj.addParam("id", reviewId);
			obj.enque();
			return obj;
		}
		public static interface OnListReviewSuccessListener {
			public void onListReviewSuccess(ReviewExt[] result);
		}

		public static RequestObject<OnListReviewSuccessListener> listReview(String dataId, Integer dataType, long timeStamp) {
			RequestObject<OnListReviewSuccessListener> obj = new RequestObject<OnListReviewSuccessListener>();
			obj.setListenerInterfaceClass(OnListReviewSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/listreview" + ".json");
			obj.addParam("dataid", dataId);
			obj.addParam("datatype", dataType);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnPraiseSuccessListener {
			public void onPraiseSuccess();
		}

		public static RequestObject<OnPraiseSuccessListener> praise(String superDataId, String dataId) {
			RequestObject<OnPraiseSuccessListener> obj = new RequestObject<OnPraiseSuccessListener>();
			obj.setListenerInterfaceClass(OnPraiseSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/praise" + ".json");
			obj.addParam("superdataid", superDataId);
			obj.addParam("dataid", dataId);
			obj.enque();
			return obj;
		}
		public static interface OnGetPraisePersonsSuccessListener {
			public void onGetPraisePersonsSuccess(UserProperty[] result);
		}

		public static RequestObject<OnGetPraisePersonsSuccessListener> getPraisePersons(String fileId) {
			RequestObject<OnGetPraisePersonsSuccessListener> obj = new RequestObject<OnGetPraisePersonsSuccessListener>();
			obj.setListenerInterfaceClass(OnGetPraisePersonsSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getpraisepersons" + ".json");
			obj.addParam("fileId", fileId);
			obj.enque();
			return obj;
		}
}
