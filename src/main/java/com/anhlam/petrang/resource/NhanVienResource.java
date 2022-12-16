package com.anhlam.petrang.resource;

import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.domain.SanPham;
import com.anhlam.petrang.repository.impl.SanPhamRepoCustom;
import com.anhlam.petrang.service.NhanVienService;
//import com.google.gson.Gson;
import com.anhlam.petrang.service.SanPhamService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class NhanVienResource {

    private final NhanVienService nhanVienService;
    private final SanPhamService sanPhamService;
    private final SanPhamRepoCustom sanPhamRepoCustom;
    private final RestTemplateBuilder restTemplateBuilder;

    public NhanVienResource(NhanVienService nhanVienService, SanPhamService sanPhamService, SanPhamRepoCustom sanPhamRepoCustom, RestTemplateBuilder restTemplateBuilder) {
        this.nhanVienService = nhanVienService;
        this.sanPhamService = sanPhamService;
        this.sanPhamRepoCustom = sanPhamRepoCustom;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @GetMapping("/nhan-vien")
    public ResponseEntity<List<NhanVien>> getNhanVien() {
        List<NhanVien> nv = nhanVienService.getNhanVien();
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham")
    public ResponseEntity<List<SanPham>> getListSanPham() {
        List<SanPham> nv = sanPhamService.getListSanPham();
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham-by-mahsx/{mahsx}")
    public ResponseEntity<List<SanPham>> getListSanPham(@PathVariable Long mahsx) {
        List<SanPham> nv = sanPhamService.getListSanPhamByMaHangSx(mahsx);
        return ResponseEntity.ok().body(nv);
    }

    @PostMapping("/san-pham")
    public ResponseEntity<SanPham> createProduct(@RequestBody SanPham sanPham) {
        SanPham nv = sanPhamService.createProduct(sanPham);
        return ResponseEntity.ok().body(nv);
    }

    @GetMapping("/san-pham-dto")
    public ResponseEntity<List<SanPham>> getListSanPhamDTO() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        try {
            restTemplate.getClass().getField("anhlam");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        List<SanPham> nv = sanPhamService.getListSanPhamDTO();
        return ResponseEntity.ok().body(nv);
    }

//    @GetMapping("/test-jdbc")
//    public ResponseEntity<List<SanPham>> testJDBCExecutor() {
//        List<SanPham> nv = sanPhamRepoCustom.testJDBC();
//        return ResponseEntity.ok().body(nv);
//    }
}
