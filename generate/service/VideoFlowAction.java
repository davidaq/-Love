package service;
import util.RequestObject;
import bean.*;
public final class VideoFlowAction {
		public static interface OnGetVideoListForNoLoginSuccessListener {
			public void onGetVideoListForNoLoginSuccess(VideoFlowExt[] result);
		}

		public static RequestObject<OnGetVideoListForNoLoginSuccessListener> getVideoListForNoLogin(long timeStamp) {
			RequestObject<OnGetVideoListForNoLoginSuccessListener> obj = new RequestObject<OnGetVideoListForNoLoginSuccessListener>();
			obj.setListenerInterfaceClass(OnGetVideoListForNoLoginSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getvideolistfornologin" + ".json");
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnGetVideoFlowSuccessListener {
			public void onGetVideoFlowSuccess(VideoFlowExt[] result);
		}

		public static RequestObject<OnGetVideoFlowSuccessListener> getVideoFlow(Integer type, long timeStamp) {
			RequestObject<OnGetVideoFlowSuccessListener> obj = new RequestObject<OnGetVideoFlowSuccessListener>();
			obj.setListenerInterfaceClass(OnGetVideoFlowSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getvideoflow" + ".json");
			obj.addParam("type", type);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
		public static interface OnGetVideoFlowReviewSuccessListener {
			public void onGetVideoFlowReviewSuccess(ReviewExt[] result);
		}

		public static RequestObject<OnGetVideoFlowReviewSuccessListener> getVideoFlowReview(String videoFlowId) {
			RequestObject<OnGetVideoFlowReviewSuccessListener> obj = new RequestObject<OnGetVideoFlowReviewSuccessListener>();
			obj.setListenerInterfaceClass(OnGetVideoFlowReviewSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getvideoflowreview" + ".json");
			obj.addParam("videoFlowId", videoFlowId);
			obj.enque();
			return obj;
		}
		public static interface OnVideoFlowPraiseSuccessListener {
			public void onVideoFlowPraiseSuccess();
		}

		public static RequestObject<OnVideoFlowPraiseSuccessListener> videoFlowPraise(String videoFlowId) {
			RequestObject<OnVideoFlowPraiseSuccessListener> obj = new RequestObject<OnVideoFlowPraiseSuccessListener>();
			obj.setListenerInterfaceClass(OnVideoFlowPraiseSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/videoflowpraise" + ".json");
			obj.addParam("videoFlowId", videoFlowId);
			obj.enque();
			return obj;
		}
		public static interface OnDeleteVFReviewSuccessListener {
			public void onDeleteVFReviewSuccess();
		}

		public static RequestObject<OnDeleteVFReviewSuccessListener> deleteVFReview(String reviewId) {
			RequestObject<OnDeleteVFReviewSuccessListener> obj = new RequestObject<OnDeleteVFReviewSuccessListener>();
			obj.setListenerInterfaceClass(OnDeleteVFReviewSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/deletevfreview" + ".json");
			obj.addParam("reviewId", reviewId);
			obj.enque();
			return obj;
		}
		public static interface OnGetMusicListSuccessListener {
			public void onGetMusicListSuccess(Music[] result);
		}

		public static RequestObject<OnGetMusicListSuccessListener> getMusicList() {
			RequestObject<OnGetMusicListSuccessListener> obj = new RequestObject<OnGetMusicListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetMusicListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getmusiclist" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnShareVideoFlowSuccessListener {
			public void onShareVideoFlowSuccess(VideoFlow result);
		}

		public static RequestObject<OnShareVideoFlowSuccessListener> shareVideoFlow(Review review) {
			RequestObject<OnShareVideoFlowSuccessListener> obj = new RequestObject<OnShareVideoFlowSuccessListener>();
			obj.setListenerInterfaceClass(OnShareVideoFlowSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/sharevideoflow" + ".json");
			obj.setObj(review);
			obj.enque();
			return obj;
		}
		public static interface OnUploadVideoPhotoSuccessListener {
			public void onUploadVideoPhotoSuccess(String result);
		}

		public static RequestObject<OnUploadVideoPhotoSuccessListener> uploadVideoPhoto(VideoFlowVo videoFlowVo) {
			RequestObject<OnUploadVideoPhotoSuccessListener> obj = new RequestObject<OnUploadVideoPhotoSuccessListener>();
			obj.setListenerInterfaceClass(OnUploadVideoPhotoSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/uploadvideophoto" + ".json");
			obj.setObj(videoFlowVo);
			obj.enque();
			return obj;
		}
		public static interface OnGetOthersVideoFlowSuccessListener {
			public void onGetOthersVideoFlowSuccess(VideoFlowExt[] result);
		}

		public static RequestObject<OnGetOthersVideoFlowSuccessListener> getOthersVideoFlow(String friendId, long timeStamp) {
			RequestObject<OnGetOthersVideoFlowSuccessListener> obj = new RequestObject<OnGetOthersVideoFlowSuccessListener>();
			obj.setListenerInterfaceClass(OnGetOthersVideoFlowSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/inf/getothersvideoflow" + ".json");
			obj.addParam("friendid", friendId);
			obj.addParam("timestamp", timeStamp);
			obj.enque();
			return obj;
		}
}
