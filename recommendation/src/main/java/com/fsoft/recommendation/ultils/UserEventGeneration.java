package com.fsoft.recommendation.ultils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import com.fsoft.recommendation.dto.*;

/**
 * 
 * @author NamHNT1
 * This class help us to generate user event with current schema data
 */

public class UserEventGeneration {
	
	private int RangeOfAccount;
	private List<String> RangeOfItem;
	int DefaultRating = 1;
	int MaxNumberEvent;
	int MaxNumberAccount;
	private Date InsertedTime;
	
	public UserEventGeneration() {
		setRangeOfItem(new ArrayList<String>());
	}
	
	public UserEventGeneration(int rangeAccount, List<String> rangeOfItem, int defaultRating, int maxNumberEvent, int maxNumberAccount, Date insertedTime) {
		this.setRangeOfAccount(rangeAccount);
		this.setRangeOfItem(rangeOfItem);
		this.DefaultRating = defaultRating;
		this.MaxNumberAccount = maxNumberAccount;
		this.MaxNumberEvent = maxNumberEvent;
		this.setInsertedTime(insertedTime);
	}
	
	public List<UserEvent> generateData() {
		List<UserEvent> result = new ArrayList<UserEvent>();
		Random rand = new Random();
		UserEvent event;
		for (int i = 0; i < this.getRangeOfAccount(); i++) {
			int randomIndexItem = rand.nextInt(getRangeOfItem().size());
			event = new UserEvent(ConstantValue.prefixAccount + i, this.getRangeOfItem().get(randomIndexItem), (float) 1.0);
			result.add(event);
		}
		return result;
		
	}
	
	public void storeUserEvent(String FileName) {
		
	       try {
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName), "UTF-8"));
	            List<UserEvent>  arrUserEvent = generateData();
	            for (UserEvent event : arrUserEvent) {
	                StringBuffer oneLine = new StringBuffer();
	                oneLine.append(event.getAccountId());
	                oneLine.append(ConstantValue.csvSeparator);
	                oneLine.append(event.getItemId());
	                oneLine.append(ConstantValue.csvSeparator);
	                oneLine.append(event.getRating().toString());
	                bw.write(oneLine.toString());
	                bw.newLine();
	            }
	            bw.flush();
	            bw.close();
	        }
	        catch (IOException e) {
	        	System.out.println("There are some error while genreating data");
	        } 
		
	}

	/**
	 * @return the rangeOfAccount
	 */
	public int getRangeOfAccount() {
		return RangeOfAccount;
	}

	/**
	 * @param rangeOfAccount the rangeOfAccount to set
	 */
	public void setRangeOfAccount(int rangeOfAccount) {
		RangeOfAccount = rangeOfAccount;
	}

	/**
	 * @return the rangeOfItem
	 */
	public List<String> getRangeOfItem() {
		return RangeOfItem;
	}

	/**
	 * @param rangeOfItem the rangeOfItem to set
	 */
	public void setRangeOfItem(List<String> rangeOfItem) {
		RangeOfItem = rangeOfItem;
	}

	/**
	 * @return the insertedTime
	 */
	public Date getInsertedTime() {
		return InsertedTime;
	}

	/**
	 * @param insertedTime the insertedTime to set
	 */
	public void setInsertedTime(Date insertedTime) {
		InsertedTime = insertedTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
