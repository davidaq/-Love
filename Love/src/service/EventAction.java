package service;
import util.RequestObject;
import bean.*;
public final class EventAction {
		public static interface OnGetEventListSuccessListener {
			public void onGetEventListSuccess(EventDetail[] result);
		}

		public static RequestObject<OnGetEventListSuccessListener> getEventList() {
			RequestObject<OnGetEventListSuccessListener> obj = new RequestObject<OnGetEventListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetEventListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/geteventlist" + ".json");
			obj.enque();
			return obj;
		}
		public static interface OnGetEventDetailSuccessListener {
			public void onGetEventDetailSuccess(EventContent result);
		}

		public static RequestObject<OnGetEventDetailSuccessListener> getEventDetail(String eventId) {
			RequestObject<OnGetEventDetailSuccessListener> obj = new RequestObject<OnGetEventDetailSuccessListener>();
			obj.setListenerInterfaceClass(OnGetEventDetailSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/geteventdetail" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnGetMoreGallerySuccessListener {
			public void onGetMoreGallerySuccess(Gallery[] result);
		}

		public static RequestObject<OnGetMoreGallerySuccessListener> getMoreGallery(String eventId) {
			RequestObject<OnGetMoreGallerySuccessListener> obj = new RequestObject<OnGetMoreGallerySuccessListener>();
			obj.setListenerInterfaceClass(OnGetMoreGallerySuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getmoregallery" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnGetJoinedListSuccessListener {
			public void onGetJoinedListSuccess(UserProperty[] result);
		}

		public static RequestObject<OnGetJoinedListSuccessListener> getJoinedList(String eventId) {
			RequestObject<OnGetJoinedListSuccessListener> obj = new RequestObject<OnGetJoinedListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetJoinedListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getjoinedlist" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnGetInviteListSuccessListener {
			public void onGetInviteListSuccess(EventInviteExt[] result);
		}

		public static RequestObject<OnGetInviteListSuccessListener> getInviteList(String eventId, String subEventId) {
			RequestObject<OnGetInviteListSuccessListener> obj = new RequestObject<OnGetInviteListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetInviteListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getinvitelist" + ".json");
			obj.addParam("eventId", eventId);
			obj.addParam("subEventId", subEventId);
			obj.enque();
			return obj;
		}
		public static interface OnJoinEventSuccessListener {
			public void onJoinEventSuccess();
		}

		public static RequestObject<OnJoinEventSuccessListener> joinEvent(String eventId, String subEventId) {
			RequestObject<OnJoinEventSuccessListener> obj = new RequestObject<OnJoinEventSuccessListener>();
			obj.setListenerInterfaceClass(OnJoinEventSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/joinevent" + ".json");
			obj.addParam("eventId", eventId);
			obj.addParam("subEventId", subEventId);
			obj.enque();
			return obj;
		}
		public static interface OnDenyEventSuccessListener {
			public void onDenyEventSuccess();
		}

		public static RequestObject<OnDenyEventSuccessListener> denyEvent(String eventId, String subEventId) {
			RequestObject<OnDenyEventSuccessListener> obj = new RequestObject<OnDenyEventSuccessListener>();
			obj.setListenerInterfaceClass(OnDenyEventSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/denyevent" + ".json");
			obj.addParam("eventId", eventId);
			obj.addParam("subEventId", subEventId);
			obj.enque();
			return obj;
		}
		public static interface OnCreateEventSuccessListener {
			public void onCreateEventSuccess(Event result);
		}

		public static RequestObject<OnCreateEventSuccessListener> createEvent(Event event, String[] fieldName, String[] fieldValue) {
			RequestObject<OnCreateEventSuccessListener> obj = new RequestObject<OnCreateEventSuccessListener>();
			obj.setListenerInterfaceClass(OnCreateEventSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/createevent" + ".json");
			obj.setObj(event);
			obj.addParam("fieldName", fieldName);
			obj.addParam("fieldValue", fieldValue);
			obj.enque();
			return obj;
		}
		public static interface OnModifyEventSuccessListener {
			public void onModifyEventSuccess();
		}

		public static RequestObject<OnModifyEventSuccessListener> modifyEvent(Event event, String[] fieldName, String[] fieldValue) {
			RequestObject<OnModifyEventSuccessListener> obj = new RequestObject<OnModifyEventSuccessListener>();
			obj.setListenerInterfaceClass(OnModifyEventSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/modifyevent" + ".json");
			obj.setObj(event);
			obj.addParam("fieldName", fieldName);
			obj.addParam("fieldValue", fieldValue);
			obj.enque();
			return obj;
		}
		public static interface OnCreateSubEventSuccessListener {
			public void onCreateSubEventSuccess(SubEvent result);
		}

		public static RequestObject<OnCreateSubEventSuccessListener> createSubEvent(String eventId, SubEvent subEvent) {
			RequestObject<OnCreateSubEventSuccessListener> obj = new RequestObject<OnCreateSubEventSuccessListener>();
			obj.setListenerInterfaceClass(OnCreateSubEventSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/createsubevent" + ".json");
			obj.addParam("eventId", eventId);
			obj.setObj(subEvent);
			obj.enque();
			return obj;
		}
		public static interface OnModifySubEventSuccessListener {
			public void onModifySubEventSuccess();
		}

		public static RequestObject<OnModifySubEventSuccessListener> modifySubEvent(SubEvent subEvent) {
			RequestObject<OnModifySubEventSuccessListener> obj = new RequestObject<OnModifySubEventSuccessListener>();
			obj.setListenerInterfaceClass(OnModifySubEventSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/modifysubevent" + ".json");
			obj.setObj(subEvent);
			obj.enque();
			return obj;
		}
		public static interface OnCheckInSuccessListener {
			public void onCheckInSuccess();
		}

		public static RequestObject<OnCheckInSuccessListener> checkIn(String eventId) {
			RequestObject<OnCheckInSuccessListener> obj = new RequestObject<OnCheckInSuccessListener>();
			obj.setListenerInterfaceClass(OnCheckInSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/checkin" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnGetCheckedListSuccessListener {
			public void onGetCheckedListSuccess(UserProperty[] result);
		}

		public static RequestObject<OnGetCheckedListSuccessListener> getCheckedList(String eventId) {
			RequestObject<OnGetCheckedListSuccessListener> obj = new RequestObject<OnGetCheckedListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetCheckedListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getcheckedlist" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnUploadPicCoverSuccessListener {
			public void onUploadPicCoverSuccess();
		}

		public static RequestObject<OnUploadPicCoverSuccessListener> uploadPicCover(String id, int type, String imgUrl) {
			RequestObject<OnUploadPicCoverSuccessListener> obj = new RequestObject<OnUploadPicCoverSuccessListener>();
			obj.setListenerInterfaceClass(OnUploadPicCoverSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/uploadpiccover" + ".json");
			obj.addParam("id", id);
			obj.addParam("type", type);
			obj.addParam("imgUrl", imgUrl);
			obj.enque();
			return obj;
		}
		public static interface OnBroadcastMessageSuccessListener {
			public void onBroadcastMessageSuccess();
		}

		public static RequestObject<OnBroadcastMessageSuccessListener> broadcastMessage(String eventId, NotifyMsg msg) {
			RequestObject<OnBroadcastMessageSuccessListener> obj = new RequestObject<OnBroadcastMessageSuccessListener>();
			obj.setListenerInterfaceClass(OnBroadcastMessageSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/broadcastmessage" + ".json");
			obj.addParam("eventId", eventId);
			obj.setObj(msg);
			obj.enque();
			return obj;
		}
		public static interface OnSendInvitationSuccessListener {
			public void onSendInvitationSuccess();
		}

		public static RequestObject<OnSendInvitationSuccessListener> sendInvitation(String eventId, String subEventId, String[] userIdArray) {
			RequestObject<OnSendInvitationSuccessListener> obj = new RequestObject<OnSendInvitationSuccessListener>();
			obj.setListenerInterfaceClass(OnSendInvitationSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/sendinvitation" + ".json");
			obj.addParam("eventId", eventId);
			obj.addParam("subEventId", subEventId);
			obj.addParam("userIdArray", userIdArray);
			obj.enque();
			return obj;
		}
		public static interface OnGetSubEventListSuccessListener {
			public void onGetSubEventListSuccess(SubEvent[] result);
		}

		public static RequestObject<OnGetSubEventListSuccessListener> getSubEventList(String eventId) {
			RequestObject<OnGetSubEventListSuccessListener> obj = new RequestObject<OnGetSubEventListSuccessListener>();
			obj.setListenerInterfaceClass(OnGetSubEventListSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getsubeventlist" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnCreateEventInvitationSuccessListener {
			public void onCreateEventInvitationSuccess(EventInvitation result);
		}

		public static RequestObject<OnCreateEventInvitationSuccessListener> createEventInvitation(EventInvitation eventInvitation) {
			RequestObject<OnCreateEventInvitationSuccessListener> obj = new RequestObject<OnCreateEventInvitationSuccessListener>();
			obj.setListenerInterfaceClass(OnCreateEventInvitationSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/createeventinvitation" + ".json");
			obj.setObj(eventInvitation);
			obj.enque();
			return obj;
		}
		public static interface OnGetEventInvitationSuccessListener {
			public void onGetEventInvitationSuccess(EventInvitation result);
		}

		public static RequestObject<OnGetEventInvitationSuccessListener> getEventInvitation(String eventId) {
			RequestObject<OnGetEventInvitationSuccessListener> obj = new RequestObject<OnGetEventInvitationSuccessListener>();
			obj.setListenerInterfaceClass(OnGetEventInvitationSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/geteventinvitation" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnGetSubEventCountSuccessListener {
			public void onGetSubEventCountSuccess(int result);
		}

		public static RequestObject<OnGetSubEventCountSuccessListener> getSubEventCount(String eventId) {
			RequestObject<OnGetSubEventCountSuccessListener> obj = new RequestObject<OnGetSubEventCountSuccessListener>();
			obj.setListenerInterfaceClass(OnGetSubEventCountSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getsubeventcount" + ".json");
			obj.addParam("eventId", eventId);
			obj.enque();
			return obj;
		}
		public static interface OnModifyInviteStateSuccessListener {
			public void onModifyInviteStateSuccess();
		}

		public static RequestObject<OnModifyInviteStateSuccessListener> modifyInviteState(String eventId, String userId, Integer state) {
			RequestObject<OnModifyInviteStateSuccessListener> obj = new RequestObject<OnModifyInviteStateSuccessListener>();
			obj.setListenerInterfaceClass(OnModifyInviteStateSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/modifyinvitestate" + ".json");
			obj.addParam("eventId", eventId);
			obj.addParam("userId", userId);
			obj.addParam("state", state);
			obj.enque();
			return obj;
		}
		public static interface OnGetTop4PhotoByEventIdSuccessListener {
			public void onGetTop4PhotoByEventIdSuccess(String[] result);
		}

		public static RequestObject<OnGetTop4PhotoByEventIdSuccessListener> getTop4PhotoByEventId(String eventId, int type) {
			RequestObject<OnGetTop4PhotoByEventIdSuccessListener> obj = new RequestObject<OnGetTop4PhotoByEventIdSuccessListener>();
			obj.setListenerInterfaceClass(OnGetTop4PhotoByEventIdSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/gettop4photobyeventid" + ".json");
			obj.addParam("eventid", eventId);
			obj.addParam("type", type);
			obj.enque();
			return obj;
		}
		public static interface OnGetOthersEventsSuccessListener {
			public void onGetOthersEventsSuccess(Event[] result);
		}

		public static RequestObject<OnGetOthersEventsSuccessListener> getOthersEvents(String friendId) {
			RequestObject<OnGetOthersEventsSuccessListener> obj = new RequestObject<OnGetOthersEventsSuccessListener>();
			obj.setListenerInterfaceClass(OnGetOthersEventsSuccessListener.class);
			obj.setUrl(RequestObject.baseUrl + "/getothersevents" + ".json");
			obj.addParam("friendid", friendId);
			obj.enque();
			return obj;
		}
}
