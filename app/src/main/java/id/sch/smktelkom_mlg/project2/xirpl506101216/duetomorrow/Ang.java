package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

public class Ang {
    private long id3;
    private String jamke3;
    private String nama_pelajaran3;

    public Ang() {

    }

    public long getId3() {
        return id3;
    }


    public void setId2(long id3) {
        this.id3 = id3;
    }

    public String getJamke3() {
        return jamke3;
    }

    public void setJamke3(String jamke3) {
        this.jamke3 = jamke3;
    }

    public String getNama_pelajaran3() {
        return nama_pelajaran3;
    }

    public void setNama_pelajaran3(String nama_pelajaran3) {
        this.nama_pelajaran3 = nama_pelajaran3;
    }

    @Override
    public String toString() {
        return "Jam Ke- " + jamke3 + "   " + nama_pelajaran3;
    }
}
