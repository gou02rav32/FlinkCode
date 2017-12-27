package com.TableAPIEx;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAnySetter;

public class TwitterUtil {
	
	public String geo;
	public String in_reply_to_status_id;
	public String truncated;
	public String retweet_count;
	public String in_reply_to_user_id;
	public String id_str;
	public String place;
	public boolean favorited;
	public String source;
	public String in_reply_to_screen_name;
	public String in_reply_to_status_id_str;
	public long id;
	public String contributors;
	public String coordinates;
	public boolean retweeted;
	public String text;
	public String profile_image_url;
	public UserInfo user;
	@JsonAnyGetter
	public UserInfo getUser() {
		return user;
	}
	@JsonAnySetter
	public void setUser(UserInfo user) {
		this.user = user;
	}
	@JsonAnyGetter
	public String getGeo() {
		return geo;
	}
	@JsonAnySetter
	public void setGeo(String geo) {
		this.geo = geo;
	}
	@JsonAnyGetter
	public String getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}
	@JsonAnySetter
	public void setIn_reply_to_status_id(String in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
	@JsonAnyGetter
	public String getTruncated() {
		return truncated;
	}
	@JsonAnySetter
	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}
	@JsonAnyGetter
	public String getRetweet_count() {
		return retweet_count;
	}
	@JsonAnySetter
	public void setRetweet_count(String retweet_count) {
		this.retweet_count = retweet_count;
	}
	@JsonAnyGetter
	public String getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	@JsonAnySetter
	public void setIn_reply_to_user_id(String in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
	@JsonAnyGetter
	public String getId_str() {
		return id_str;
	}
	@JsonAnySetter
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}
	@JsonAnyGetter
	public String getPlace() {
		return place;
	}
	@JsonAnySetter
	public void setPlace(String place) {
		this.place = place;
	}
	@JsonAnyGetter
	public boolean isFavorited() {
		return favorited;
	}
	@JsonAnySetter
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	@JsonAnyGetter
	public String getSource() {
		return source;
	}
	@JsonAnySetter
	public void setSource(String source) {
		this.source = source;
	}
	@JsonAnyGetter
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}
	@JsonAnySetter
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}
	@JsonAnyGetter
	public String getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}
	@JsonAnySetter
	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}
	@JsonAnyGetter
	public long getId() {
		return id;
	}
	@JsonAnySetter
	public void setId(long id) {
		this.id = id;
	}
	@JsonAnyGetter
	public String getContributors() {
		return contributors;
	}
	@JsonAnySetter
	public void setContributors(String contributors) {
		this.contributors = contributors;
	}
	@JsonAnyGetter
	public String getCoordinates() {
		return coordinates;
	}
	@JsonAnySetter
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public boolean isRetweeted() {
		return retweeted;
	}
	@JsonAnySetter
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}
	@JsonAnyGetter
	public String getText() {
		return text;
	}
	@JsonAnySetter
	public void setText(String text) {
		this.text = text;
	}
	@JsonAnyGetter
	public String getProfile_image_url() {
		return profile_image_url;
	}
	@JsonAnySetter
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	public TwitterUtil(String geo, String in_reply_to_status_id, String truncated, String retweet_count,
			String in_reply_to_user_id, String id_str, String place, boolean favorited, String source,
			String in_reply_to_screen_name, String in_reply_to_status_id_str, long id, String contributors,
			String coordinates, boolean retweeted, String text, String profile_image_url, UserInfo user) {
		super();
		this.geo = geo;
		this.in_reply_to_status_id = in_reply_to_status_id;
		this.truncated = truncated;
		this.retweet_count = retweet_count;
		this.in_reply_to_user_id = in_reply_to_user_id;
		this.id_str = id_str;
		this.place = place;
		this.favorited = favorited;
		this.source = source;
		this.in_reply_to_screen_name = in_reply_to_screen_name;
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
		this.id = id;
		this.contributors = contributors;
		this.coordinates = coordinates;
		this.retweeted = retweeted;
		this.text = text;
		this.profile_image_url = profile_image_url;
		this.user = user;
	}
	
}



	
	
	
	
/*	
	
	public String coordinates;
	public String favorited;
	public String created_at;
	public String truncated;
	public String text;
	public String contributors;
	public String id;
	public String geo;
	public String in_reply_to_user_id;
	public String place;
	public String in_reply_to_screen_name;
	
	@JsonAnyGetter
	public String getCoordinates() {
		return coordinates;
	}
	@JsonAnySetter
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	@JsonAnyGetter
	public String getFavorited() {
		return favorited;
	}
	@JsonAnySetter
	public void setFavorited(String favorited) {
		this.favorited = favorited;
	}
	@JsonAnyGetter
	public String getCreated_at() {
		return created_at;
	}
	@JsonAnySetter
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTruncated() {
		return truncated;
	}
	@JsonAnySetter
	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}
	@JsonAnyGetter
	public String getText() {
		return text;
	}
	@JsonAnySetter
	public void setText(String text) {
		this.text = text;
	}
	@JsonAnyGetter
	public String getContributors() {
		return contributors;
	}
	@JsonAnySetter
	public void setContributors(String contributors) {
		this.contributors = contributors;
	}
	@JsonAnyGetter
	public String getId() {
		return id;
	}
	@JsonAnySetter
	public void setId(String id) {
		this.id = id;
	}
	@JsonAnyGetter
	public String getGeo() {
		return geo;
	}
	@JsonAnySetter
	public void setGeo(String geo) {
		this.geo = geo;
	}
	@JsonAnyGetter
	public String getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	@JsonAnySetter
	public void setIn_reply_to_user_id(String in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
	@JsonAnyGetter
	public String getPlace() {
		return place;
	}
	@JsonAnySetter
	public void setPlace(String place) {
		this.place = place;
	}
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}
	@JsonAnySetter
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}*/
