/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/30/2022  4:28 PM
Last Modified on 11/30/20224:28 PM
Version 1.0
*/


package com.bcafinance.bpbspringboot.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase_order")
@Getter
@Setter
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @Column(name = "id_po",length=22)
    private String idPo;
    @Column(name = "no_po",length=25)
    private String noPo;
    @Column(name = "tgl_po")
    private Date tglPo;
    @Column(name = "cabang_divisi",length = 50)
    private String cabangDivisi;
    @Column (name = "kode_barang", length=20)
    private String kodeBarang;
    @Column (name = "kode_jasa", length=20)
    private String kodeJasa;
    @Column (name = "kode_noni", length=20)
    private String kodeNonI;
    @Column(name = "nama_jasa",length = 150)
    private String namaJasa;
    @Column(name = "nama_barang",length = 150)
    private String namaBarang;
    @Column(name = "nama_noni",length = 150)
    private String namaNonI;
    @Column (name = "kode_rekanan", length=20)
    private String kodeRekanan;
    @Column (name = "nama_po", length=20)
    private String namaPo;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "satuan",length = 25)
    private String satuan;
    @Column(name = "jumlah_setuju")
    private Integer jumlahSetuju;
    @Column(name = "harga")
    private BigDecimal harga;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "ppn")
    private BigDecimal ppn;
    @Column(name = "pph")
    private BigDecimal pph;
    @Column(name = "grand_total")
    private BigDecimal grandTotal;
    @Column(name="terbilang",length=200)
    private String terbilang;
    @Column(name = "reason",length = 100)
    private String reason;
    @Column(name = "status",length = 25)
    private String status;
    @Column(name="spesifikasi", length=500)
    private String spesifikasi;
    @Column (name = "keterangan", length=500)
    private String keterangan;
    @Column (name = "catatan", length=500)
    private String Catatan;
    @Column (name ="term_of_payment", length=500)
    private String termOfPayment;
    @Column(name = "L2",length =10)
    private String L2;
    @Column(name = "L1",length =10)
    private String L1;
    @Column(name="tgl_input_l2")
    private Date tglInputL2;
    @Column(name="tgl_input_l1")
    private Date tglInputL1;
    @Column(name="user_id",length=10)
    private String userId;
    @Column(name = "hapus",length=5)
    private String hapus;
}
