package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

public class Ng {
    private long id4;
    private String jamke4;
    private String nama_pelajaran4;

    public Ng() {

    }

    public long getId4() {
        return id4;
    }


    public void setId4(long id4) {
        this.id4 = id4;
    }

    public String getJamke4() {
        return jamke4;
    }

    public void setJamke3(String jamke4) {
        this.jamke4 = jamke4;
    }

    public String getNama_pelajaran4() {
        return nama_pelajaran4;
    }

    public void setNama_pelajaran4(String nama_pelajaran4) {
        this.nama_pelajaran4 = nama_pelajaran4;
    }

    @Override
    public String toString() {
        return "Jam Ke- " + jamke4 + "   " + nama_pelajaran4;
    }
}
