package com.example.springbook.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbook.model.Buku;
import com.example.springbook.repository.BukuRepository;

@RestController
@RequestMapping("/buku")
public class BukuController {

	@Autowired
	BukuRepository bukuRepository;
	
	@GetMapping("/")
	public List<Buku> getAll() {
		return bukuRepository.findAll();
	}
	
	@PostMapping("/")
	public Buku tambahbuku(@Valid @RequestBody Buku buku) {
		return bukuRepository.save(buku);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Buku> updateBuku(@PathVariable(value="id") Long id, @Valid @RequestBody Buku detailBuku) {
		Optional<Buku> buku = bukuRepository.findById(id);
		if (buku.isPresent()) {
			Buku buku2 = buku.get();
			buku2.setNamaDepanPengarang(detailBuku.getNamaDepanPengarang());
			buku2.setNamaBelakangPengarang(detailBuku.getNamaBelakangPengarang());
			buku2.setNamaPeminjam(detailBuku.getNamaPeminjam());
			buku2.setStatusPeminjaman(detailBuku.getStatusPeminjaman());
			buku2.setTitleBook(detailBuku.getTitleBook());
			Buku updateBuku = bukuRepository.save(buku2);
			return ResponseEntity.ok(updateBuku);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteBuku(@PathVariable(value="id") Long id) {
		Optional<Buku> buku = bukuRepository.findById(id);
		String result = "";
		if (buku == null) {
			result = "id "+id+" tidak ditemukan.";
			return result;
		}
		result = "id "+id+" berhasil dihapus.";
		bukuRepository.deleteById(id);
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBukuById(@PathVariable(value="id") Long id) {
		Optional<Buku> buku = bukuRepository.findById(id);
		if (buku == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(buku);
	}
	
	@GetMapping("/sortbuku")
	public List<Buku> sortBuku(@RequestParam(value="title") String titleBook) {
		return bukuRepository.findByTitleBook(titleBook);
	}
	
	@GetMapping("/sortstatus/{statusPeminjaman}")
	public List<Buku> sortStatus(@PathVariable(value="statusPeminjaman") int statusPeminjaman) {
		return bukuRepository.findByStatusPeminjaman(statusPeminjaman);
	}

}
