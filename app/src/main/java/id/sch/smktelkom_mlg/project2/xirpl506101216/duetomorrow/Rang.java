package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

public class Rang {
    private long id2;
    private String jamke2;
    private String nama_pelajaran2;

    public Rang() {

    }

    public long getId2() {
        return id2;
    }


    public void setId2(long id2) {
        this.id2 = id2;
    }

    public String getJamke2() {
        return jamke2;
    }

    public void setJamke2(String jamke2) {
        this.jamke2 = jamke2;
    }

    public String getNama_pelajaran2() {
        return nama_pelajaran2;
    }

    public void setNama_pelajaran2(String nama_pelajaran2) {
        this.nama_pelajaran2 = nama_pelajaran2;
    }

    @Override
    public String toString() {
        return "Jam Ke- " + jamke2 + "   " + nama_pelajaran2;
    }
}
