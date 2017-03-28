package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

/**
 * Created by Louisa on 3/28/2017.
 */

public class Arang {
    private long id1;
    private String jamke1;
    private String nama_pelajaran1;

    public Arang() {

    }

    /**
     * @return the id
     */
    public long getId1() {
        return id1;
    }


    public void setId1(long id1) {
        this.id1 = id1;
    }

    public String getJamke1() {
        return jamke1;
    }

    public void setJamke1(String jamke1) {
        this.jamke1 = jamke1;
    }

    public String getNama_pelajaran1() {
        return nama_pelajaran1;
    }

    public void setNama_pelajaran1(String nama_pelajaran1) {
        this.nama_pelajaran1 = nama_pelajaran1;
    }

    @Override
    public String toString() {
        return "Jam Ke- " + jamke1 + "   " + nama_pelajaran1;
    }
}
