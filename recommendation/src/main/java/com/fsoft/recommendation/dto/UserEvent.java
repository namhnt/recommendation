package com.fsoft.recommendation.dto;

import java.util.Date;

/**
 * 
 * @author NamHNT1
 * Template for user event that we need to generate data
 */

public class UserEvent {
	
	private String AccountId;
	private String ItemId;
	private Date EventTime;
	private Float Rating;
	
	public UserEvent() {
		
	}
	
	public UserEvent(String accountid, String itemId, Float rating) {
		AccountId = accountid;
		ItemId = itemId;
		Rating = rating;
	}
	
	@Override
	public String toString() {
		return "UserEvent [AccountId=" + AccountId + ", ItemId=" + getItemId()
				+ ", Rating=" + getRating() + "]";
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return ItemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		ItemId = itemId;
	}

	/**
	 * @return the rating
	 */
	public Float getRating() {
		return Rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Float rating) {
		Rating = rating;
	}

	/**
	 * @return the eventTime
	 */
	public Date getEventTime() {
		return EventTime;
	}

	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(Date eventTime) {
		EventTime = eventTime;
	}
}
