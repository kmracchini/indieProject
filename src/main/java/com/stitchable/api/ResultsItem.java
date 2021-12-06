package com.stitchable.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultsItem{

	@JsonProperty("vacation_autoreply")
	private Object vacationAutoreply;

	@JsonProperty("is_direct_checkout_onboarded")
	private boolean isDirectCheckoutOnboarded;

	@JsonProperty("is_using_structured_policies")
	private boolean isUsingStructuredPolicies;

	@JsonProperty("is_opted_in_to_buyer_promise")
	private boolean isOptedInToBuyerPromise;

	@JsonProperty("last_updated_tsz")
	private int lastUpdatedTsz;

	@JsonProperty("is_shop_us_based")
	private boolean isShopUsBased;

	@JsonProperty("is_calculated_eligible")
	private boolean isCalculatedEligible;

	@JsonProperty("title")
	private String title;

	@JsonProperty("include_dispute_form_link")
	private boolean includeDisputeFormLink;

	@JsonProperty("currency_code")
	private String currencyCode;

	@JsonProperty("has_onboarded_structured_policies")
	private boolean hasOnboardedStructuredPolicies;

	@JsonProperty("policy_shipping")
	private Object policyShipping;

	@JsonProperty("digital_listing_count")
	private int digitalListingCount;

	@JsonProperty("image_url_760x100")
	private String imageUrl760x100;

	@JsonProperty("digital_sale_message")
	private String digitalSaleMessage;

	@JsonProperty("upcoming_local_event_id")
	private Object upcomingLocalEventId;

	@JsonProperty("policy_privacy")
	private Object policyPrivacy;

	@JsonProperty("policy_seller_info")
	private String policySellerInfo;

	@JsonProperty("announcement")
	private String announcement;

	@JsonProperty("sale_message")
	private String saleMessage;

	@JsonProperty("languages")
	private List<String> languages;

	@JsonProperty("has_unstructured_policies")
	private boolean hasUnstructuredPolicies;

	@JsonProperty("is_vacation")
	private boolean isVacation;

	@JsonProperty("num_favorers")
	private int numFavorers;

	@JsonProperty("shop_name")
	private String shopName;

	@JsonProperty("policy_additional")
	private Object policyAdditional;

	@JsonProperty("url")
	private String url;

	@JsonProperty("listing_active_count")
	private int listingActiveCount;

	@JsonProperty("policy_welcome")
	private Object policyWelcome;

	@JsonProperty("shop_id")
	private int shopId;

	@JsonProperty("login_name")
	private String loginName;

	@JsonProperty("accepts_custom_requests")
	private boolean acceptsCustomRequests;

	@JsonProperty("policy_refunds")
	private String policyRefunds;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("vacation_message")
	private Object vacationMessage;

	@JsonProperty("creation_tsz")
	private int creationTsz;

	@JsonProperty("icon_url_fullxfull")
	private String iconUrlFullxfull;

	@JsonProperty("policy_updated_tsz")
	private int policyUpdatedTsz;

	@JsonProperty("policy_payment")
	private Object policyPayment;

	@JsonProperty("policy_has_private_receipt_info")
	private boolean policyHasPrivateReceiptInfo;

	@JsonProperty("custom_shops_state")
	private int customShopsState;

	public int getCustomShopsState() {
		return customShopsState;
	}

	public Object getVacationAutoreply(){
		return vacationAutoreply;
	}

	public boolean isIsDirectCheckoutOnboarded(){
		return isDirectCheckoutOnboarded;
	}

	public boolean isIsUsingStructuredPolicies(){
		return isUsingStructuredPolicies;
	}

	public boolean isIsOptedInToBuyerPromise(){
		return isOptedInToBuyerPromise;
	}

	public int getLastUpdatedTsz(){
		return lastUpdatedTsz;
	}

	public boolean isIsShopUsBased(){
		return isShopUsBased;
	}

	public boolean isIsCalculatedEligible(){
		return isCalculatedEligible;
	}

	public String getTitle(){
		return title;
	}

	public boolean isIncludeDisputeFormLink(){
		return includeDisputeFormLink;
	}

	public String getCurrencyCode(){
		return currencyCode;
	}

	public boolean isHasOnboardedStructuredPolicies(){
		return hasOnboardedStructuredPolicies;
	}

	public Object getPolicyShipping(){
		return policyShipping;
	}

	public int getDigitalListingCount(){
		return digitalListingCount;
	}

	public String getImageUrl760x100(){
		return imageUrl760x100;
	}

	public String getDigitalSaleMessage(){
		return digitalSaleMessage;
	}

	public Object getUpcomingLocalEventId(){
		return upcomingLocalEventId;
	}

	public Object getPolicyPrivacy(){
		return policyPrivacy;
	}

	public String getPolicySellerInfo(){
		return policySellerInfo;
	}

	public String getAnnouncement(){
		return announcement;
	}

	public String getSaleMessage(){
		return saleMessage;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public boolean isHasUnstructuredPolicies(){
		return hasUnstructuredPolicies;
	}

	public boolean isIsVacation(){
		return isVacation;
	}

	public int getNumFavorers(){
		return numFavorers;
	}

	public String getShopName(){
		return shopName;
	}

	public Object getPolicyAdditional(){
		return policyAdditional;
	}

	public String getUrl(){
		return url;
	}

	public int getListingActiveCount(){
		return listingActiveCount;
	}

	public Object getPolicyWelcome(){
		return policyWelcome;
	}

	public int getShopId(){
		return shopId;
	}

	public String getLoginName(){
		return loginName;
	}

	public boolean isAcceptsCustomRequests(){
		return acceptsCustomRequests;
	}

	public String getPolicyRefunds(){
		return policyRefunds;
	}

	public int getUserId(){
		return userId;
	}

	public Object getVacationMessage(){
		return vacationMessage;
	}

	public int getCreationTsz(){
		return creationTsz;
	}

	public String getIconUrlFullxfull(){
		return iconUrlFullxfull;
	}

	public int getPolicyUpdatedTsz(){
		return policyUpdatedTsz;
	}

	public Object getPolicyPayment(){
		return policyPayment;
	}

	public boolean isPolicyHasPrivateReceiptInfo(){
		return policyHasPrivateReceiptInfo;
	}
}