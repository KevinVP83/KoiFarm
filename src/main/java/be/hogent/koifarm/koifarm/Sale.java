package be.hogent.koifarm.koifarm;

import java.math.BigDecimal;
import java.util.*;

public class Sale {
    private Set<SaleItem> saleItems = new HashSet<>();

    public void addSaleItem(SaleItem saleItem) {
        saleItems.add(saleItem);
    }

    public void addSaleItems(Map<Koi,BigDecimal> saleItems1) {
        for (Map.Entry<Koi, BigDecimal> entry : saleItems1.entrySet())  {
            saleItems.add(new SaleItem(entry.getKey(),entry.getValue()));
        }
    }

    public Set<SaleItem> getTransactions() {
        return saleItems;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal result = new BigDecimal(0);
        for (SaleItem saleItem : saleItems) {
            result = result.add(saleItem.getPrice());
        }
        return result;
    }

    public Set getSoldKois() {
        Set<Koi> soldKois = new TreeSet<>();
        for (SaleItem saleItem :saleItems) {
            soldKois.add(saleItem.getKoi());
        }
        return soldKois;
    }
}
