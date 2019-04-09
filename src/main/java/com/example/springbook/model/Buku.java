package com.example.springbook.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="books")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updateAt"}, allowGetters = true)
@Getter
@Setter
public class Buku {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String titleBook;
	
	private String namaDepanPengarang;
	
	private String namaBelakangPengarang;
	
	private int statusPeminjaman;
	
	private String namaPeminjam;
	
	@Column(nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}

	public String getNamaDepanPengarang() {
		return namaDepanPengarang;
	}

	public void setNamaDepanPengarang(String namaDepanPengarang) {
		this.namaDepanPengarang = namaDepanPengarang;
	}

	public String getNamaBelakangPengarang() {
		return namaBelakangPengarang;
	}

	public void setNamaBelakangPengarang(String namaBelakangPengarang) {
		this.namaBelakangPengarang = namaBelakangPengarang;
	}

	public int getStatusPeminjaman() {
		return statusPeminjaman;
	}

	public void setStatusPeminjaman(int statusPeminjaman) {
		this.statusPeminjaman = statusPeminjaman;
	}

	public String getNamaPeminjam() {
		return namaPeminjam;
	}

	public void setNamaPeminjam(String namaPeminjam) {
		this.namaPeminjam = namaPeminjam;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
