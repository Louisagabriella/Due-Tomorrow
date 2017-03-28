package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

public class G {

    private long id5;
    private String jamke5;
    private String nama_pelajaran5;

    public G() {

    }

    public long getId5() {
        return id5;
    }


    public void setId5(long id4) {
        this.id5 = id5;
    }

    public String getJamke5() {
        return jamke5;
    }

    public void setJamke5(String jamke5) {
        this.jamke5 = jamke5;
    }

    public String getNama_pelajaran5() {
        return nama_pelajaran5;
    }

    public void setNama_pelajaran5(String nama_pelajaran5) {
        this.nama_pelajaran5 = nama_pelajaran5;
    }

    @Override
    public String toString() {
        return "Jam Ke- " + jamke5 + "   " + nama_pelajaran5;
    }
}
