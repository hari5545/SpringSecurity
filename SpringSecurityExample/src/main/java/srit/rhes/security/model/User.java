package srit.rhes.security.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User implements Serializable{

	private static final long serialVersionUID = -3406383378820169244L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int userId;
	
	@Column(name="user_name")
	protected String userName;
	
	protected String password;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	protected Set<Role> role;

	public User() {
		super();
	}

	public User(User user) {
		super();
		this.userId = user.userId;
		this.userName =user. userName;
		this.password = user.password;
		this.role = user.role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}
