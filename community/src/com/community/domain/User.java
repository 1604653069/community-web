package com.community.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.annotation.JSONField;

/*用户实体类*/
public class User {
	private String uid;
	/* 用户名 */
	private String username;
	/* 密码 */
	private String password;
	/* 用户名称 */
	private String name;
	/* 用户性别 */
	private String sex;
	/* 用户联系电话 */
	private String tel;
	/* 用户地址 */
	private String address;
	/* 用户账号状态 0未激活 1激活*/
	private String state;
	/* 用户角色类型 0管理员 1普通用户*/
	private String type;
	/* 报事维修 */
	@JSONField(serialize = false)
	private Set<Repair> repairs = new HashSet<Repair>();
	/* 用户的收货地址 */
	private Set<Address> addreses  = new HashSet<Address>();
	/* 用户余额 */
	public User() {
		super();
	}
	public User(String uid, String username, String password, String name, String sex, String tel, String address,
			String state, String type) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.state = state;
		this.type = type;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Repair> getRepairs() {
		return repairs;
	}
	public void setRepairs(Set<Repair> repairs) {
		this.repairs = repairs;
	}
	public Set<Address> getAddreses() {
		return addreses;
	}
	public void setAddreses(Set<Address> addreses) {
		this.addreses = addreses;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", tel=" + tel + ", address=" + address + ", state=" + state + ", type=" + type + "]";
	}
}
