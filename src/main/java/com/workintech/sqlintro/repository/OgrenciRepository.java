package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    // 1) Öğrenci tablosundaki tüm kayıtları listeleyin.
    String QUESTION_1 =
            "SELECT * FROM ogrenci";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    // 2) Kız öğrencileri listeleyin. (şemada cinsiyet: 'K' / 'E')
    String QUESTION_2 =
            "SELECT * FROM ogrenci WHERE cinsiyet = 'K'";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    // 3) Sınıfları her biri bir kez görünecek şekilde listeleyin
    String QUESTION_3 =
            "SELECT DISTINCT sinif FROM ogrenci ORDER BY sinif";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    // 4) 10A sınıfındaki kız öğrenciler
    String QUESTION_4 =
            "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    // 5) Numarası 5–10 arası olan kız öğrenciler
    String QUESTION_5 =
            "SELECT * FROM ogrenci WHERE ogrno BETWEEN 5 AND 10 AND cinsiyet = 'K'";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // 6) Öğrencileri adına göre alfabetik sırala
    String QUESTION_6 =
            "SELECT * FROM ogrenci ORDER BY ad ASC, soyad ASC";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // 7) 10A öğrencilerini okul numarasına göre azalan sırala
    String QUESTION_7 =
            "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    // 8) En genç öğrenci (dtarih TEXT → timestamp'e cast)
    String QUESTION_8 =
            "SELECT * FROM ogrenci ORDER BY dtarih::timestamp DESC LIMIT 1";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    // 9) En yaşlı öğrenci
    String QUESTION_9 =
            "SELECT * FROM ogrenci ORDER BY dtarih::timestamp ASC LIMIT 1";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    // 10) Adının ikinci harfi 'E' olan öğrenciler
    String QUESTION_10 =
            "SELECT * FROM ogrenci WHERE UPPER(ad) LIKE '_E%'";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}