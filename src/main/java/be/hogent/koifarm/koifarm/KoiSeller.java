package be.hogent.koifarm.koifarm;

import java.util.ArrayList;
import java.util.List;

public class KoiSeller extends Person{
    private List<Sale> sales = new ArrayList<>();

    public KoiSeller(String name) {
        super(name);
    }

    public List<Sale> getCompletedSales() {
        return sales;
    }
}


