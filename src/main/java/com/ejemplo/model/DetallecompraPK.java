package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallecompra database table.
 * 
 */
@Embeddable
public class DetallecompraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer comid;

	private Integer detid;

	public DetallecompraPK() {
	}
	public Integer getComid() {
		return this.comid;
	}
	public void setComid(Integer comid) {
		this.comid = comid;
	}
	public Integer getDetid() {
		return this.detid;
	}
	public void setDetid(Integer detid) {
		this.detid = detid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallecompraPK)) {
			return false;
		}
		DetallecompraPK castOther = (DetallecompraPK)other;
		return 
			this.comid.equals(castOther.comid)
			&& this.detid.equals(castOther.detid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.comid.hashCode();
		hash = hash * prime + this.detid.hashCode();
		
		return hash;
	}
}