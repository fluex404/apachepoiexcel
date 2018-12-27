package com.fluex404.apachepoiexcel.dao;

import com.fluex404.apachepoiexcel.model.Siswa;

import java.util.ArrayList;
import java.util.List;

public class SiswaDao {

    public List<Siswa> findall() {
        List<Siswa> siswas = new ArrayList<>();

        /* Initialize */
        siswas.add(new Siswa(1, "Isa", "XII-A", "TKJ"));
        siswas.add(new Siswa(2, "Rara", "XII-A", "MM"));
        siswas.add(new Siswa(3, "Bela", "XII-A", "MM"));
        siswas.add(new Siswa(4, "Ahmad", "XII-A", "TKJ"));
        siswas.add(new Siswa(5, "Rani", "XII-A", "RPL"));
        siswas.add(new Siswa(6, "Imas", "XII-A", "TKJ"));

        return siswas;

    }


}
