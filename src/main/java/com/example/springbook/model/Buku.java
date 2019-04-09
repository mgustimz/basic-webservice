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

	@Column(name = "book_title")
	private String titleBook;

	@Column(name = "first_name_creator")
	private String namaDepanPengarang;

	@Column(name = "last_name_creator")
	private String namaBelakangPengarang;

	@Column(name = "status")
	private int statusPeminjaman;

	@Column(name = "name")
	private String namaPeminjam;
	
	@Column(name = "created_date", nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(name = "modified_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateAt;

}
