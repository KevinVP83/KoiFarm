package be.hogent.koifarm.koifarm;

import java.math.BigDecimal;

public class SaleItem {
    private Koi koi;
    private BigDecimal price;

    public SaleItem(Koi koi, BigDecimal price) {
        this.koi = koi;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Koi getKoi() {
        return koi;
    }
}
