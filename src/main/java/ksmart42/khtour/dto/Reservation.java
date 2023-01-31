package ksmart42.khtour.dto;

public class Reservation {
	
	private String roomReservationCode;
	private String memberId;
	private String ldgCode;
	private String checkInDate;
	private String chekOutDate;
	private String reservationName;
	private String reservationPhone;
	private String userName;
	private String usrePhone;
	private String roomName;
	private String lodgmentDay;
	private String totalPrice;
	private String reservationDate;
	
	public String getRoomReservationCode() {
		return roomReservationCode;
	}
	public void setRoomReservationCode(String roomReservationCode) {
		this.roomReservationCode = roomReservationCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLdgCode() {
		return ldgCode;
	}
	public void setLdgCode(String ldgCode) {
		this.ldgCode = ldgCode;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getChekOutDate() {
		return chekOutDate;
	}
	public void setChekOutDate(String chekOutDate) {
		this.chekOutDate = chekOutDate;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getReservationPhone() {
		return reservationPhone;
	}
	public void setReservationPhone(String reservationPhone) {
		this.reservationPhone = reservationPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsrePhone() {
		return usrePhone;
	}
	public void setUsrePhone(String usrePhone) {
		this.usrePhone = usrePhone;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getLodgmentDay() {
		return lodgmentDay;
	}
	public void setLodgmentDay(String lodgmentDay) {
		this.lodgmentDay = lodgmentDay;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	@Override
	public String toString() {
		return "Reservation [roomReservationCode=" + roomReservationCode + ", memberId=" + memberId + ", ldgCode="
				+ ldgCode + ", checkInDate=" + checkInDate + ", chekOutDate=" + chekOutDate + ", reservationName="
				+ reservationName + ", reservationPhone=" + reservationPhone + ", userName=" + userName + ", usrePhone="
				+ usrePhone + ", roomName=" + roomName + ", lodgmentDay=" + lodgmentDay + ", totalPrice=" + totalPrice
				+ ", reservationDate=" + reservationDate + "]";
	}	
	


}
