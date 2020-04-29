package com.community.domain;

import com.alibaba.fastjson.annotation.JSONField;

/*发表说说的图片*/
public class SSImg {

	/* 发表说说图片的主键 */
	private String iid;
	/* 发表说好搜上传图片的地址 */
	private String path;
	/* 图片附属于那个说说 */
	@JSONField(serialize = false)
	private SS ss;
	
	public SSImg() {
		super();
	}
	public SSImg(String iid, String path, SS ss) {
		super();
		this.iid = iid;
		this.path = path;
		this.ss = ss;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public SS getSs() {
		return ss;
	}
	public void setSs(SS ss) {
		this.ss = ss;
	}
}
