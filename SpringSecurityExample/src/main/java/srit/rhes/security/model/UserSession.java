package srit.rhes.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_session")
public class UserSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="session_id" )
	protected int sessionId;
	
	@Column(name ="jsesssion_code")
	protected String jsessionCode;
	
	
	public UserSession() {
		super();
	}


	public UserSession(int sessionId, String jsessionCode) {
		super();
		this.sessionId = sessionId;
		this.jsessionCode = jsessionCode;
	}

	
	public int getSessionId() {
		return sessionId;
	}


	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}


	public String getJsessionCode() {
		return jsessionCode;
	}


	public void setJsessionCode(String jsessionCode) {
		this.jsessionCode = jsessionCode;
	}


	@Override
	public String toString() {
		return "UserSession [sessionId=" + sessionId + ", jsessionCode=" + jsessionCode + "]";
	}
	
	
}
