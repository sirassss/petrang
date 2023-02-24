package com.anhlam.petrang.service.Impl;

import com.anhlam.petrang.domain.NhanVien;
import com.anhlam.petrang.repository.NhanVienRepository;
import com.anhlam.petrang.repository.SanPhamRepository;
import com.anhlam.petrang.repository.impl.NhanVienRepoImpl;
import com.anhlam.petrang.service.NhanVienService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final SanPhamRepository sanPhamRepository;

    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository, SanPhamRepository sanPhamRepository) {
        this.nhanVienRepository = nhanVienRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    @Override
    public List<NhanVien> getNhanVien() {
        nhanVienRepository.getNhanVien2();
        return nhanVienRepository.getNhanVien();
//        return nhanVienRepository.getNhanVien();
    }

    @Override
    public NhanVien createNhanVien(NhanVien nhanVienv) {
        List<NhanVien> lst = new ArrayList<>();
        return nhanVienv;
    }

    @Override
    public NhanVien updateNhanVien(NhanVien nv) {
        return null;
    }

    @Override
    public List<NhanVien> getProcNhanVien() {
        return nhanVienRepository.getProcNhanVien();
    }
}
