package com.example.springbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbook.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long>{

	List<Buku> findByStatusPeminjaman (int statusPeminjaman);
	List<Buku> findByTitleBook(String titleBook);
	
}
