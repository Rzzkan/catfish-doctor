-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jul 2022 pada 16.26
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doclele`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_ciri`
--

CREATE TABLE `tbl_ciri` (
  `id_ciri` int(11) NOT NULL,
  `ciri_ciri` varchar(150) NOT NULL,
  `nilai_ciri` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_ciri`
--

INSERT INTO `tbl_ciri` (`id_ciri`, `ciri_ciri`, `nilai_ciri`) VALUES
(5, 'Pergerakan Ikan Menjadi Lemas', '0.6'),
(6, 'Kematian Setiap Hari Meningkat', '0.8'),
(7, 'Nafsu Makan Ikan Berkurang', '0.4'),
(8, 'Muncul Bintik Putih Pada Ikan', '1'),
(9, 'Terdapat Luka Merah Pada Sirip dan Perut Ikan', '1'),
(10, 'Perubahan Cuaca yang Exstrim', '0.8'),
(11, 'Perut Mengembung', '0.6'),
(12, 'Pangkal Sirip Bengkak', '1'),
(13, 'Tubuh Dipenuhi Luka ', '0.8'),
(14, 'Terjadi Diusia Bibit', '0.8'),
(15, 'Terjadi Pada Usia Siap Panen', '0.6'),
(17, 'Ikan Menggantung Tegak Dipermukaan', '0.6'),
(18, 'Kulit Berwarna Kuning', '1'),
(19, 'Air Keruh', '0.6'),
(20, 'Tidak Banyak Bergerak', '0,8');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pakar`
--

CREATE TABLE `tbl_pakar` (
  `id` int(11) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `pekerjaan` varchar(150) NOT NULL,
  `deskripsi` varchar(150) NOT NULL,
  `wa` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_pakar`
--

INSERT INTO `tbl_pakar` (`id`, `nama`, `alamat`, `pekerjaan`, `deskripsi`, `wa`) VALUES
(10, 'Herman Dwi Oktariandi', 'Kp Curah Cottok Rt01 Rw01 Kec. Kapongan Kab. Situbondo', 'Wiraswasta', 'Telah terjun pada bidang peternakan ikan lele selama 11 tahun', '6285258686867'),
(11, 'Catur Setio Sudarsono', 'Ds.Juglangan Kec.Kapongan Kab.Situbondo', 'Fasilitator kemitraan badan layanan umum lembaga pengolahan modal usaha kelautan perikanan', 'Telah melakukan studi banding dan pelatihan perawatan ikan lele dibanyak kota', '6285336334565'),
(13, 'QQ', 'Kel.Patokan Kab.Situbondo', 'Wirausaha', 'Telah memeliki pengalaman yang langsung terjun pada lapangan selama 14 tahun dan sebagai ketua pada komunitas petani lele', '6285233399988'),
(14, 'Muhammad Wahid Arif', 'Kp Curah Cottok Kec. Kapongan Kab. Situbondo', 'Petani Lele', 'Telah terjun pada bidang peternakan ikan lele selama 6 tahun dan menjadi anggota disalah satu kelompok komunitas petani lele di kota Situbondo', '6282261015155');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penyakit_solusi`
--

CREATE TABLE `tbl_penyakit_solusi` (
  `id_ps` int(11) NOT NULL,
  `penyakit` varchar(250) NOT NULL,
  `solusi` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_penyakit_solusi`
--

INSERT INTO `tbl_penyakit_solusi` (`id_ps`, `penyakit`, `solusi`) VALUES
(2, 'Penyakit Jamur', 'a.Angkat ikan dari kolam pindahkan ke kolam lain \nb.Bersihkan kolam ikan lalu berikan kapur pada kolam ikan\nc.Dan jemur kolam selama satu hari'),
(3, 'Penyakit Aeromonas Atau Sirip Merah', 'a.Pisahkan ikan yang terjangkit penyakit dengan yang tidak \nb.Berikan antibiotik sebanyak 50mg/hari\nc.Berikan selama 7 hari'),
(4, 'Penyakit Kuning', 'a.Pilih ikan yang terjangkit lalu pisah dengan yang sehat \nb.Pemberian pakan yang baik jangan sampai melawati batas exp \nc.Beri daun pepaya untuk obat penambah nafsu makan \nd.Sering ganti air kolam'),
(5, 'Usus Pecah', 'a.Pemberian pakan pada ikan secukupnya jangan berlebihan agar dapat dicerna oleh ikan \nb.Hindari pemberian pakan yang dekat pada tanggal exp'),
(6, 'Stress Berlebihan', 'a.Ganti air setiap hari agar terjaga kebersihan air \nb.Beri daun pepaya'),
(7, 'Penyakit Channel Catfish Virus', 'a.Pemberian makanan bergisi\nb.Penjagaan kwalitas air pada kolam \nc.Jaga kebersihan kolam ikan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` int(11) NOT NULL,
  `nama_user` varchar(150) NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `nama_user`, `username`, `password`) VALUES
(1, 'Admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `password`) VALUES
(1, 'dana1', 'Danamukti', '3fc0a7acf087f549ac2b266baf94b8b1'),
(2, 'posmal', 'abil faiz', '3fc0a7acf087f549ac2b266baf94b8b1'),
(3, 'Fahri3050', 'Ahmad Nur Fahri', '8667bcbce3f455b585a50bb60a90533d'),
(4, 'zilhan22', 'Moh.Zilhanim Hilma', '827ccb0eea8a706c4c34a16891f84e7b'),
(5, '', '', 'd41d8cd98f00b204e9800998ecf8427e'),
(6, 'esti26', 'Esti Dwi Nuraini', '3fc0a7acf087f549ac2b266baf94b8b1'),
(7, 'gun20', 'Bagus Gunawan', '827ccb0eea8a706c4c34a16891f84e7b'),
(8, 'sidang01', 'Danamukti Satrio W', '827ccb0eea8a706c4c34a16891f84e7b'),
(9, 'Le2adv', 'Herman Dwi', 'b2843ccc859fc77144e256e843fc1eb5');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_ciri`
--
ALTER TABLE `tbl_ciri`
  ADD PRIMARY KEY (`id_ciri`);

--
-- Indeks untuk tabel `tbl_pakar`
--
ALTER TABLE `tbl_pakar`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tbl_penyakit_solusi`
--
ALTER TABLE `tbl_penyakit_solusi`
  ADD PRIMARY KEY (`id_ps`);

--
-- Indeks untuk tabel `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_ciri`
--
ALTER TABLE `tbl_ciri`
  MODIFY `id_ciri` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `tbl_pakar`
--
ALTER TABLE `tbl_pakar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `tbl_penyakit_solusi`
--
ALTER TABLE `tbl_penyakit_solusi`
  MODIFY `id_ps` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
