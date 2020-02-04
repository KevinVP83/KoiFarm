package be.hogent.koifarm.koifarm;

import java.util.*;

public class KoiKeeper extends Person{
    private Set kois = new HashSet();

    public KoiKeeper(String name) {
        super(name);
    }

    public Set<Koi> getKois() {
        return kois;
    }

    public void addKoi(Koi koi) {
        kois.add(koi);
    }

    public void addKois(Collection<Koi> newKois) {
        kois.addAll(newKois);
    }

    public Set getKoisSortedByOrigin () {
        Set koiList = new TreeSet<Koi>(new KoiComparator());
        koiList.addAll(kois);
        return Collections.unmodifiableSet(koiList);
    }

    public class KoiComparator implements Comparator<Koi> {
        @Override
        public int compare(Koi koi, Koi koi1) {
            if ((koi.getKoiOrigin().compareTo(koi1.getKoiOrigin())) != 0) {
                return koi.getKoiOrigin().compareTo(koi1.getKoiOrigin());
            }
            return koi.getKoiBranch().compareTo(koi1.getKoiBranch());
        }
    }
}
