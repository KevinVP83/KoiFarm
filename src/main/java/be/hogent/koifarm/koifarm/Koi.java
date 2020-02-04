package be.hogent.koifarm.koifarm;

import java.util.Objects;

public class Koi implements Comparable<Koi>{
    private int koiId;
    private static int koiCount= 1;
    private KoiOrigin koiOrigin;
    private KoiBranch koiBranch;

    public KoiOrigin getKoiOrigin() {
        return koiOrigin;
    }

    public KoiBranch getKoiBranch() {
        return koiBranch;
    }

    public int CreateId(){
        this.koiId = koiCount;
        koiCount++;
        return koiId;
    }

    public Koi(KoiOrigin koiOrigin, KoiBranch koiBranch) {
        CreateId();
        this.koiBranch = koiBranch;
        this.koiOrigin = koiOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Koi koi = (Koi) o;
        return koiId == koi.koiId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(koiId);
    }

    @Override
    public int compareTo(Koi koi) {
        int comp = this.getKoiOrigin().compareTo((koi.getKoiOrigin()));
        if (comp !=0){
            return comp;
        }
        return this.getKoiBranch().compareTo(koi.getKoiBranch());
    }
}

