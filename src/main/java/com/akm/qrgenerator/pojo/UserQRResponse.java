package com.akm.qrgenerator.pojo;

public class UserQRResponse {

	private UserQRRequest userQrRequest;

	private String status;
	
	private String image;

	private String failureReason;

	public UserQRRequest getUserQrRequest() {
		return userQrRequest;
	}

	public void setUserQrRequest(UserQRRequest userQrRequest) {
		this.userQrRequest = userQrRequest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
