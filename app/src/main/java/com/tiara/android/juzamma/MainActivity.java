package com.tiara.android.juzamma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tiara.android.juzamma.R;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent b = new Intent(getApplicationContext(),Menu.class);
        startActivity(b);
        finish();
    }

    ListView listView;

    String nama_surat [] = {
            "An-naba (Berita Besar)", "An-nazi'at (Malaikat Yang Mencabut)","Abasa (Bermuka Masam)","At-takwir (Menggulung)","Al-infithar (Terbelah)",
            "Al-muthafifin (Orang-Orang Yang Curang)","Al-insyiqaq (Terbelah)","Al-buruj (Gugusan Bintang)","At-thariq (Yang Datang Dimalam Hari)",
            "Al-a'la (Yang Paling Tinggi)","Al-ghasyiyyah (Hari Pembalasan )","Al-fajr (Fajar)","Al-balad (Negri)","As-syams (Matahari)",
            "Al-lail (Malam)","Ad-duha (Waktu Duha)","Al-insyirah (Melapangkan)","At-tin (Buah Tin)","Al-alaq (Segumpal Darah)","Al-qadr (Kemuliaan)",
            "Al-bayyinah (Pembuktian)","Al-zalzalah (Kegoncangan)","Al-'adiyat (Berlari Kencang)","Al-qari'ah (Hari Kiamat)","At-takatsur (Bermegah-Megahan)",
            "Al-ashr (Masa/Waktu)","Al-humazah (Pengumpat)","Al-fil (Gajah)","Al-quraisy (Kaum Quraisy)","Al-maun (Barang-Barang Yang Berguna)",
            "Al-kautsar (Nikmat Yang Berlimpah)","Al-kafirun (Orang-Orang Kafir)","An-nasr (Pertolongan)","Al-lahab (Gejolak Api)","Al-ikhlas ( Orang-Orang Ikhlas)",
            "Al-falaq (Waktu Subuh)","An-nas (Manusia)"
    };

    String isi_surat [] = {
            String.valueOf(R.string.annaba), String.valueOf(R.string.annaziat), String.valueOf(R.string.abasa), String.valueOf(R.string.attakwir), String.valueOf(R.string.alinfithar),
            String.valueOf(R.string.almuthafifin),String.valueOf(R.string.alinsyiqaq),String.valueOf(R.string.alburuj),String.valueOf(R.string.atthoriq),
            String.valueOf(R.string.alala),String.valueOf(R.string.alghasyiah),String.valueOf(R.string.alfajr),String.valueOf(R.string.albalad),
            String.valueOf(R.string.assyams),String.valueOf(R.string.allail),String.valueOf(R.string.adduha),String.valueOf(R.string.alinsyirah),
            String.valueOf(R.string.attin),String.valueOf(R.string.alalaq),String.valueOf(R.string.alqadr),String.valueOf(R.string.albayyinah),
            String.valueOf(R.string.alzalzalah),String.valueOf(R.string.aladiyat),String.valueOf(R.string.alqoriah),String.valueOf(R.string.attakatsur),
            String.valueOf(R.string.alasr),String.valueOf(R.string.alhumazah),String.valueOf(R.string.alfil),String.valueOf(R.string.alquraisy),
            String.valueOf(R.string.almaun),String.valueOf(R.string.alkautsar),String.valueOf(R.string.alkafirun),String.valueOf(R.string.annashr),
            String.valueOf(R.string.allahab),String.valueOf(R.string.alikhlas),String.valueOf(R.string.alfalaq),String.valueOf(R.string.annas)
    };
    int suara_surat [] = {
            R.raw.an_naba,R.raw.an_naziat,R.raw.abasa,R.raw.at_takwir,R.raw.al_infithar,R.raw.al_muthafifin,R.raw.al_insyiqaq,
            R.raw.al_buruj,R.raw.at_thariq,R.raw.al_ala,R.raw.al_ghasyiyah,R.raw.al_fajr,R.raw.al_balad,R.raw.as_syams,R.raw.al_lail,
            R.raw.ad_duha,R.raw.al_insyirah,R.raw.at_tin,R.raw.al_alaq,R.raw.al_qadr,R.raw.al_bayinah,R.raw.al_zalzalah,R.raw.al_adiyat,
            R.raw.al_qariah,R.raw.at_takatsur,R.raw.al_asr,R.raw.al_humazah,R.raw.al_fil,R.raw.al_quraisy,R.raw.al_maun,R.raw.al_kautsar,
            R.raw.al_kafirun,R.raw.an_nashr,R.raw.al_lahab,R.raw.al_ikhlas,R.raw.al_falaq,R.raw.an_nas
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listjuzamma);

        Adapter adapterListJuzAmma = new Adapter(this,nama_surat,isi_surat, suara_surat);
        listView.setAdapter(adapterListJuzAmma);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent a = new Intent(getApplicationContext(), Detail_Activity.class);
                a.putExtra("nama", nama_surat[position]);
                int s = suara_surat[position];
                a.putExtra("suara", s);
                a.putExtra("isi",isi_surat[position]);
                startActivity(a);
                finish();

            }
        });
    }
}
